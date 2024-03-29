package org.veterinaria.dominio.servicio.cliente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.veterinaria.aplicacion.puertos.salida.cliente.IClienteRepositorio;
import org.veterinaria.aplicacion.puertos.salida.login.ILoginClienteRepositorio;
import org.veterinaria.dominio.modelo.cliente.*;
import org.veterinaria.dominio.modelo.mascota.Mascota;
import org.veterinaria.dominio.modelo.mascota.MascotaSalida;
import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoSalida;
import org.veterinaria.dominio.servicio.login.PasswordUtils;
import org.veterinaria.dominio.servicio.tipodocumento.ITipoDocumentoServicio;
import org.veterinaria.infraestructura.adaptador.salida.cita.CitaAPI;
import org.veterinaria.infraestructura.adaptador.salida.excepciones.ClienteNotFoundException;
import org.veterinaria.infraestructura.adaptador.salida.geolocalizacion.GeolocalizacionAPI;
import org.veterinaria.infraestructura.adaptador.salida.mascota.MascotaAPI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class ClienteServicio implements IClienteServicio {
  public static final String DOG = "canino";
  public static final String LABEL_CAT = "https://res.cloudinary.com/dmaoa8dcd/image/upload/v1703366448/Appomsv/gato_yp3qhq.png";
  public static final String LABEL_DOG = "https://res.cloudinary.com/dmaoa8dcd/image/upload/v1703366514/Appomsv/perro_dpuugt.png";
  private final IClienteRepositorio repositorio;
  private final ITipoDocumentoServicio tipoDocumentoServicio;
  private final ILoginClienteRepositorio loginClienteRepositorio;
  private final MascotaAPI userService;
  private final CitaAPI clienteService;
  private final GeolocalizacionAPI geolocalizacionAPI;

  @Inject
  public ClienteServicio(IClienteRepositorio repositorio, ITipoDocumentoServicio tipoDocumentoServicio,
                         ILoginClienteRepositorio loginClienteRepositorio, @RestClient MascotaAPI userService, @RestClient CitaAPI clienteService, @RestClient GeolocalizacionAPI geolocalizacionAPI) {
    this.repositorio = repositorio;
    this.tipoDocumentoServicio = tipoDocumentoServicio;
    this.loginClienteRepositorio = loginClienteRepositorio;
    this.userService = userService;
    this.clienteService = clienteService;
    this.geolocalizacionAPI = geolocalizacionAPI;
  }

  @Override
  public List<ClienteSalida> obtenerCliente() {
    List<ClienteEntidad> clientes = repositorio.obtenerTodosCliente();
    return clientes.stream().map(this::getClienteSalida).toList();
  }

  @Override
  public ClienteSalida obtenerSoloClientePorId(String idCliente) {
    ClienteEntidad clienteEntidad;
    try {
      clienteEntidad = repositorio.obtenerClientePorId(idCliente);
    } catch (ClienteNotFoundException e) {
      throw new ClienteNotFoundException(idCliente);
    }
    return getSoloClienteSalida(clienteEntidad);
  }

  @Override
  public ClienteSalida obtenerClientePorId(String idCliente) {
    ClienteEntidad clienteEntidad;
    try {
      clienteEntidad = repositorio.obtenerClientePorId(idCliente);
    } catch (ClienteNotFoundException e) {
      throw new ClienteNotFoundException(idCliente);
    }
    return getClienteSalida(clienteEntidad);
  }

  @Override
  public ClienteSalida crearCliente(ClienteCrear cliente) {
    if (!cliente.getPassword().equals(cliente.getConfirmarPassword()))
      return new ClienteSalida();
    cliente.prepare(cliente.getPassword());
    ClienteEntidad clienteEntidad = crearClienteEntidad(cliente.getNombres(), cliente.getApellidos(), cliente.getCelular(), cliente.getFijo(), cliente.getEmail(), cliente.getIdTipoDocumento(), cliente.getDocumento());
    clienteEntidad.setPassword(cliente.getPassword());
    clienteEntidad = repositorio.crearCliente(clienteEntidad);
    return this.obtenerClientePorId(clienteEntidad.id.toString());
  }

  @Override
  public ClienteSalida actualizarCliente(String idCliente, ClienteActualizar cliente) {
    ClienteEntidad clienteEntidad = crearClienteEntidad(cliente.getNombres(), cliente.getApellidos(),
          cliente.getCelular(), cliente.getFijo(), null, cliente.getIdTipoDocumento(), cliente.getDocumento());
    try {
      repositorio.actualizarCliente(idCliente, clienteEntidad);
    } catch (ClienteNotFoundException e) {
      throw new ClienteNotFoundException(idCliente);
    }
    return this.obtenerClientePorId(idCliente);
  }

  @Override
  public ClienteSalida eliminarCliente(String idCliente) {
    ClienteEntidad clienteEntidad;
    try {
      clienteEntidad = repositorio.eliminarCliente(idCliente);
    } catch (ClienteNotFoundException e) {
      throw new ClienteNotFoundException(idCliente);
    }
    return getClienteSalida(clienteEntidad);
  }


  @Override
  public ClienteSalida agregarMascota(String idCliente, List<String> idMascota) {
    ClienteEntidad cliente = repositorio.obtenerClientePorId(idCliente);
    List<String> mascotas;
    if (cliente.getIdMascotas() == null)
      mascotas = new ArrayList<>();
    else
      mascotas = cliente.getIdMascotas();
    Set<String> set = new HashSet<>(mascotas);
    set.addAll(idMascota);
    mascotas = new ArrayList<>(set);
    cliente.setIdMascotas(mascotas);
    repositorio.actualizarCliente(idCliente, cliente);
    return this.obtenerClientePorId(idCliente);
  }

  @Override
  public ClienteSalida actualizarPasswordCliente(String idCliente, ClienteActualizarPassword cliente) {
    // Validar que la contraseña es correcta
    String email = this.obtenerClientePorId(idCliente).getEmail();
    ClienteEntidad clienteEntidad = loginClienteRepositorio.findByEmailCliente(email);
    if (cliente == null || !PasswordUtils.checkPassword(cliente.getPassword(), clienteEntidad.getPassword()))
      return null;

    // Validar que la nueva contraseña y la confirmación son iguales
    if (!cliente.getNewPassword().equals(cliente.getConfirmarPassword())) return null;

    // Actualizar contraseña
    cliente.prepare(cliente.getNewPassword());
    clienteEntidad.setPassword(cliente.getNewPassword());

    repositorio.actualizarPassword(idCliente, clienteEntidad);
    return this.obtenerClientePorId(idCliente);
  }

  private ClienteEntidad crearClienteEntidad(String nombres, String apellidos, String celular, String fijo, String email, String idTipoDocumento, String documento) {
    ClienteEntidad clienteEntidad = new ClienteEntidad();
    clienteEntidad.setNombres(nombres);
    clienteEntidad.setApellidos(apellidos);
    clienteEntidad.setCelular(celular);
    clienteEntidad.setFijo(fijo);
    clienteEntidad.setEmail(email);
    clienteEntidad.setIdTipoDocumento(idTipoDocumento);
    clienteEntidad.setDocumento(documento);
    return clienteEntidad;
  }

  private ClienteSalida getSoloClienteSalida(ClienteEntidad clienteEntidad) {
    TipoDocumentoSalida tipoDocumento = tipoDocumentoServicio.obtenerTipoDocumentoPorId(clienteEntidad.getIdTipoDocumento());
    List<Recordatorio> recordatorios = new ArrayList<Recordatorio>();
    return ClienteSalida.builder()
          .id(clienteEntidad.id.toString())
          .nombres(clienteEntidad.getNombres())
          .apellidos(clienteEntidad.getApellidos())
          .celular(clienteEntidad.getCelular())
          .fijo(clienteEntidad.getFijo())
          .email(clienteEntidad.getEmail())
          .tipoDocumento(
                TipoDocumentoSalida.builder()
                      .id(tipoDocumento.getId())
                      .tipoDocumento(tipoDocumento.getTipoDocumento())
                      .build()
          )
          .documento(clienteEntidad.getDocumento())
          .build();
  }

  private ClienteSalida getClienteSalida(ClienteEntidad clienteEntidad) {
    TipoDocumentoSalida tipoDocumento = tipoDocumentoServicio.obtenerTipoDocumentoPorId(clienteEntidad.getIdTipoDocumento());
    List<Recordatorio> recordatorios = new ArrayList<Recordatorio>();
    return ClienteSalida.builder()
          .id(clienteEntidad.id.toString())
          .nombres(clienteEntidad.getNombres())
          .apellidos(clienteEntidad.getApellidos())
          .celular(clienteEntidad.getCelular())
          .fijo(clienteEntidad.getFijo())
          .email(clienteEntidad.getEmail())
          .tipoDocumento(
                TipoDocumentoSalida.builder()
                      .id(tipoDocumento.getId())
                      .tipoDocumento(tipoDocumento.getTipoDocumento())
                      .build()
          )
          .documento(clienteEntidad.getDocumento())
          .mascotas((clienteEntidad.getIdMascotas() != null) ?
                clienteEntidad.getIdMascotas().stream()
                      .map(q -> {
                        Mascota mascota = userService.getMascotaPorId(q);
                        if (mascota.getVacunas() != null && !mascota.getVacunas().isEmpty()) {
                          recordatorios.addAll(mascota.getRecordatorios().parallelStream().map(p -> Recordatorio.builder()
                                .fecha(p.getFecha())
                                .tipo(p.getTipo())
                                .detalle(p.getDetalle())
                                .nombre(mascota.getNombre() + " " + mascota.getApellido())
                                .build()).toList());
                        }
                        return MascotaSalida.builder()
                              .id(mascota.getId())
                              .codIdentificacion(mascota.getCodIdentificacion())
                              .lable((mascota.getEspecie().getEspecie().equals(DOG)) ? LABEL_DOG : LABEL_CAT)
                              .nombre(mascota.getNombre())
                              .apellido(mascota.getApellido())
                              .fechaNacimiento(mascota.getFechaNacimiento())
                              .sexo(mascota.getSexo())
                              .especie(mascota.getEspecie())
                              .raza(mascota.getRaza())
                              .esterilizado(mascota.getEsterilizado())
                              .alergias(mascota.getAlergias())
                              .vacunas(mascota.getVacunas())
                              .foto(mascota.getFoto())
                              .qr(mascota.getQr())
                              .build();
                      })
                      .toList()
                :
                new ArrayList<>()
          )
          .recordatorio(recordatorios)
          .citas(
                clienteService.getCitasPorIdCliente(clienteEntidad.id.toString())
          )
          .geolocalizaciones((clienteEntidad.getIdMascotas() != null) ?
                clienteEntidad.getIdMascotas().stream().map(
                      r -> {
                        Mascota mascota = userService.getMascotaPorId(r);
                        return GeolocalizacionArraySalida.builder()
                              .geolocalizaciones(geolocalizacionAPI.getGeolocalizacionPorIdMascota(r))
                              .mascotaNombre(mascota.getNombre() + " " + mascota.getApellido())
                              .mascotaId(mascota.getId())
                              .build();
                      }
                ).filter(p -> !p.getGeolocalizaciones().isEmpty()).toList()
                : new ArrayList<>())
          .build();
  }
}
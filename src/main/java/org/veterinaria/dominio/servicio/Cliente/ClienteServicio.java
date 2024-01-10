package org.veterinaria.dominio.servicio.Cliente;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.veterinaria.aplicacion.puertos.salida.Cliente.IClienteRepositorio;
import org.veterinaria.aplicacion.puertos.salida.Login.ILoginClienteRepositorio;
import org.veterinaria.dominio.modelo.Cliente.*;
import org.veterinaria.dominio.modelo.Mascota.Mascota;
import org.veterinaria.dominio.modelo.Mascota.MascotaSalida;
import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoSalida;
import org.veterinaria.dominio.servicio.Login.PasswordUtils;
import org.veterinaria.dominio.servicio.TipoDocumento.ITipoDocumentoServicio;
import org.veterinaria.infraestructura.adaptador.salida.Mascota.MascotaAPI;

import java.util.*;

@ApplicationScoped
public class ClienteServicio implements IClienteServicio {
  @Inject
  IClienteRepositorio repositorio;
  @Inject
  ITipoDocumentoServicio tipoDocumentoServicio;
  @Inject
  ILoginClienteRepositorio loginClienteRepositorio;
  @Inject
  @RestClient
  MascotaAPI userService;
  @Override
  public ClienteSalida actualizarCliente(String idCliente, ClienteActualizar cliente) {
    ClienteEntidad clienteEntidad = new ClienteEntidad();
    clienteEntidad.setNombres(cliente.getNombres());
    clienteEntidad.setApellidos(cliente.getApellidos());
    clienteEntidad.setCelular(cliente.getCelular());
    clienteEntidad.setFijo(cliente.getFijo());
    clienteEntidad.setEmail(cliente.getEmail());
    clienteEntidad.setIdTipoDocumento(cliente.getIdTipoDocumento());
    clienteEntidad.setDocumento(cliente.getDocumento());
    repositorio.actualizarCliente(idCliente, clienteEntidad);
    return this.obtenerClientePorId(idCliente);
  }

  @Override
  public ClienteSalida crearCliente(ClienteCrear cliente) {
    if (!cliente.getPassword().equals(cliente.getConfirmarPassword()))
      return new ClienteSalida();
    cliente.prepare(cliente.getPassword());
    ClienteEntidad clienteEntidad = new ClienteEntidad();
    clienteEntidad.setNombres(cliente.getNombres());
    clienteEntidad.setApellidos(cliente.getApellidos());
    clienteEntidad.setCelular(cliente.getCelular());
    clienteEntidad.setFijo(cliente.getFijo());
    clienteEntidad.setEmail(cliente.getEmail());
    clienteEntidad.setIdTipoDocumento(cliente.getIdTipoDocumento());
    clienteEntidad.setDocumento(cliente.getDocumento());
    clienteEntidad.setPassword(cliente.getPassword());
    clienteEntidad = repositorio.crearCliente(clienteEntidad);
    return this.obtenerClientePorId(clienteEntidad.getId().toString());
  }

  @Override
  public ClienteSalida eliminarCliente(String idCliente) {
    ClienteEntidad clienteEntidad = repositorio.eliminarCliente(idCliente);
    TipoDocumentoSalida tipoDocumento = tipoDocumentoServicio.obtenerTipoDocumentoPorId(clienteEntidad.getIdTipoDocumento());
    return ClienteSalida.builder()
          .id(clienteEntidad.getId().toString())
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
          .mascotas((clienteEntidad.getIdMascotas() != null)?
                clienteEntidad.getIdMascotas().stream()
                      .map( q -> {
                        Mascota mascota = userService.getMascotaPorId(q);
                        return MascotaSalida.builder()
                              .id(mascota.getId())
                              .codIdentificacion(mascota.getCodIdentificacion())
                              .lable((mascota.getEspecie().getEspecie().equals("canino"))?
                                    "https://res.cloudinary.com/dmaoa8dcd/image/upload/v1703366514/Appomsv/perro_dpuugt.png":
                                    "https://res.cloudinary.com/dmaoa8dcd/image/upload/v1703366448/Appomsv/gato_yp3qhq.png")
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
                null
          )
          .build();
  }

  @Override
  public ClienteSalida obtenerClientePorId(String idCliente) {
    ClienteEntidad clienteEntidad = repositorio.obtenerClientePorId(idCliente);
    TipoDocumentoSalida tipoDocumento = tipoDocumentoServicio.obtenerTipoDocumentoPorId(clienteEntidad.getIdTipoDocumento());
    return ClienteSalida.builder()
          .id(clienteEntidad.getId().toString())
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
          .mascotas((clienteEntidad.getIdMascotas() != null)?
                clienteEntidad.getIdMascotas().stream()
                      .map( q -> {
                        Mascota mascota = userService.getMascotaPorId(q);
                        return MascotaSalida.builder()
                              .id(mascota.getId())
                              .codIdentificacion(mascota.getCodIdentificacion())
                              .lable((mascota.getEspecie().getEspecie().equals("canino"))?
                                    "https://res.cloudinary.com/dmaoa8dcd/image/upload/v1703366514/Appomsv/perro_dpuugt.png":
                                    "https://res.cloudinary.com/dmaoa8dcd/image/upload/v1703366448/Appomsv/gato_yp3qhq.png")
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
                null
          )
          .build();
  }

  @Override
  public List<ClienteSalida> obtenerCliente() {
    List<ClienteEntidad> clientes = repositorio.obtenerTodosCliente();
    return clientes.stream().map(p -> {
      TipoDocumentoSalida tipoDocumento = tipoDocumentoServicio.obtenerTipoDocumentoPorId(p.getIdTipoDocumento());
      return ClienteSalida.builder()
            .id(p.getId().toString())
            .nombres(p.getNombres())
            .apellidos(p.getApellidos())
            .celular(p.getCelular())
            .fijo(p.getFijo())
            .email(p.getEmail())
            .tipoDocumento(
                  TipoDocumentoSalida.builder()
                        .id(tipoDocumento.getId())
                        .tipoDocumento(tipoDocumento.getTipoDocumento())
                        .build()
            )
            .documento(p.getDocumento())
            .mascotas((p.getIdMascotas() != null)?
                  p.getIdMascotas().stream()
                        .map( q -> {
                          Mascota mascota = userService.getMascotaPorId(q);
                          return MascotaSalida.builder()
                                .id(mascota.getId())
                                .codIdentificacion(mascota.getCodIdentificacion())
                                .lable((mascota.getEspecie().getEspecie().equals("canino"))?
                                      "https://res.cloudinary.com/dmaoa8dcd/image/upload/v1703366514/Appomsv/perro_dpuugt.png":
                                      "https://res.cloudinary.com/dmaoa8dcd/image/upload/v1703366448/Appomsv/gato_yp3qhq.png")
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
                        null
            )
            .build();
    }).toList();
  }

  @Override
  public ClienteSalida agregarMascota(String idCliente, List<String> idMascota) {
    ClienteEntidad cliente = repositorio.obtenerClientePorId(idCliente);
    List<String> mascotas;
    if(cliente.getIdMascotas() == null )
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
    if (cliente == null || !PasswordUtils.checkPassword(cliente.getPassword(), clienteEntidad.getPassword())) return null;

    // Validar que la nueva contraseña y la confirmación son iguales
    if (!cliente.getNewPassword().equals(cliente.getConfirmarPassword())) return null;

    // Actualizar contraseña
    cliente.prepare(cliente.getNewPassword());
    clienteEntidad.setPassword(cliente.getNewPassword());

    repositorio.actualizarPassword(idCliente, clienteEntidad);
    return this.obtenerClientePorId(idCliente);
  }
}
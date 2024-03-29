package org.veterinaria.dominio.servicio.veterinario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.login.ILoginVeterinarioRepositorio;
import org.veterinaria.aplicacion.puertos.salida.veterinario.IVeterinarioRepositorio;
import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoSalida;
import org.veterinaria.dominio.modelo.veterinario.*;
import org.veterinaria.dominio.servicio.login.PasswordUtils;
import org.veterinaria.dominio.servicio.tipodocumento.ITipoDocumentoServicio;

import java.util.List;

@ApplicationScoped
public class VeterinarioServicio implements IVeterinarioServicio {
  private final IVeterinarioRepositorio repositorio;
  private final ITipoDocumentoServicio tipoDocumentoServicio;
  private final ILoginVeterinarioRepositorio loginVeterinarioRepositorio;

  @Inject
  public VeterinarioServicio(IVeterinarioRepositorio repositorio,
                             ITipoDocumentoServicio tipoDocumentoServicio,
                             ILoginVeterinarioRepositorio loginVeterinarioRepositorio) {
    this.repositorio = repositorio;
    this.tipoDocumentoServicio = tipoDocumentoServicio;
    this.loginVeterinarioRepositorio = loginVeterinarioRepositorio;
  }

  @Override
  public VeterinarioSalida actualizarVeterinario(String idVeterinario, VeterinarioActualizar veterinario) {
    VeterinarioEntidad veterinarioEntidad = new VeterinarioEntidad();
    veterinarioEntidad.setCodVeterinario(veterinario.getCodVeterinario());
    veterinarioEntidad.setNombres(veterinario.getNombres());
    veterinarioEntidad.setApellidos(veterinario.getApellidos());
    veterinarioEntidad.setCelular(veterinario.getCelular());
    veterinarioEntidad.setFijo(veterinario.getFijo());
    veterinarioEntidad.setEmail(veterinario.getEmail());
    veterinarioEntidad.setIdTipoDocumento(veterinario.getIdTipoDocumento());
    veterinarioEntidad.setDocumento(veterinario.getDocumento());
    repositorio.actualizarVeterinario(idVeterinario, veterinarioEntidad);
    return this.obtenerVeterinarioPorId(idVeterinario);
  }

  @Override
  public VeterinarioSalida crearVeterinario(VeterinarioCrear veterinario) {
    if (!veterinario.getPassword().equals(veterinario.getConfirmarPassword()))
      return new VeterinarioSalida();
    veterinario.prepare(veterinario.getPassword());
    VeterinarioEntidad veterinarioEntidad = new VeterinarioEntidad();
    veterinarioEntidad.setCodVeterinario(veterinario.getCodVeterinario());
    veterinarioEntidad.setNombres(veterinario.getNombres());
    veterinarioEntidad.setApellidos(veterinario.getApellidos());
    veterinarioEntidad.setCelular(veterinario.getCelular());
    veterinarioEntidad.setFijo(veterinario.getFijo());
    veterinarioEntidad.setEmail(veterinario.getEmail());
    veterinarioEntidad.setIdTipoDocumento(veterinario.getIdTipoDocumento());
    veterinarioEntidad.setDocumento(veterinario.getDocumento());
    veterinarioEntidad.setPassword(veterinario.getPassword());
    veterinarioEntidad = repositorio.crearVeterinario(veterinarioEntidad);
    return this.obtenerVeterinarioPorId(veterinarioEntidad.id.toString());
  }

  @Override
  public VeterinarioSalida eliminarVeterinario(String idVeterinario) {
    VeterinarioEntidad veterinarioEntidad = repositorio.eliminarVeterinario(idVeterinario);
    TipoDocumentoSalida tipoDocumento = tipoDocumentoServicio.obtenerTipoDocumentoPorId(veterinarioEntidad.getIdTipoDocumento());
    return VeterinarioSalida.builder()
          .id(veterinarioEntidad.id.toString())
          .codVeterinario(veterinarioEntidad.getCodVeterinario())
          .nombres(veterinarioEntidad.getNombres())
          .apellidos(veterinarioEntidad.getApellidos())
          .celular(veterinarioEntidad.getCelular())
          .fijo(veterinarioEntidad.getFijo())
          .email(veterinarioEntidad.getEmail())
          .tipoDocumento(
                TipoDocumentoSalida.builder()
                      .id(tipoDocumento.getId())
                      .tipoDocumento(tipoDocumento.getTipoDocumento())
                      .build()
          )
          .documento(veterinarioEntidad.getDocumento())
          .build();
  }

  @Override
  public VeterinarioSalida obtenerVeterinarioPorId(String idVeterinario) {
    VeterinarioEntidad veterinarioEntidad = repositorio.obtenerVeterinarioPorId(idVeterinario);
    TipoDocumentoSalida tipoDocumento = tipoDocumentoServicio.obtenerTipoDocumentoPorId(veterinarioEntidad.getIdTipoDocumento());
    return VeterinarioSalida.builder()
          .id(veterinarioEntidad.id.toString())
          .codVeterinario(veterinarioEntidad.getCodVeterinario())
          .nombres(veterinarioEntidad.getNombres())
          .apellidos(veterinarioEntidad.getApellidos())
          .celular(veterinarioEntidad.getCelular())
          .fijo(veterinarioEntidad.getFijo())
          .email(veterinarioEntidad.getEmail())
          .tipoDocumento(
                TipoDocumentoSalida.builder()
                      .id(tipoDocumento.getId())
                      .tipoDocumento(tipoDocumento.getTipoDocumento())
                      .build()
          )
          .documento(veterinarioEntidad.getDocumento())
          .build();
  }

  @Override
  public List<VeterinarioSalida> obtenerVeterinario() {
    List<VeterinarioEntidad> veterinarios = repositorio.obtenerTodosVeterinario();
    return veterinarios.stream().map(p -> {
      TipoDocumentoSalida tipoDocumento = tipoDocumentoServicio.obtenerTipoDocumentoPorId(p.getIdTipoDocumento());
      return VeterinarioSalida.builder()
            .id(p.id.toString())
            .codVeterinario(p.getCodVeterinario())
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
            .build();
    }).toList();
  }

  @Override
  public VeterinarioSalida actualizarPasswordVeterinario(String idVeterinario, VeterinarioActualizarPassword veterinario) {
    // Validar que la contraseña es correcta
    String email = this.obtenerVeterinarioPorId(idVeterinario).getEmail();
    VeterinarioEntidad veterinarioEntidad = loginVeterinarioRepositorio.findByEmailVeterinario(email);
    if (veterinario == null || !PasswordUtils.checkPassword(veterinario.getPassword(), veterinarioEntidad.getPassword()))
      return null;

    // Validar que la nueva contraseña y la confirmación son iguales
    if (!veterinario.getNewPassword().equals(veterinario.getConfirmarPassword())) return null;

    // Actualizar contraseña
    veterinario.prepare(veterinario.getNewPassword());
    veterinarioEntidad.setPassword(veterinario.getNewPassword());

    repositorio.actualizarPassword(idVeterinario, veterinarioEntidad);
    return this.obtenerVeterinarioPorId(idVeterinario);
  }
}
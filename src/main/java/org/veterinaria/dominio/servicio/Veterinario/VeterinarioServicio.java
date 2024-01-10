package org.veterinaria.dominio.servicio.Veterinario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.Login.ILoginVeterinarioRepositorio;
import org.veterinaria.aplicacion.puertos.salida.TipoDocumento.ITipoDocumentoRepositorio;
import org.veterinaria.aplicacion.puertos.salida.Veterinario.IVeterinarioRepositorio;
import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoSalida;
import org.veterinaria.dominio.modelo.Veterinario.*;
import org.veterinaria.dominio.servicio.Login.PasswordUtils;
import org.veterinaria.dominio.servicio.TipoDocumento.ITipoDocumentoServicio;

import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class VeterinarioServicio implements IVeterinarioServicio {
  @Inject
  IVeterinarioRepositorio repositorio;
  @Inject
  ITipoDocumentoRepositorio tipoDocumentoRepositorio;
  @Inject
  ITipoDocumentoServicio tipoDocumentoServicio;
  @Inject
  ILoginVeterinarioRepositorio loginVeterinarioRepositorio;

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
    return this.obtenerVeterinarioPorId(veterinarioEntidad.getId().toString());
  }

  @Override
  public VeterinarioSalida eliminarVeterinario(String idVeterinario) {
    VeterinarioEntidad veterinarioEntidad = repositorio.eliminarVeterinario(idVeterinario);
    TipoDocumentoSalida tipoDocumento = tipoDocumentoServicio.obtenerTipoDocumentoPorId(veterinarioEntidad.getIdTipoDocumento());
    VeterinarioSalida veterinario = VeterinarioSalida.builder()
          .id(veterinarioEntidad.getId().toString())
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
    return veterinario;
  }

  @Override
  public VeterinarioSalida obtenerVeterinarioPorId(String idVeterinario) {
    VeterinarioEntidad veterinarioEntidad = repositorio.obtenerVeterinarioPorId(idVeterinario);
    TipoDocumentoSalida tipoDocumento = tipoDocumentoServicio.obtenerTipoDocumentoPorId(veterinarioEntidad.getIdTipoDocumento());
    VeterinarioSalida veterinario = VeterinarioSalida.builder()
          .id(veterinarioEntidad.getId().toString())
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
    return veterinario;
  }

  @Override
  public List<VeterinarioSalida> obtenerVeterinario() {
    List<VeterinarioEntidad> veterinarios = repositorio.obtenerTodosVeterinario();
    return veterinarios.stream().map(p -> {
      TipoDocumentoSalida tipoDocumento = tipoDocumentoServicio.obtenerTipoDocumentoPorId(p.getIdTipoDocumento());
      return VeterinarioSalida.builder()
            .id(p.getId().toString())
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
    if (veterinario == null || !PasswordUtils.checkPassword(veterinario.getPassword(), veterinarioEntidad.getPassword())) return null;

    // Validar que la nueva contraseña y la confirmación son iguales
    if (!veterinario.getNewPassword().equals(veterinario.getConfirmarPassword())) return null;

    // Actualizar contraseña
    veterinario.prepare(veterinario.getNewPassword());
    veterinarioEntidad.setPassword(veterinario.getNewPassword());

    repositorio.actualizarPassword(idVeterinario, veterinarioEntidad);
    return this.obtenerVeterinarioPorId(idVeterinario);
  }
}
package org.veterinaria.dominio.servicio.peluquero;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.login.ILoginPeluqueroRepositorio;
import org.veterinaria.aplicacion.puertos.salida.peluquero.IPeluqueroRepositorio;
import org.veterinaria.dominio.modelo.peluquero.*;
import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoSalida;
import org.veterinaria.dominio.servicio.login.PasswordUtils;
import org.veterinaria.dominio.servicio.tipodocumento.ITipoDocumentoServicio;

import java.util.List;

@ApplicationScoped
public class PeluqueroServicio implements IPeluqueroServicio {
  @Inject
  IPeluqueroRepositorio repositorio;
  @Inject
  ITipoDocumentoServicio tipoDocumentoServicio;
  @Inject
  ILoginPeluqueroRepositorio loginPeluqueroRepositorio;

  @Override
  public PeluqueroSalida actualizarPeluquero(String idPeluquero, PeluqueroActualizar peluquero) {
    PeluqueroEntidad peluqueroEntidad = new PeluqueroEntidad();
    peluqueroEntidad.setNombres(peluquero.getNombres());
    peluqueroEntidad.setApellidos(peluquero.getApellidos());
    peluqueroEntidad.setCelular(peluquero.getCelular());
    peluqueroEntidad.setFijo(peluquero.getFijo());
    peluqueroEntidad.setEmail(peluquero.getEmail());
    peluqueroEntidad.setIdTipoDocumento(peluquero.getIdTipoDocumento());
    peluqueroEntidad.setDocumento(peluquero.getDocumento());
    repositorio.actualizarPeluquero(idPeluquero, peluqueroEntidad);
    return this.obtenerPeluqueroPorId(idPeluquero);
  }

  @Override
  public PeluqueroSalida crearPeluquero(PeluqueroCrear peluquero) {
    if (!peluquero.getPassword().equals(peluquero.getConfirmarPassword()))
      return new PeluqueroSalida();
    peluquero.prepare(peluquero.getPassword());
    PeluqueroEntidad peluqueroEntidad = new PeluqueroEntidad();
    peluqueroEntidad.setNombres(peluquero.getNombres());
    peluqueroEntidad.setApellidos(peluquero.getApellidos());
    peluqueroEntidad.setCelular(peluquero.getCelular());
    peluqueroEntidad.setFijo(peluquero.getFijo());
    peluqueroEntidad.setEmail(peluquero.getEmail());
    peluqueroEntidad.setIdTipoDocumento(peluquero.getIdTipoDocumento());
    peluqueroEntidad.setDocumento(peluquero.getDocumento());
    peluqueroEntidad.setPassword(peluquero.getPassword());
    peluqueroEntidad = repositorio.crearPeluquero(peluqueroEntidad);
    return this.obtenerPeluqueroPorId(peluqueroEntidad.id.toString());
  }

  @Override
  public PeluqueroSalida eliminarPeluquero(String idPeluquero) {
    PeluqueroEntidad peluqueroEntidad = repositorio.eliminarPeluquero(idPeluquero);
    TipoDocumentoSalida tipoDocumento = tipoDocumentoServicio.obtenerTipoDocumentoPorId(peluqueroEntidad.getIdTipoDocumento());
    PeluqueroSalida cliente = PeluqueroSalida.builder()
          .id(peluqueroEntidad.id.toString())
          .nombres(peluqueroEntidad.getNombres())
          .apellidos(peluqueroEntidad.getApellidos())
          .celular(peluqueroEntidad.getCelular())
          .fijo(peluqueroEntidad.getFijo())
          .email(peluqueroEntidad.getEmail())
          .tipoDocumento(
                TipoDocumentoSalida.builder()
                      .id(tipoDocumento.getId())
                      .tipoDocumento(tipoDocumento.getTipoDocumento())
                      .build()
          )
          .documento(peluqueroEntidad.getDocumento())
          .build();
    return cliente;
  }

  @Override
  public PeluqueroSalida obtenerPeluqueroPorId(String idPeluquero) {
    PeluqueroEntidad peluqueroEntidad = repositorio.obtenerPeluqueroPorId(idPeluquero);
    TipoDocumentoSalida tipoDocumento = tipoDocumentoServicio.obtenerTipoDocumentoPorId(peluqueroEntidad.getIdTipoDocumento());
    PeluqueroSalida peluquero = PeluqueroSalida.builder()
          .id(peluqueroEntidad.id.toString())
          .nombres(peluqueroEntidad.getNombres())
          .apellidos(peluqueroEntidad.getApellidos())
          .celular(peluqueroEntidad.getCelular())
          .fijo(peluqueroEntidad.getFijo())
          .email(peluqueroEntidad.getEmail())
          .tipoDocumento(
                TipoDocumentoSalida.builder()
                      .id(tipoDocumento.getId())
                      .tipoDocumento(tipoDocumento.getTipoDocumento())
                      .build()
          )
          .documento(peluqueroEntidad.getDocumento())
          .build();
    return peluquero;
  }

  @Override
  public List<PeluqueroSalida> obtenerPeluquero() {
    List<PeluqueroEntidad> peluqueros = repositorio.obtenerTodosPeluquero();
    return peluqueros.stream().map(p -> {
      TipoDocumentoSalida tipoDocumento = tipoDocumentoServicio.obtenerTipoDocumentoPorId(p.getIdTipoDocumento());
      PeluqueroSalida peluquero = PeluqueroSalida.builder()
            .id(p.id.toString())
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
      return peluquero;
    }).toList();
  }

  @Override
  public PeluqueroSalida actualizarPasswordPeluquero(String idPeluquero, PeluqueroActualizarPassword peluquero) {
    // Validar que la contraseña es correcta
    String email = this.obtenerPeluqueroPorId(idPeluquero).getEmail();
    PeluqueroEntidad peluqueroEntidad = loginPeluqueroRepositorio.findByEmailPeluquero(email);
    if (peluquero == null || !PasswordUtils.checkPassword(peluquero.getPassword(), peluqueroEntidad.getPassword()))
      return null;

    // Validar que la nueva contraseña y la confirmación son iguales
    if (!peluquero.getNewPassword().equals(peluquero.getConfirmarPassword())) return null;

    // Actualizar contraseña
    peluquero.prepare(peluquero.getNewPassword());
    peluqueroEntidad.setPassword(peluquero.getNewPassword());

    repositorio.actualizarPassword(idPeluquero, peluqueroEntidad);
    return this.obtenerPeluqueroPorId(idPeluquero);
  }
}
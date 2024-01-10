package org.veterinaria.dominio.servicio.TipoDocumento;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.TipoDocumento.ITipoDocumentoRepositorio;
import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoEntidad;
import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoEntrada;
import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoSalida;

import java.util.List;

@ApplicationScoped
public class TipoDocumentoServicio implements ITipoDocumentoServicio {
  @Inject
  ITipoDocumentoRepositorio repositorio;

  @Override
  public TipoDocumentoSalida actualizarTipoDocumento(String idTipoDocumento, TipoDocumentoEntrada tipoDocumento) {
    TipoDocumentoEntidad tipoDocumentoEntidad = new TipoDocumentoEntidad();
    tipoDocumentoEntidad.setTipoDocumento(tipoDocumento.getTipoDocumento());
    repositorio.actualizarTipoDocumento(idTipoDocumento, tipoDocumentoEntidad);
    return this.obtenerTipoDocumentoPorId(idTipoDocumento);
  }

  @Override
  public TipoDocumentoSalida crearTipoDocumento(TipoDocumentoEntrada tipoDocumento) {
    TipoDocumentoEntidad tipoDocumentoEntidad = new TipoDocumentoEntidad();
    tipoDocumentoEntidad.setTipoDocumento(tipoDocumento.getTipoDocumento());
    tipoDocumentoEntidad = repositorio.crearTipoDocumento(tipoDocumentoEntidad);
    return this.obtenerTipoDocumentoPorId(tipoDocumentoEntidad.getId().toString());
  }

  @Override
  public TipoDocumentoSalida eliminarTipoDocumento(String idTipoDocumento) {
    TipoDocumentoEntidad tipoDocumentoEntidad = repositorio.eliminarTipoDocumento(idTipoDocumento);
    return TipoDocumentoSalida.builder()
          .id(tipoDocumentoEntidad.getId().toString())
          .tipoDocumento(tipoDocumentoEntidad.getTipoDocumento())
          .build();
  }

  @Override
  public TipoDocumentoSalida obtenerTipoDocumentoPorId(String idTipoDocumento) {
    TipoDocumentoEntidad tipoDocumentoEntidad = repositorio.obtenerTipoDocumentoPorId(idTipoDocumento);
    return TipoDocumentoSalida.builder()
          .id(tipoDocumentoEntidad.getId().toString())
          .tipoDocumento(tipoDocumentoEntidad.getTipoDocumento())
          .build();
  }

  @Override
  public List<TipoDocumentoSalida> obtenerTipoDocumento() {
    List<TipoDocumentoEntidad> tiposDocumento = repositorio.obtenerTodosTipoDocumento();
    return tiposDocumento.parallelStream().map(p -> TipoDocumentoSalida.builder()
                .id(p.getId().toString())
                .tipoDocumento(p.getTipoDocumento())
                .build())
          .toList();
  }
}

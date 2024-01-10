package org.veterinaria.aplicacion.puertos.salida.TipoDocumento;

import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoEntidad;

import java.util.List;

public interface ITipoDocumentoRepositorio {
  List<TipoDocumentoEntidad> obtenerTodosTipoDocumento();

  TipoDocumentoEntidad obtenerTipoDocumentoPorId(String idTipoDocumento);

  TipoDocumentoEntidad crearTipoDocumento(TipoDocumentoEntidad tipoDocumento);

  TipoDocumentoEntidad actualizarTipoDocumento(String idTipoDocumento, TipoDocumentoEntidad tipoDocumento);

  TipoDocumentoEntidad eliminarTipoDocumento(String idTipoDocumento);
}

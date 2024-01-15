package org.veterinaria.aplicacion.puertos.salida.tipodocumento;

import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoEntidad;

import java.util.List;

public interface ITipoDocumentoRepositorio {
  List<TipoDocumentoEntidad> obtenerTodosTipoDocumento();

  TipoDocumentoEntidad obtenerTipoDocumentoPorId(String idTipoDocumento);

  TipoDocumentoEntidad crearTipoDocumento(TipoDocumentoEntidad tipoDocumento);

  TipoDocumentoEntidad actualizarTipoDocumento(String idTipoDocumento, TipoDocumentoEntidad tipoDocumento);

  TipoDocumentoEntidad eliminarTipoDocumento(String idTipoDocumento);
}

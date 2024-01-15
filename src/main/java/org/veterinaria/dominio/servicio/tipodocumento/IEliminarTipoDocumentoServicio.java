package org.veterinaria.dominio.servicio.tipodocumento;

import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoSalida;

public interface IEliminarTipoDocumentoServicio {
  TipoDocumentoSalida eliminarTipoDocumento(String idTipoDocumento);
}

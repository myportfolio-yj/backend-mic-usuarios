package org.veterinaria.dominio.servicio.TipoDocumento;

import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoSalida;

public interface IEliminarTipoDocumentoServicio {
  TipoDocumentoSalida eliminarTipoDocumento(String idTipoDocumento);
}

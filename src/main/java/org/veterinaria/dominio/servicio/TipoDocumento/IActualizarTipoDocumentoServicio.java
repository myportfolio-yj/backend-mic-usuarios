package org.veterinaria.dominio.servicio.TipoDocumento;

import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoEntrada;
import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoSalida;

public interface IActualizarTipoDocumentoServicio {
  TipoDocumentoSalida actualizarTipoDocumento(String idTipoDocumento, TipoDocumentoEntrada tipoDocumento);
}

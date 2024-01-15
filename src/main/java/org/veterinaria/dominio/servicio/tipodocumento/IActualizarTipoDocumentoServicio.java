package org.veterinaria.dominio.servicio.tipodocumento;

import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoEntrada;
import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoSalida;

public interface IActualizarTipoDocumentoServicio {
  TipoDocumentoSalida actualizarTipoDocumento(String idTipoDocumento, TipoDocumentoEntrada tipoDocumento);
}

package org.veterinaria.dominio.servicio.tipodocumento;

import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoEntrada;
import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoSalida;

public interface ICrearTipoDocumentoServicio {
  TipoDocumentoSalida crearTipoDocumento(TipoDocumentoEntrada tipoDocumento);
}

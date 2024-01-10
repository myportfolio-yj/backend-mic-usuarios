package org.veterinaria.dominio.servicio.TipoDocumento;

import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoEntrada;
import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoSalida;

public interface ICrearTipoDocumentoServicio {
  TipoDocumentoSalida crearTipoDocumento(TipoDocumentoEntrada tipoDocumento);
}

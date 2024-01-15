package org.veterinaria.dominio.servicio.tipodocumento;

import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoSalida;

import java.util.List;

public interface IObtenerTipoDocumentoServicio {
  List<TipoDocumentoSalida> obtenerTipoDocumento();
}

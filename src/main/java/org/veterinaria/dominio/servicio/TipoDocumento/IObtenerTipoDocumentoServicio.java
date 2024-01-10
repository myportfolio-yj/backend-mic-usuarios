package org.veterinaria.dominio.servicio.TipoDocumento;

import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoSalida;

import java.util.List;

public interface IObtenerTipoDocumentoServicio {
  List<TipoDocumentoSalida> obtenerTipoDocumento();
}

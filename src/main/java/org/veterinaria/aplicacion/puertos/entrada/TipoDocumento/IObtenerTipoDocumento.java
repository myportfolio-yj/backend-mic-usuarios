package org.veterinaria.aplicacion.puertos.entrada.TipoDocumento;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tipodocumento")
public interface IObtenerTipoDocumento {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Response getTiposDocumento();
}

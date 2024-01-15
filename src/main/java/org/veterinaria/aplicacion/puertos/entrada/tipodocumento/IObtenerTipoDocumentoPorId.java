package org.veterinaria.aplicacion.puertos.entrada.tipodocumento;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tipodocumento")
public interface IObtenerTipoDocumentoPorId {
  @GET
  @Path("/{idTipoDocumento}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getTiposDocumentoPorId(@PathParam("idTipoDocumento") String idTipoDocumento);
}

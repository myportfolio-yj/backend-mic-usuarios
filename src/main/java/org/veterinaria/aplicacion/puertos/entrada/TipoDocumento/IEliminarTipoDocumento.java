package org.veterinaria.aplicacion.puertos.entrada.TipoDocumento;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tipodocumento")
public interface IEliminarTipoDocumento {
  @DELETE
  @Path("/{idTipoDocumento}")
  @Produces(MediaType.APPLICATION_JSON)
  Response deleteTipoDocumento(@PathParam("idTipoDocumento") String idTipoDocumento);
}

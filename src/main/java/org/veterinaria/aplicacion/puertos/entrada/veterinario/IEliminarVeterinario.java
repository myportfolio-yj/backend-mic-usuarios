package org.veterinaria.aplicacion.puertos.entrada.veterinario;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/veterinario")
public interface IEliminarVeterinario {
  @DELETE
  @Path("/{idVeterinario}")
  @Produces(MediaType.APPLICATION_JSON)
  Response deleteVeterinario(@PathParam("idVeterinario") String idVeterinario);
}

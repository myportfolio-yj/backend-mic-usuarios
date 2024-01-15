package org.veterinaria.aplicacion.puertos.entrada.veterinario;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/veterinario")
public interface IObtenerVeterinarioPorId {
  @GET
  @Path("/{idVeterinario}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getVeterinarioPorId(@PathParam("idVeterinario") String idVeterinario);
}

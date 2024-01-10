package org.veterinaria.aplicacion.puertos.entrada.Veterinario;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/veterinario")
public interface IObtenerVeterinario {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Response getVeterinario();
}

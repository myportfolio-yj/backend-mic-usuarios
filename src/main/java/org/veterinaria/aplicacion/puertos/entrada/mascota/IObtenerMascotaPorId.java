package org.veterinaria.aplicacion.puertos.entrada.mascota;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/mascota")
public interface IObtenerMascotaPorId {
  @GET
  @Path("/{idMascota}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getMascotaPorId(@PathParam("idMascota") String idMascota);
}

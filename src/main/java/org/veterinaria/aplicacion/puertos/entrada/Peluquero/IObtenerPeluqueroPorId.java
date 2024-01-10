package org.veterinaria.aplicacion.puertos.entrada.Peluquero;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/peluquero")
public interface IObtenerPeluqueroPorId {
  @GET
  @Path("/{idPeluquero}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getPeluqueroPorId(@PathParam("idPeluquero") String idPeluquero);
}

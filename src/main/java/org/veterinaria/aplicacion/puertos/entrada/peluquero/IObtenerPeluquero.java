package org.veterinaria.aplicacion.puertos.entrada.peluquero;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/peluquero")
public interface IObtenerPeluquero {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Response getPeluquero();
}

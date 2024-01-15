package org.veterinaria.aplicacion.puertos.entrada.cliente;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
public interface IObtenerCliente {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Response getCliente();
}

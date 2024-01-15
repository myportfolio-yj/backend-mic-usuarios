package org.veterinaria.aplicacion.puertos.entrada.cliente;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
public interface IEliminarCliente {
  @DELETE
  @Path("/{idCliente}")
  @Produces(MediaType.APPLICATION_JSON)
  Response deleteCliente(@PathParam("idCliente") String idCliente);
}

package org.veterinaria.aplicacion.puertos.entrada.cliente;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.cliente.ClienteActualizar;

@Path("/cliente")
public interface IActualizarCliente {
  @PUT
  @Path("/{idCliente}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putCliente(@PathParam("idCliente") String idCliente, ClienteActualizar cliente);
}

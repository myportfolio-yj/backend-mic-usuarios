package org.veterinaria.aplicacion.puertos.entrada.cliente;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.cliente.ClienteActualizarPassword;

@Path("/cliente-password")
public interface IActualizarPasswordCliente {
  @PUT
  @Path("/{idCliente}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putClientePassword(@PathParam("idCliente") String idCliente, ClienteActualizarPassword cliente);
}

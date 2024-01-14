package org.veterinaria.aplicacion.puertos.entrada.Cliente;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.Cliente.ClienteActualizarPassword;

@Path("/cliente-password")
public interface IActualizarPasswordCliente {
  @PUT
  @Path("/{idCliente}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putClientePassword(@PathParam("idCliente") String idCliente, ClienteActualizarPassword cliente);
}

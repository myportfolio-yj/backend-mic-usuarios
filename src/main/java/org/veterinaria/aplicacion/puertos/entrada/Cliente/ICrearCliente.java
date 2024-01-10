package org.veterinaria.aplicacion.puertos.entrada.Cliente;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.Cliente.ClienteCrear;

@Path("/cliente")
public interface ICrearCliente {
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response postCliente(ClienteCrear cliente);
}

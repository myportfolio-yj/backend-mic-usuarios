package org.veterinaria.aplicacion.puertos.entrada.Cliente;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cliente-mascota")
public interface IAgregarMascotaCliente {

  @POST
  @Path("/{idCliente}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response postMascotaCliente(@PathParam("idCliente") String idCliente, List<String> idMascota);
}

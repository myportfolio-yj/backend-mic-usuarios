package org.veterinaria.aplicacion.puertos.entrada.login;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.login.Login;

@Path("/login")
public interface ILoginCliente {
  @POST
  @Path("/cliente")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response loginCliente(Login login);
}

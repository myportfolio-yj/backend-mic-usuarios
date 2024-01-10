package org.veterinaria.aplicacion.puertos.entrada.Login;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.Login.Login;

@Path("/login")
public interface ILoginPeluquero {
  @POST
  @Path("/peluquero")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response loginPeluquero(Login login);
}

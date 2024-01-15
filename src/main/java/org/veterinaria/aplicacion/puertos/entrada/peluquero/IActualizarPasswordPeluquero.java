package org.veterinaria.aplicacion.puertos.entrada.peluquero;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroActualizarPassword;

@Path("/peluquero")
public interface IActualizarPasswordPeluquero {
  @PUT
  @Path("/password/{idPeluquero}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putPeluqueroPassword(@PathParam("idPeluquero") String idPeluquero, PeluqueroActualizarPassword peluquero);
}

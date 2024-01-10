package org.veterinaria.aplicacion.puertos.entrada.Peluquero;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.Peluquero.PeluqueroActualizar;

@Path("/peluquero")
public interface IActualizarPeluquero {
  @PUT
  @Path("/{idPeluquero}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putPeluquero(@PathParam("idPeluquero") String idPeluquero, PeluqueroActualizar peluquero);
}

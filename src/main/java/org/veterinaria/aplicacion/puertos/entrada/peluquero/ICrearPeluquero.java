package org.veterinaria.aplicacion.puertos.entrada.peluquero;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroCrear;

@Path("/peluquero")
public interface ICrearPeluquero {
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response postPeluquero(PeluqueroCrear peluquero);
}

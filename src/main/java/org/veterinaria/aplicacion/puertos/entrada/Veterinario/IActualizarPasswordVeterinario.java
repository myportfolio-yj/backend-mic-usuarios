package org.veterinaria.aplicacion.puertos.entrada.Veterinario;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.Veterinario.VeterinarioActualizarPassword;

@Path("/veterinario")
public interface IActualizarPasswordVeterinario {
  @PUT
  @Path("/password/{idVeterinario}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putVeterinarioPassword(@PathParam("idVeterinario") String idVeterinario, VeterinarioActualizarPassword veterinario);
}

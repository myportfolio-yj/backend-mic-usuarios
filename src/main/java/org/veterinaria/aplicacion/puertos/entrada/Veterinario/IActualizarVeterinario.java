package org.veterinaria.aplicacion.puertos.entrada.Veterinario;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.Veterinario.VeterinarioActualizar;

@Path("/veterinario")
public interface IActualizarVeterinario {
  @PUT
  @Path("/{idVeterinario}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putVeterinario(@PathParam("idVeterinario") String idVeterinario, VeterinarioActualizar veterinario);
}

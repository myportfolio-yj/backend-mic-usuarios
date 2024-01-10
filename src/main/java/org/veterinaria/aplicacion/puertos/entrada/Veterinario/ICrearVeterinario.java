package org.veterinaria.aplicacion.puertos.entrada.Veterinario;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.Veterinario.VeterinarioCrear;

@Path("/veterinario")
public interface ICrearVeterinario {
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response postVeterinario(VeterinarioCrear veterinario);
}

package org.veterinaria.infraestructura.adaptador.salida.Mascota;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.veterinaria.dominio.modelo.Mascota.Mascota;

@Path("/")
@RegisterRestClient
public interface MascotaAPI {

  @GET
  @Path("/mascota/{idMascota}")
  @Produces(MediaType.APPLICATION_JSON)
  Mascota getMascotaPorId(@PathParam("idMascota") String idMascota);

/*
  @GET
  @Path("/mascota")
  @Produces(MediaType.APPLICATION_JSON)
  Set<Mascota> getMascota();
 */

}

package org.veterinaria.infraestructura.adaptador.salida.Cita;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.veterinaria.dominio.modelo.Citas.Cita;

import java.util.List;

@Path("/")
@RegisterRestClient
public interface CitaAPI {
  @GET
  @Path("/cita-vigentes/{idCliente}")
  @Produces(MediaType.APPLICATION_JSON)
  List<Cita> getCitasPorIdCliente(@PathParam("idCliente") String idCliente);
}

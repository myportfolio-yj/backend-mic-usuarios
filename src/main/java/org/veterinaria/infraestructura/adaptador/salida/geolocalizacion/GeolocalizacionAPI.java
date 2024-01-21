package org.veterinaria.infraestructura.adaptador.salida.geolocalizacion;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.veterinaria.dominio.modelo.cliente.GeolocalizacionSalida;

import java.util.List;

@Path("/")
@RegisterRestClient
public interface GeolocalizacionAPI {
  @GET
  @Path("/geolocalizacion-mascota/{idMascota}")
  @Produces(MediaType.APPLICATION_JSON)
  List<GeolocalizacionSalida> getGeolocalizacionPorIdMascota(@PathParam("idMascota") String idCliente);
}

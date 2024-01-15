package org.veterinaria.aplicacion.puertos.entrada.tipodocumento;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoEntrada;

@Path("/tipodocumento")
public interface IActualizarTipoDocumento {
  @PUT
  @Path("/{idTipoDocumento}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putTipoDocumento(@PathParam("idTipoDocumento") String idTipoDocumento, TipoDocumentoEntrada tipoDocumento);
}

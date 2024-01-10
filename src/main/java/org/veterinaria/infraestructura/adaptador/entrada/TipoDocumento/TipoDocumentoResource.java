package org.veterinaria.infraestructura.adaptador.entrada.TipoDocumento;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.TipoDocumento.ITipoDocumentoResource;
import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoEntrada;
import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoSalida;
import org.veterinaria.dominio.servicio.TipoDocumento.ITipoDocumentoServicio;

public class TipoDocumentoResource implements ITipoDocumentoResource {
  @Inject
  ITipoDocumentoServicio servicio;

  @Override
  public Response putTipoDocumento(@NotNull String idTipoDocumento, @Valid TipoDocumentoEntrada tipoDocumento) {
    TipoDocumentoSalida tipoDocumentoActualizado = servicio.actualizarTipoDocumento(idTipoDocumento, tipoDocumento);
    return Response.ok(tipoDocumentoActualizado).build();
  }

  @Override
  public Response postTipoDocumento(@Valid TipoDocumentoEntrada tipoDocumento) {
    TipoDocumentoSalida tipoDocumentoCreado = servicio.crearTipoDocumento(tipoDocumento);
    return Response.status(Response.Status.CREATED).entity(tipoDocumentoCreado).build();
  }

  @Override
  public Response deleteTipoDocumento(@NotNull String idTipoDocumento) {
    TipoDocumentoSalida tipoDocumentoEliminado = servicio.eliminarTipoDocumento(idTipoDocumento);
    return Response.status(Response.Status.CREATED).entity(tipoDocumentoEliminado).build();
  }

  @Override
  public Response getTiposDocumento() {
    return Response.ok(servicio.obtenerTipoDocumento()).build();
  }

  @Override
  public Response getTiposDocumentoPorId(@NotNull String idTipoDocumento) {
    return Response.ok(servicio.obtenerTipoDocumentoPorId(idTipoDocumento)).build();
  }
}

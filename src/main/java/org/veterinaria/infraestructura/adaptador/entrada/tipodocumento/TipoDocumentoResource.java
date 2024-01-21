package org.veterinaria.infraestructura.adaptador.entrada.tipodocumento;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.tipodocumento.ITipoDocumentoResource;
import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoEntrada;
import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoSalida;
import org.veterinaria.dominio.servicio.tipodocumento.ITipoDocumentoServicio;

public class TipoDocumentoResource implements ITipoDocumentoResource {
  private final ITipoDocumentoServicio servicio;

  @Inject
  public TipoDocumentoResource(ITipoDocumentoServicio servicio) {
    this.servicio = servicio;
  }

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

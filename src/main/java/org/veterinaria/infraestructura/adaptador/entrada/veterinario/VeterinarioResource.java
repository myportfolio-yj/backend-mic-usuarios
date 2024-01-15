package org.veterinaria.infraestructura.adaptador.entrada.veterinario;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.veterinario.IVeterinarioResource;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioActualizar;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioActualizarPassword;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioCrear;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioSalida;
import org.veterinaria.dominio.servicio.veterinario.IVeterinarioServicio;

public class VeterinarioResource implements IVeterinarioResource {
  @Inject
  IVeterinarioServicio servicio;

  @Override
  public Response putVeterinario(@NotNull String idVeterinario, @Valid VeterinarioActualizar veterinario) {
    VeterinarioSalida veterinarioActualizado = servicio.actualizarVeterinario(idVeterinario, veterinario);
    return Response.ok(veterinarioActualizado).build();
  }

  @Override
  public Response postVeterinario(@Valid VeterinarioCrear veterinario) {
    VeterinarioSalida veterinarioCreado = servicio.crearVeterinario(veterinario);
    return Response.status(Response.Status.CREATED).entity(veterinarioCreado).build();
  }

  @Override
  public Response deleteVeterinario(@NotNull String idVeterinario) {
    VeterinarioSalida veterinarioEliminado = servicio.eliminarVeterinario(idVeterinario);
    return Response.status(Response.Status.CREATED).entity(veterinarioEliminado).build();
  }

  @Override
  public Response getVeterinario() {
    return Response.ok(servicio.obtenerVeterinario()).build();
  }

  @Override
  public Response getVeterinarioPorId(@NotNull String idVeterinario) {
    return Response.ok(servicio.obtenerVeterinarioPorId(idVeterinario)).build();
  }

  @Override
  public Response putVeterinarioPassword(String idVeterinario, VeterinarioActualizarPassword veterinario) {
    VeterinarioSalida veterinarioEliminado = servicio.actualizarPasswordVeterinario(idVeterinario, veterinario);
    return Response.ok(veterinarioEliminado).build();
  }
}

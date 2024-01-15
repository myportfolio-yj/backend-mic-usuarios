package org.veterinaria.infraestructura.adaptador.entrada.peluquero;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.peluquero.IPeluqueroResource;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroActualizar;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroActualizarPassword;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroCrear;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroSalida;
import org.veterinaria.dominio.servicio.peluquero.IPeluqueroServicio;

public class PeluqueroResource implements IPeluqueroResource {
  @Inject
  IPeluqueroServicio servicio;

  @Override
  public Response putPeluquero(@NotNull String idPeluquero, @Valid PeluqueroActualizar peluquero) {
    PeluqueroSalida peluqueroActualizado = servicio.actualizarPeluquero(idPeluquero, peluquero);
    return Response.ok(peluqueroActualizado).build();
  }

  @Override
  public Response postPeluquero(@Valid PeluqueroCrear peluquero) {
    PeluqueroSalida peluqueroCreado = servicio.crearPeluquero(peluquero);
    return Response.status(Response.Status.CREATED).entity(peluqueroCreado).build();
  }

  @Override
  public Response deletePeluquero(@NotNull String idPeluquero) {
    PeluqueroSalida peluqueroEliminado = servicio.eliminarPeluquero(idPeluquero);
    return Response.status(Response.Status.CREATED).entity(peluqueroEliminado).build();
  }

  @Override
  public Response getPeluquero() {
    return Response.ok(servicio.obtenerPeluquero()).build();
  }

  @Override
  public Response getPeluqueroPorId(@NotNull String idPeluquero) {
    return Response.ok(servicio.obtenerPeluqueroPorId(idPeluquero)).build();
  }

  @Override
  public Response putPeluqueroPassword(String idPeluquero, PeluqueroActualizarPassword peluquero) {
    PeluqueroSalida peluqueroEliminado = servicio.actualizarPasswordPeluquero(idPeluquero, peluquero);
    return Response.ok(peluqueroEliminado).build();
  }
}

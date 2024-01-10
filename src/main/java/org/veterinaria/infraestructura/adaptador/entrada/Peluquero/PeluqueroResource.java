package org.veterinaria.infraestructura.adaptador.entrada.Peluquero;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.Peluquero.IPeluqueroResource;
import org.veterinaria.dominio.modelo.Peluquero.PeluqueroActualizar;
import org.veterinaria.dominio.modelo.Peluquero.PeluqueroActualizarPassword;
import org.veterinaria.dominio.modelo.Peluquero.PeluqueroCrear;
import org.veterinaria.dominio.modelo.Peluquero.PeluqueroSalida;
import org.veterinaria.dominio.modelo.Veterinario.VeterinarioSalida;
import org.veterinaria.dominio.servicio.Peluquero.IPeluqueroServicio;

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

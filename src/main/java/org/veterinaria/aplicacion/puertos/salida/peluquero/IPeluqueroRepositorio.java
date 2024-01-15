package org.veterinaria.aplicacion.puertos.salida.peluquero;

import org.veterinaria.dominio.modelo.peluquero.PeluqueroEntidad;

import java.util.List;

public interface IPeluqueroRepositorio {
  List<PeluqueroEntidad> obtenerTodosPeluquero();

  PeluqueroEntidad obtenerPeluqueroPorId(String idPeluquero);

  PeluqueroEntidad crearPeluquero(PeluqueroEntidad peluquero);

  PeluqueroEntidad actualizarPeluquero(String idPeluquero, PeluqueroEntidad peluquero);

  PeluqueroEntidad eliminarPeluquero(String idPeluquero);

  PeluqueroEntidad actualizarPassword(String idCliente, PeluqueroEntidad peluquero);
}

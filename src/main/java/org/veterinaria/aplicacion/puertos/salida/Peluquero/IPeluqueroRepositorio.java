package org.veterinaria.aplicacion.puertos.salida.Peluquero;

import org.veterinaria.dominio.modelo.Peluquero.PeluqueroEntidad;

import java.util.List;

public interface IPeluqueroRepositorio {
  List<PeluqueroEntidad> obtenerTodosPeluquero();

  PeluqueroEntidad obtenerPeluqueroPorId(String idPeluquero);

  PeluqueroEntidad crearPeluquero(PeluqueroEntidad peluquero);

  PeluqueroEntidad actualizarPeluquero(String idPeluquero, PeluqueroEntidad peluquero);

  PeluqueroEntidad eliminarPeluquero(String idPeluquero);

  PeluqueroEntidad actualizarPassword(String idCliente, PeluqueroEntidad peluquero);
}

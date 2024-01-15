package org.veterinaria.dominio.servicio.peluquero;

import org.veterinaria.dominio.modelo.peluquero.PeluqueroSalida;

import java.util.List;

public interface IObtenerPeluqueroServicio {
  List<PeluqueroSalida> obtenerPeluquero();
}

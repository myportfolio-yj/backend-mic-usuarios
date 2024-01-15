package org.veterinaria.dominio.servicio.peluquero;

import org.veterinaria.dominio.modelo.peluquero.PeluqueroSalida;

public interface IObtenerPeluqueroPorIdServicio {
  PeluqueroSalida obtenerPeluqueroPorId(String idPeluquero);
}

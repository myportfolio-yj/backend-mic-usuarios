package org.veterinaria.dominio.servicio.Peluquero;

import org.veterinaria.dominio.modelo.Peluquero.PeluqueroSalida;

public interface IObtenerPeluqueroPorIdServicio {
  PeluqueroSalida obtenerPeluqueroPorId(String idPeluquero);
}

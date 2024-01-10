package org.veterinaria.dominio.servicio.Peluquero;

import org.veterinaria.dominio.modelo.Peluquero.PeluqueroCrear;
import org.veterinaria.dominio.modelo.Peluquero.PeluqueroSalida;

public interface ICrearPeluqueroServicio {
  PeluqueroSalida crearPeluquero(PeluqueroCrear peluquero);
}

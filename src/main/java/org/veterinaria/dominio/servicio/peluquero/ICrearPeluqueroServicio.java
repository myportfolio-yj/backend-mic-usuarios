package org.veterinaria.dominio.servicio.peluquero;

import org.veterinaria.dominio.modelo.peluquero.PeluqueroCrear;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroSalida;

public interface ICrearPeluqueroServicio {
  PeluqueroSalida crearPeluquero(PeluqueroCrear peluquero);
}

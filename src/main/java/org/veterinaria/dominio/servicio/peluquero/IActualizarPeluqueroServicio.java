package org.veterinaria.dominio.servicio.peluquero;

import org.veterinaria.dominio.modelo.peluquero.PeluqueroActualizar;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroSalida;

public interface IActualizarPeluqueroServicio {
  PeluqueroSalida actualizarPeluquero(String idPeluquero, PeluqueroActualizar peluquero);
}

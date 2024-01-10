package org.veterinaria.dominio.servicio.Peluquero;

import org.veterinaria.dominio.modelo.Peluquero.PeluqueroActualizar;
import org.veterinaria.dominio.modelo.Peluquero.PeluqueroSalida;

public interface IActualizarPeluqueroServicio {
  PeluqueroSalida actualizarPeluquero(String idPeluquero, PeluqueroActualizar peluquero);
}

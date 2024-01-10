package org.veterinaria.dominio.servicio.Peluquero;

import org.veterinaria.dominio.modelo.Peluquero.PeluqueroActualizarPassword;
import org.veterinaria.dominio.modelo.Peluquero.PeluqueroSalida;

public interface IActualizarPasswordPeluqueroServicio {
  PeluqueroSalida actualizarPasswordPeluquero(String idPeluquero, PeluqueroActualizarPassword peluquero);
}

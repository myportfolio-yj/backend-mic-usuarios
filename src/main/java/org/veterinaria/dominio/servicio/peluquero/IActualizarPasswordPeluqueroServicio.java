package org.veterinaria.dominio.servicio.peluquero;

import org.veterinaria.dominio.modelo.peluquero.PeluqueroActualizarPassword;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroSalida;

public interface IActualizarPasswordPeluqueroServicio {
  PeluqueroSalida actualizarPasswordPeluquero(String idPeluquero, PeluqueroActualizarPassword peluquero);
}

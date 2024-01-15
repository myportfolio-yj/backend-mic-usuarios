package org.veterinaria.aplicacion.puertos.salida.login;

import org.veterinaria.dominio.modelo.peluquero.PeluqueroEntidad;

public interface ILoginPeluqueroRepositorio {
  PeluqueroEntidad findByEmailPeluquero(String email);
}

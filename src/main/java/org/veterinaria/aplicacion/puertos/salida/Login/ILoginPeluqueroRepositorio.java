package org.veterinaria.aplicacion.puertos.salida.Login;

import org.veterinaria.dominio.modelo.Peluquero.PeluqueroEntidad;

public interface ILoginPeluqueroRepositorio {
  PeluqueroEntidad findByEmailPeluquero(String email);
}

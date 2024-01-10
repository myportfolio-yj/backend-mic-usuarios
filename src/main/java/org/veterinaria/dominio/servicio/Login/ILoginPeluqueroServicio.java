package org.veterinaria.dominio.servicio.Login;

import org.veterinaria.dominio.modelo.Login.Login;
import org.veterinaria.dominio.modelo.Peluquero.PeluqueroSalida;

public interface ILoginPeluqueroServicio extends ILoginServicio<PeluqueroSalida> {
  PeluqueroSalida login(Login login);
}

package org.veterinaria.dominio.servicio.login;

import org.veterinaria.dominio.modelo.login.Login;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroSalida;

public interface ILoginPeluqueroServicio extends ILoginServicio<PeluqueroSalida> {
  PeluqueroSalida login(Login login);
}

package org.veterinaria.dominio.servicio.login;

import org.veterinaria.dominio.modelo.login.Login;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioSalida;

public interface ILoginVeterinarioServicio extends ILoginServicio<VeterinarioSalida> {
  VeterinarioSalida login(Login login);
}

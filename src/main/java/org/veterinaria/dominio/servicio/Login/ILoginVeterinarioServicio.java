package org.veterinaria.dominio.servicio.Login;

import org.veterinaria.dominio.modelo.Login.Login;
import org.veterinaria.dominio.modelo.Veterinario.VeterinarioSalida;

public interface ILoginVeterinarioServicio extends ILoginServicio<VeterinarioSalida> {
  VeterinarioSalida login(Login login);
}

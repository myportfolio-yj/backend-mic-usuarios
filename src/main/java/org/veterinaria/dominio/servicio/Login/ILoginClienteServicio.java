package org.veterinaria.dominio.servicio.Login;

import org.veterinaria.dominio.modelo.Cliente.ClienteSalida;
import org.veterinaria.dominio.modelo.Login.Login;

public interface ILoginClienteServicio extends ILoginServicio<ClienteSalida> {
  ClienteSalida login(Login login);
}

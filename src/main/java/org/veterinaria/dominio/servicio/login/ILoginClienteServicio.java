package org.veterinaria.dominio.servicio.login;

import org.veterinaria.dominio.modelo.cliente.ClienteSalida;
import org.veterinaria.dominio.modelo.login.Login;

public interface ILoginClienteServicio extends ILoginServicio<ClienteSalida> {
  ClienteSalida login(Login login);
}

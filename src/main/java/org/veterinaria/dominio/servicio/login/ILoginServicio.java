package org.veterinaria.dominio.servicio.login;

import org.veterinaria.dominio.modelo.login.Login;

public interface ILoginServicio<T> {
  T login(Login login);
}

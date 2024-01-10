package org.veterinaria.dominio.servicio.Login;

import org.veterinaria.dominio.modelo.Login.Login;

public interface ILoginServicio<T> {
  T login(Login login);
}

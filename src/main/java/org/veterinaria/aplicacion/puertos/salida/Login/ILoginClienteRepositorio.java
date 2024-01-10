package org.veterinaria.aplicacion.puertos.salida.Login;

import org.veterinaria.dominio.modelo.Cliente.ClienteEntidad;

public interface ILoginClienteRepositorio {
  ClienteEntidad findByEmailCliente(String email);
}

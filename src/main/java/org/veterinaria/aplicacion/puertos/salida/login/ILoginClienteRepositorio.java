package org.veterinaria.aplicacion.puertos.salida.login;

import org.veterinaria.dominio.modelo.cliente.ClienteEntidad;

public interface ILoginClienteRepositorio {
  ClienteEntidad findByEmailCliente(String email);
}

package org.veterinaria.dominio.servicio.cliente;

import org.veterinaria.dominio.modelo.cliente.ClienteActualizarPassword;
import org.veterinaria.dominio.modelo.cliente.ClienteSalida;

public interface IActualizarPasswordClienteServicio {
  ClienteSalida actualizarPasswordCliente(String idCliente, ClienteActualizarPassword cliente);
}

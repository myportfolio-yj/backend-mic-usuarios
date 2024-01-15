package org.veterinaria.dominio.servicio.cliente;

import org.veterinaria.dominio.modelo.cliente.ClienteActualizar;
import org.veterinaria.dominio.modelo.cliente.ClienteSalida;

public interface IActualizarClienteServicio {
  ClienteSalida actualizarCliente(String idCliente, ClienteActualizar cliente);
}

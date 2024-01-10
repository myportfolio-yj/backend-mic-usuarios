package org.veterinaria.dominio.servicio.Cliente;

import org.veterinaria.dominio.modelo.Cliente.ClienteActualizar;
import org.veterinaria.dominio.modelo.Cliente.ClienteSalida;

public interface IActualizarClienteServicio {
  ClienteSalida actualizarCliente(String idCliente, ClienteActualizar cliente);
}

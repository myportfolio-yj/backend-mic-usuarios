package org.veterinaria.dominio.servicio.cliente;

import org.veterinaria.dominio.modelo.cliente.ClienteCrear;
import org.veterinaria.dominio.modelo.cliente.ClienteSalida;

public interface ICrearClienteServicio {
  ClienteSalida crearCliente(ClienteCrear cliente);
}

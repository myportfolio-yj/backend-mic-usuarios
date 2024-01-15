package org.veterinaria.dominio.servicio.cliente;

import org.veterinaria.dominio.modelo.cliente.ClienteSalida;

public interface IEliminarClienteServicio {
  ClienteSalida eliminarCliente(String idCliente);
}

package org.veterinaria.dominio.servicio.Cliente;

import org.veterinaria.dominio.modelo.Cliente.ClienteSalida;

public interface IEliminarClienteServicio {
  ClienteSalida eliminarCliente(String idCliente);
}

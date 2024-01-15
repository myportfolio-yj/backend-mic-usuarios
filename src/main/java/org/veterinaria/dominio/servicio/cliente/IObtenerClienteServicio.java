package org.veterinaria.dominio.servicio.cliente;

import org.veterinaria.dominio.modelo.cliente.ClienteSalida;

import java.util.List;

public interface IObtenerClienteServicio {
  List<ClienteSalida> obtenerCliente();
}

package org.veterinaria.dominio.servicio.Cliente;

import org.veterinaria.dominio.modelo.Cliente.ClienteSalida;

public interface IObtenerClientePorIdServicio {
  ClienteSalida obtenerClientePorId(String idCliente);
}

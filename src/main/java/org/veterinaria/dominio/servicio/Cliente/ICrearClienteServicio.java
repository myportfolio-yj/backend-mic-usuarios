package org.veterinaria.dominio.servicio.Cliente;

import org.veterinaria.dominio.modelo.Cliente.ClienteCrear;
import org.veterinaria.dominio.modelo.Cliente.ClienteSalida;

public interface ICrearClienteServicio {
  ClienteSalida crearCliente(ClienteCrear cliente);
}

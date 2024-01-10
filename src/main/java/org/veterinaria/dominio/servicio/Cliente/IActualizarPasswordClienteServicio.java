package org.veterinaria.dominio.servicio.Cliente;

import org.veterinaria.dominio.modelo.Cliente.ClienteActualizarPassword;
import org.veterinaria.dominio.modelo.Cliente.ClienteSalida;

public interface IActualizarPasswordClienteServicio {
  ClienteSalida actualizarPasswordCliente(String idCliente, ClienteActualizarPassword cliente);
}

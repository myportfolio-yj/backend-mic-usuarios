package org.veterinaria.aplicacion.puertos.salida.Cliente;

import org.veterinaria.dominio.modelo.Cliente.ClienteEntidad;

import java.util.List;

public interface IClienteRepositorio {
  List<ClienteEntidad> obtenerTodosCliente();

  ClienteEntidad obtenerClientePorId(String idCliente);

  ClienteEntidad crearCliente(ClienteEntidad cliente);

  ClienteEntidad actualizarCliente(String idCliente, ClienteEntidad cliente);

  ClienteEntidad eliminarCliente(String idCliente);
  ClienteEntidad actualizarPassword(String idCliente, ClienteEntidad cliente);
}

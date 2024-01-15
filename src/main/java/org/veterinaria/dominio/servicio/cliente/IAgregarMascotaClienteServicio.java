package org.veterinaria.dominio.servicio.cliente;

import org.veterinaria.dominio.modelo.cliente.ClienteSalida;

import java.util.List;

public interface IAgregarMascotaClienteServicio {
  ClienteSalida agregarMascota(String idCliente, List<String> idMascota);
}

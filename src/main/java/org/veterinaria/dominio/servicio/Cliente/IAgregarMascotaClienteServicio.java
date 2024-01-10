package org.veterinaria.dominio.servicio.Cliente;

import org.veterinaria.dominio.modelo.Cliente.ClienteSalida;

import java.util.List;

public interface IAgregarMascotaClienteServicio {
  ClienteSalida agregarMascota(String idCliente, List<String> idMascota);
}

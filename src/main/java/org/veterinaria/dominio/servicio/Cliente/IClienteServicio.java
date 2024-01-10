package org.veterinaria.dominio.servicio.Cliente;

import org.veterinaria.dominio.modelo.Mascota.Mascota;

public interface IClienteServicio extends
      IActualizarClienteServicio,
      IActualizarPasswordClienteServicio,
      ICrearClienteServicio,
      IEliminarClienteServicio,
      IObtenerClienteServicio,
      IObtenerClientePorIdServicio,
      IAgregarMascotaClienteServicio {
}

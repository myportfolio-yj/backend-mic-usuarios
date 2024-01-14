package org.veterinaria.infraestructura.adaptador.entrada.Cliente;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.Cliente.IActualizarPasswordCliente;
import org.veterinaria.dominio.modelo.Cliente.ClienteActualizarPassword;
import org.veterinaria.dominio.modelo.Cliente.ClienteSalida;
import org.veterinaria.dominio.servicio.Cliente.IClienteServicio;

public class ClientePasswordResource implements IActualizarPasswordCliente {
  public static final String CLIENTE_INVALIDO = "ID de cliente inválido";
  @Inject
  IClienteServicio servicio;

  @Override
  public Response putClientePassword(String idCliente, ClienteActualizarPassword cliente) {
    Response errorResponse = validarYObtenerRespuesta(idCliente);
    if (errorResponse != null) return errorResponse;
    ClienteSalida clienteActualizado = servicio.actualizarPasswordCliente(idCliente, cliente);
    return Response.ok(clienteActualizado).build();
  }

  private Boolean validarIdCliente(String idCliente) {
    return idCliente.length() != 24;
  }

  private Response validarYObtenerRespuesta(String idCliente) {
    if (validarIdCliente(idCliente)) {
      return Response.status(Response.Status.BAD_REQUEST).entity(CLIENTE_INVALIDO).build();
    }
    return null;
  }
}

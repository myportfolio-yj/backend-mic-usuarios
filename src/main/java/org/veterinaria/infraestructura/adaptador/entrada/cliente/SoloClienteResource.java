package org.veterinaria.infraestructura.adaptador.entrada.cliente;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.cliente.ISoloClienteResource;
import org.veterinaria.dominio.modelo.cliente.ClienteSalida;
import org.veterinaria.dominio.servicio.cliente.IClienteServicio;
import org.veterinaria.infraestructura.adaptador.salida.excepciones.ClienteNotFoundException;

public class SoloClienteResource implements ISoloClienteResource {
  public static final String CLIENTE_INVALIDO = "ID de cliente inválido";
  private final IClienteServicio servicio;

  @Inject
  public SoloClienteResource(IClienteServicio servicio) {
    this.servicio = servicio;
  }

  @Override
  public Response getClientePorId(String idCliente) {
    Response errorResponse = validarYObtenerRespuesta(idCliente);
    if (errorResponse != null) return errorResponse;
    ClienteSalida cliente;
    try {
      cliente = servicio.obtenerSoloClientePorId(idCliente);
    } catch (ClienteNotFoundException e) {
      return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
    }
    return Response.ok(cliente).build();
  }

  private Response validarYObtenerRespuesta(String idCliente) {
    if (validarIdCliente(idCliente)) {
      return Response.status(Response.Status.BAD_REQUEST).entity(CLIENTE_INVALIDO).build();
    }
    return null;
  }

  private Boolean validarIdCliente(String idCliente) {
    return idCliente.length() != 24;
  }
}

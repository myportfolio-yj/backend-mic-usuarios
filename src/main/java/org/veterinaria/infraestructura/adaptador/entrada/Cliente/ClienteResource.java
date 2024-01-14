package org.veterinaria.infraestructura.adaptador.entrada.Cliente;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.Cliente.IClienteResource;
import org.veterinaria.dominio.modelo.Cliente.ClienteActualizar;
import org.veterinaria.dominio.modelo.Cliente.ClienteCrear;
import org.veterinaria.dominio.modelo.Cliente.ClienteSalida;
import org.veterinaria.dominio.servicio.Cliente.IClienteServicio;
import org.veterinaria.infraestructura.adaptador.salida.Excepciones.ClienteNotFoundException;

public class ClienteResource implements IClienteResource {
  public static final String CLIENTE_INVALIDO = "ID de cliente inválido";
  @Inject
  IClienteServicio servicio;

  @Override
  public Response getCliente() {
    return Response.ok(servicio.obtenerCliente()).build();
  }

  @Override
  public Response getClientePorId(@NotNull String idCliente) {
    Response errorResponse = validarYObtenerRespuesta(idCliente);
    if (errorResponse != null) return errorResponse;
    ClienteSalida cliente;
    try {
      cliente = servicio.obtenerClientePorId(idCliente);
    } catch (ClienteNotFoundException e) {
      return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
    }
    return Response.ok(cliente).build();
  }

  @Override
  public Response postCliente(@Valid ClienteCrear cliente) {
    return Response.status(Response.Status.CREATED).entity(servicio.crearCliente(cliente)).build();
  }

  @Override
  public Response putCliente(@NotNull String idCliente, @Valid ClienteActualizar cliente) {
    Response errorResponse = validarYObtenerRespuesta(idCliente);
    if (errorResponse != null) return errorResponse;
    ClienteSalida clienteSalida;
    try {
      clienteSalida = servicio.actualizarCliente(idCliente, cliente);
    } catch (ClienteNotFoundException e) {
      return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
    }
    return Response.ok(clienteSalida).build();
  }

  @Override
  public Response deleteCliente(@NotNull String idCliente) {
    Response errorResponse = validarYObtenerRespuesta(idCliente);
    if (errorResponse != null) return errorResponse;
    return Response.status(Response.Status.CREATED).entity(servicio.eliminarCliente(idCliente)).build();
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

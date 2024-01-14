package org.veterinaria.infraestructura.adaptador.entrada.Cliente;

import jakarta.inject.Inject;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.Cliente.IClienteMascotaResource;
import org.veterinaria.dominio.servicio.Cliente.IClienteServicio;

import java.util.List;

public class ClienteMascotaResource implements IClienteMascotaResource {
  public static final String CLIENTE_INVALIDO = "ID de cliente inválido";
  @Inject
  IClienteServicio servicio;

  @Override
  public Response postMascotaCliente(@NotNull String idCliente, List<String> idMascota) {
    Response errorResponse = validarYObtenerRespuesta(idCliente);
    if (errorResponse != null) return errorResponse;
    return Response.status(Response.Status.CREATED).entity(servicio.agregarMascota(idCliente, idMascota)).build();
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

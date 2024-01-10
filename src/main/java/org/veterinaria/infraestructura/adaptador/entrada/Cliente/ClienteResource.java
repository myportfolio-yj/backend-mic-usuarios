package org.veterinaria.infraestructura.adaptador.entrada.Cliente;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.Cliente.IClienteResource;
import org.veterinaria.dominio.modelo.Cliente.ClienteActualizar;
import org.veterinaria.dominio.modelo.Cliente.ClienteActualizarPassword;
import org.veterinaria.dominio.modelo.Cliente.ClienteCrear;
import org.veterinaria.dominio.modelo.Cliente.ClienteSalida;
import org.veterinaria.dominio.servicio.Cliente.IClienteServicio;

import java.util.List;

public class ClienteResource implements IClienteResource {
  @Inject
  IClienteServicio servicio;
  @Override
  public Response putCliente(@NotNull String idCliente, @Valid ClienteActualizar cliente) {
    ClienteSalida clienteActualizado = servicio.actualizarCliente(idCliente, cliente);
    return Response.ok(clienteActualizado).build();
  }

  @Override
  public Response postCliente(@Valid ClienteCrear cliente) {
    ClienteSalida clienteCreado = servicio.crearCliente(cliente);
    return Response.status(Response.Status.CREATED).entity(clienteCreado).build();
  }

  @Override
  public Response deleteCliente(@NotNull String idCliente) {
    ClienteSalida clienteEliminado = servicio.eliminarCliente(idCliente);
    return Response.status(Response.Status.CREATED).entity(clienteEliminado).build();
  }

  @Override
  public Response getCliente() {
    return Response.ok(servicio.obtenerCliente()).build();
  }

  @Override
  public Response getClientePorId(@NotNull String idCliente) {
    return Response.ok(servicio.obtenerClientePorId(idCliente)).build();
  }

  @Override
  public Response postMascotaCliente(@NotNull String idCliente, List<String> idMascota) {
    ClienteSalida cliete = servicio.agregarMascota(idCliente, idMascota);
    return Response.status(Response.Status.CREATED).entity(cliete).build();
  }

  @Override
  public Response putClientePassword(String idCliente, ClienteActualizarPassword cliente) {
    ClienteSalida clienteActualizado = servicio.actualizarPasswordCliente(idCliente, cliente);
    return Response.ok(clienteActualizado).build();
  }
}

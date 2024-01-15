package org.veterinaria.infraestructura.adaptador.entrada.login;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.login.ILoginCliente;
import org.veterinaria.aplicacion.puertos.entrada.login.ILoginPeluquero;
import org.veterinaria.aplicacion.puertos.entrada.login.ILoginVeterinario;
import org.veterinaria.dominio.modelo.cliente.ClienteSalida;
import org.veterinaria.dominio.modelo.login.Login;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroSalida;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioSalida;
import org.veterinaria.dominio.servicio.login.ILoginClienteServicio;
import org.veterinaria.dominio.servicio.login.ILoginPeluqueroServicio;
import org.veterinaria.dominio.servicio.login.ILoginVeterinarioServicio;

public class LoginResource implements ILoginCliente, ILoginVeterinario, ILoginPeluquero {
  @Inject
  ILoginClienteServicio loginClienteServicio;
  @Inject
  ILoginPeluqueroServicio loginPeluqueroServicio;
  @Inject
  ILoginVeterinarioServicio loginVeterinarioServicio;

  @Override
  public Response loginCliente(@Valid Login login) {
    ClienteSalida cliente = loginClienteServicio.login(login);
    return Response.status(Response.Status.CREATED).entity(cliente).build();
  }

  @Override
  public Response loginPeluquero(@Valid Login login) {
    PeluqueroSalida peluquero = loginPeluqueroServicio.login(login);
    return Response.status(Response.Status.CREATED).entity(peluquero).build();
  }

  @Override
  public Response loginVeterinario(@Valid Login login) {
    VeterinarioSalida veterinario = loginVeterinarioServicio.login(login);
    return Response.status(Response.Status.CREATED).entity(veterinario).build();
  }
}

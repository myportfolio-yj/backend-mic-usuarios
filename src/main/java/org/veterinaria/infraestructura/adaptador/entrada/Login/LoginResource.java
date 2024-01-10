package org.veterinaria.infraestructura.adaptador.entrada.Login;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.Login.ILoginCliente;
import org.veterinaria.aplicacion.puertos.entrada.Login.ILoginPeluquero;
import org.veterinaria.aplicacion.puertos.entrada.Login.ILoginVeterinario;
import org.veterinaria.dominio.modelo.Cliente.ClienteSalida;
import org.veterinaria.dominio.modelo.Login.Login;
import org.veterinaria.dominio.modelo.Peluquero.PeluqueroSalida;
import org.veterinaria.dominio.modelo.Veterinario.VeterinarioSalida;
import org.veterinaria.dominio.servicio.Login.ILoginClienteServicio;
import org.veterinaria.dominio.servicio.Login.ILoginPeluqueroServicio;
import org.veterinaria.dominio.servicio.Login.ILoginVeterinarioServicio;

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

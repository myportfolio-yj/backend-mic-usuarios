package org.veterinaria.dominio.servicio.login;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.login.ILoginClienteRepositorio;
import org.veterinaria.dominio.modelo.cliente.ClienteEntidad;
import org.veterinaria.dominio.modelo.cliente.ClienteSalida;
import org.veterinaria.dominio.modelo.login.Login;
import org.veterinaria.dominio.servicio.cliente.IClienteServicio;

@ApplicationScoped
public class LoginClienteServicio implements ILoginClienteServicio {
  private final ILoginClienteRepositorio repositorio;
  private final IClienteServicio clienteServicio;

  @Inject
  public LoginClienteServicio(ILoginClienteRepositorio repositorio, IClienteServicio clienteServicio) {
    this.repositorio = repositorio;
    this.clienteServicio = clienteServicio;
  }

  @Override
  public ClienteSalida login(Login login) {
    ClienteEntidad cliente = repositorio.findByEmailCliente(login.getEmail());
    if (cliente != null && PasswordUtils.checkPassword(login.getPassword(), cliente.getPassword())) {
      return clienteServicio.obtenerClientePorId(cliente.id.toString());
    }
    return null;
  }
}

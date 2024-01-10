package org.veterinaria.dominio.servicio.Login;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.Login.ILoginClienteRepositorio;
import org.veterinaria.dominio.modelo.Cliente.ClienteEntidad;
import org.veterinaria.dominio.modelo.Cliente.ClienteSalida;
import org.veterinaria.dominio.modelo.Login.Login;
import org.veterinaria.dominio.servicio.Cliente.IClienteServicio;
import org.veterinaria.dominio.servicio.TipoDocumento.ITipoDocumentoServicio;

@ApplicationScoped
public class LoginClienteServicio implements ILoginClienteServicio {
  @Inject
  ILoginClienteRepositorio repositorio;
  @Inject
  ITipoDocumentoServicio tipoDocumentoServicio;
  @Inject
  IClienteServicio clienteServicio;

  @Override
  public ClienteSalida login(Login login) {
    ClienteEntidad cliente = repositorio.findByEmailCliente(login.getEmail());
    if (cliente != null && PasswordUtils.checkPassword(login.getPassword(), cliente.getPassword())) {
      return clienteServicio.obtenerClientePorId(cliente.getId().toString());
    }
    return null;
  }
}

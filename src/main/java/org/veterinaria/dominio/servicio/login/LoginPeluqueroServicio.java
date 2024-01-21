package org.veterinaria.dominio.servicio.login;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.login.ILoginPeluqueroRepositorio;
import org.veterinaria.dominio.modelo.login.Login;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroEntidad;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroSalida;
import org.veterinaria.dominio.servicio.peluquero.IPeluqueroServicio;

@ApplicationScoped
public class LoginPeluqueroServicio implements ILoginPeluqueroServicio {
  private final ILoginPeluqueroRepositorio repositorio;
  private final IPeluqueroServicio peluqueroServicio;

  @Inject
  public LoginPeluqueroServicio(ILoginPeluqueroRepositorio repositorio, IPeluqueroServicio clienteServicio) {
    this.repositorio = repositorio;
    this.peluqueroServicio = clienteServicio;
  }

  @Override
  public PeluqueroSalida login(Login login) {

    PeluqueroEntidad peluquero = repositorio.findByEmailPeluquero(login.getEmail());
    if (peluquero != null && PasswordUtils.checkPassword(login.getPassword(), peluquero.getPassword())) {
      return peluqueroServicio.obtenerPeluqueroPorId(peluquero.id.toString());
    }
    return null;
  }
}

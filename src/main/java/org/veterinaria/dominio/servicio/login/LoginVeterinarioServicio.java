package org.veterinaria.dominio.servicio.login;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.login.ILoginVeterinarioRepositorio;
import org.veterinaria.dominio.modelo.login.Login;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioEntidad;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioSalida;
import org.veterinaria.dominio.servicio.veterinario.IVeterinarioServicio;

@ApplicationScoped
public class LoginVeterinarioServicio implements ILoginVeterinarioServicio {
  private final ILoginVeterinarioRepositorio repositorio;
  private final IVeterinarioServicio veterinarioServicio;

  @Inject
  public LoginVeterinarioServicio(ILoginVeterinarioRepositorio repositorio, IVeterinarioServicio veterinarioServicio) {
    this.repositorio = repositorio;
    this.veterinarioServicio = veterinarioServicio;
  }

  @Override
  public VeterinarioSalida login(Login login) {
    VeterinarioEntidad veterinario = repositorio.findByEmailVeterinario(login.getEmail());
    if (veterinario != null && PasswordUtils.checkPassword(login.getPassword(), veterinario.getPassword())) {
      return veterinarioServicio.obtenerVeterinarioPorId(veterinario.id.toString());
    }
    return null;
  }
}

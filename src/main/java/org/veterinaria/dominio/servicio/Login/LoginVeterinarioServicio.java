package org.veterinaria.dominio.servicio.Login;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.Login.ILoginVeterinarioRepositorio;
import org.veterinaria.dominio.modelo.Cliente.ClienteEntidad;
import org.veterinaria.dominio.modelo.Login.Login;
import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoSalida;
import org.veterinaria.dominio.modelo.Veterinario.VeterinarioEntidad;
import org.veterinaria.dominio.modelo.Veterinario.VeterinarioSalida;
import org.veterinaria.dominio.servicio.TipoDocumento.ITipoDocumentoServicio;
import org.veterinaria.dominio.servicio.Veterinario.IVeterinarioServicio;

@ApplicationScoped
public class LoginVeterinarioServicio implements ILoginVeterinarioServicio {
  @Inject
  ILoginVeterinarioRepositorio repositorio;
  @Inject
  ITipoDocumentoServicio tipoDocumentoServicio;
  @Inject
  IVeterinarioServicio veterinarioServicio;

  @Override
  public VeterinarioSalida login(Login login) {
    VeterinarioEntidad veterinario = repositorio.findByEmailVeterinario(login.getEmail());
    if (veterinario != null && PasswordUtils.checkPassword(login.getPassword(), veterinario.getPassword())) {
      return veterinarioServicio.obtenerVeterinarioPorId(veterinario.getId().toString());
    }
    return null;
  }
}

package org.veterinaria.dominio.servicio.login;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.login.ILoginPeluqueroRepositorio;
import org.veterinaria.dominio.modelo.login.Login;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroEntidad;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroSalida;
import org.veterinaria.dominio.servicio.peluquero.IPeluqueroServicio;
import org.veterinaria.dominio.servicio.tipodocumento.ITipoDocumentoServicio;

@ApplicationScoped
public class LoginPeluqueroServicio implements ILoginPeluqueroServicio {

  @Inject
  ILoginPeluqueroRepositorio repositorio;
  @Inject
  ITipoDocumentoServicio tipoDocumentoServicio;
  @Inject
  IPeluqueroServicio peluqueroServicio;

  @Override
  public PeluqueroSalida login(Login login) {

    PeluqueroEntidad peluquero = repositorio.findByEmailPeluquero(login.getEmail());
    if (peluquero != null && PasswordUtils.checkPassword(login.getPassword(), peluquero.getPassword())) {
      return peluqueroServicio.obtenerPeluqueroPorId(peluquero.id.toString());
    }
    return null;
  }
}

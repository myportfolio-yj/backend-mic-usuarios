package org.veterinaria.dominio.servicio.Login;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.Login.ILoginPeluqueroRepositorio;
import org.veterinaria.dominio.modelo.Cliente.ClienteEntidad;
import org.veterinaria.dominio.modelo.Login.Login;
import org.veterinaria.dominio.modelo.Peluquero.PeluqueroEntidad;
import org.veterinaria.dominio.modelo.Peluquero.PeluqueroSalida;
import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoSalida;
import org.veterinaria.dominio.servicio.Peluquero.IPeluqueroServicio;
import org.veterinaria.dominio.servicio.TipoDocumento.ITipoDocumentoServicio;

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
      return peluqueroServicio.obtenerPeluqueroPorId(peluquero.getId().toString());
    }
    return null;
  }
}

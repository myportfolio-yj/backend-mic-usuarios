package org.veterinaria.infraestructura.adaptador.salida.Login;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.veterinaria.aplicacion.puertos.salida.Login.ILoginPeluqueroRepositorio;
import org.veterinaria.dominio.modelo.Peluquero.PeluqueroEntidad;
@ApplicationScoped
public class LoginPeluqueroRepositorio implements PanacheMongoRepository<PeluqueroEntidad>, ILoginPeluqueroRepositorio {
  @Override
  public PeluqueroEntidad findByEmailPeluquero(String email) {
    return find("email", email)
          .stream()
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .findFirst()
          .orElseGet(PeluqueroEntidad::new);
  }
}

package org.veterinaria.infraestructura.adaptador.salida.login;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.veterinaria.aplicacion.puertos.salida.login.ILoginVeterinarioRepositorio;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioEntidad;

@ApplicationScoped
public class LoginVeterinarioRepositorio implements PanacheMongoRepository<VeterinarioEntidad>, ILoginVeterinarioRepositorio {
  @Override
  public VeterinarioEntidad findByEmailVeterinario(String email) {
    return find("email", email)
          .stream()
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .findFirst()
          .orElseGet(VeterinarioEntidad::new);
  }
}

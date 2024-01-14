package org.veterinaria.infraestructura.adaptador.salida.Login;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.veterinaria.aplicacion.puertos.salida.Login.ILoginVeterinarioRepositorio;
import org.veterinaria.dominio.modelo.Veterinario.VeterinarioEntidad;

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

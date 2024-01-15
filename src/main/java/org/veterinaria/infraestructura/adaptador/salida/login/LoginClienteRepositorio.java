package org.veterinaria.infraestructura.adaptador.salida.login;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.veterinaria.aplicacion.puertos.salida.login.ILoginClienteRepositorio;
import org.veterinaria.dominio.modelo.cliente.ClienteEntidad;

@ApplicationScoped
public class LoginClienteRepositorio implements PanacheMongoRepository<ClienteEntidad>, ILoginClienteRepositorio {
  @Override
  public ClienteEntidad findByEmailCliente(String email) {
    return find("email", email)
          .stream()
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .findFirst()
          .orElseGet(ClienteEntidad::new);
  }
}

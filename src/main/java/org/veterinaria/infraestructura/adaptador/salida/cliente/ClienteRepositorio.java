package org.veterinaria.infraestructura.adaptador.salida.cliente;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.cliente.IClienteRepositorio;
import org.veterinaria.dominio.modelo.cliente.ClienteEntidad;
import org.veterinaria.infraestructura.adaptador.salida.excepciones.ClienteNotFoundException;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClienteRepositorio implements PanacheMongoRepository<ClienteEntidad>, IClienteRepositorio {
  @Override
  public List<ClienteEntidad> obtenerTodosCliente() {
    return listAll().parallelStream()
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .toList();
  }

  @Override
  public ClienteEntidad obtenerClientePorId(String idCliente) {
    return findEntidadById(idCliente)
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .orElseThrow(() -> new ClienteNotFoundException(idCliente));
  }

  @Override
  public ClienteEntidad crearCliente(ClienteEntidad cliente) {
    cliente.setDelete(false);
    cliente.persist();
    return cliente;
  }

  @Override
  public ClienteEntidad actualizarCliente(String idCliente, ClienteEntidad cliente) {
    return findEntidadById(idCliente)
          .map(p -> {
            p.setNombres(cliente.getNombres());
            p.setApellidos(cliente.getApellidos());
            p.setCelular(cliente.getCelular());
            p.setFijo(cliente.getFijo());
            p.setDocumento(cliente.getDocumento());
            p.setIdTipoDocumento(cliente.getIdTipoDocumento());
            p.setDelete(cliente.getDelete());
            p.setIdMascotas(cliente.getIdMascotas());
            update(p);
            return p;
          })
          .orElseThrow(() -> new ClienteNotFoundException(idCliente));
  }

  @Override
  public ClienteEntidad eliminarCliente(String idCliente) {
    ClienteEntidad cliente = this.obtenerClientePorId(idCliente);
    cliente.setDelete(true);
    return this.actualizarCliente(idCliente, cliente);
  }

  private Optional<ClienteEntidad> findEntidadById(String idCliente) {
    return findByIdOptional(new ObjectId(idCliente));
  }

  @Override
  public ClienteEntidad actualizarPassword(String idCliente, ClienteEntidad cliente) {
    return findEntidadById(idCliente)
          .map(p -> {
            p.setNombres(cliente.getNombres());
            p.setApellidos(cliente.getApellidos());
            p.setCelular(cliente.getCelular());
            p.setFijo(cliente.getFijo());
            p.setEmail(cliente.getEmail());
            p.setIdTipoDocumento(cliente.getIdTipoDocumento());
            p.setDocumento(cliente.getDocumento());
            p.setIdMascotas(cliente.getIdMascotas());
            p.setPassword(cliente.getPassword());
            p.setDelete(false);
            update(p);
            return p;
          })
          .orElseThrow(() -> new ClienteNotFoundException(idCliente));
  }
}
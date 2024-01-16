package org.veterinaria.infraestructura.adaptador.salida.veterinario;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.veterinario.IVeterinarioRepositorio;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioEntidad;
import org.veterinaria.infraestructura.adaptador.salida.excepciones.ClienteNotFoundException;
import org.veterinaria.infraestructura.adaptador.salida.excepciones.VeterinarioNotFoundException;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class VeterinarioRepositorio implements PanacheMongoRepository<VeterinarioEntidad>, IVeterinarioRepositorio {
  @Override
  public List<VeterinarioEntidad> obtenerTodosVeterinario() {
    return listAll().parallelStream()
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .toList();
  }

  @Override
  public VeterinarioEntidad obtenerVeterinarioPorId(String idVeterinario) {
    return findEntidadById(idVeterinario)
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .orElseThrow(() -> new VeterinarioNotFoundException(idVeterinario));
  }

  @Override
  public VeterinarioEntidad crearVeterinario(VeterinarioEntidad veterinario) {
    veterinario.setDelete(false);
    veterinario.persist();
    return veterinario;
  }

  @Override
  public VeterinarioEntidad actualizarVeterinario(String idVeterinario, VeterinarioEntidad veterinario) {
    return findEntidadById(idVeterinario)
          .map(p -> {
            p.setNombres(veterinario.getNombres());
            p.setApellidos(veterinario.getApellidos());
            p.setCelular(veterinario.getCelular());
            p.setFijo(veterinario.getFijo());
            p.setEmail(veterinario.getEmail());
            p.setDocumento(veterinario.getDocumento());
            p.setIdTipoDocumento(veterinario.getIdTipoDocumento());
            p.setPassword(veterinario.getPassword());
            p.setDelete(veterinario.getDelete());
            update(p);
            return p;
          })
          .orElseThrow(() -> new VeterinarioNotFoundException(idVeterinario));
  }

  @Override
  public VeterinarioEntidad eliminarVeterinario(String idVeterinario) {
    VeterinarioEntidad veterinario = this.obtenerVeterinarioPorId(idVeterinario);
    veterinario.setDelete(true);
    return this.actualizarVeterinario(idVeterinario, veterinario);
  }

  private Optional<VeterinarioEntidad> findEntidadById(String idVeterinario) {
    return findByIdOptional(new ObjectId(idVeterinario));
  }

  @Override
  public VeterinarioEntidad actualizarPassword(String idCliente, VeterinarioEntidad veterinario) {
    return findEntidadById(idCliente)
          .map(p -> {
            p.setCodVeterinario(veterinario.getCodVeterinario());
            p.setNombres(veterinario.getNombres());
            p.setApellidos(veterinario.getApellidos());
            p.setCelular(veterinario.getCelular());
            p.setFijo(veterinario.getFijo());
            p.setEmail(veterinario.getEmail());
            p.setIdTipoDocumento(veterinario.getIdTipoDocumento());
            p.setDocumento(veterinario.getDocumento());
            p.setPassword(veterinario.getPassword());
            p.setDelete(false);
            update(p);
            return p;
          })
          .orElseThrow(() -> new ClienteNotFoundException(idCliente));
  }
}
package org.veterinaria.infraestructura.adaptador.salida.peluquero;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.peluquero.IPeluqueroRepositorio;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroEntidad;
import org.veterinaria.infraestructura.adaptador.salida.excepciones.ClienteNotFoundException;
import org.veterinaria.infraestructura.adaptador.salida.excepciones.PeluqueroNotFoundException;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PeluqueroRepositorio implements PanacheMongoRepository<PeluqueroEntidad>, IPeluqueroRepositorio {
  @Override
  public List<PeluqueroEntidad> obtenerTodosPeluquero() {
    return listAll().parallelStream()
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .toList();
  }

  @Override
  public PeluqueroEntidad obtenerPeluqueroPorId(String idPeluquero) {
    return findEntidadById(idPeluquero)
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .orElseThrow(() -> new PeluqueroNotFoundException(idPeluquero));
  }

  @Override
  public PeluqueroEntidad crearPeluquero(PeluqueroEntidad peluquero) {
    peluquero.setDelete(false);
    peluquero.persist();
    return peluquero;
  }

  @Override
  public PeluqueroEntidad actualizarPeluquero(String idPeluquero, PeluqueroEntidad peluquero) {
    return findEntidadById(idPeluquero)
          .map(p -> {
            p.setNombres(peluquero.getNombres());
            p.setApellidos(peluquero.getApellidos());
            p.setCelular(peluquero.getCelular());
            p.setFijo(peluquero.getFijo());
            p.setEmail(peluquero.getEmail());
            p.setDocumento(peluquero.getDocumento());
            p.setIdTipoDocumento(peluquero.getIdTipoDocumento());
            p.setPassword(peluquero.getPassword());
            p.setDelete(peluquero.getDelete());
            update(p);
            return p;
          })
          .orElseThrow(() -> new PeluqueroNotFoundException(idPeluquero));
  }

  @Override
  public PeluqueroEntidad eliminarPeluquero(String idPeluquero) {
    PeluqueroEntidad peluquero = this.obtenerPeluqueroPorId(idPeluquero);
    peluquero.setDelete(true);
    return this.actualizarPeluquero(idPeluquero, peluquero);
  }

  private Optional<PeluqueroEntidad> findEntidadById(String idPeluquero) {
    return findByIdOptional(new ObjectId(idPeluquero));
  }

  @Override
  public PeluqueroEntidad actualizarPassword(String idCliente, PeluqueroEntidad peluquero) {
    return findEntidadById(idCliente)
          .map(p -> {
            p.setNombres(peluquero.getNombres());
            p.setApellidos(peluquero.getApellidos());
            p.setCelular(peluquero.getCelular());
            p.setFijo(peluquero.getFijo());
            p.setEmail(peluquero.getEmail());
            p.setIdTipoDocumento(peluquero.getIdTipoDocumento());
            p.setDocumento(peluquero.getDocumento());
            p.setPassword(peluquero.getPassword());
            p.setDelete(false);
            update(p);
            return p;
          })
          .orElseThrow(() -> new ClienteNotFoundException(idCliente));
  }
}
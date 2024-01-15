package org.veterinaria.infraestructura.adaptador.salida.tipodocumento;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.tipodocumento.ITipoDocumentoRepositorio;
import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoEntidad;

import java.util.List;

@ApplicationScoped
public class TipoDocumentoRepositorio implements PanacheMongoRepository<TipoDocumentoEntidad>, ITipoDocumentoRepositorio {
  @Override
  public List<TipoDocumentoEntidad> obtenerTodosTipoDocumento() {
    return listAll().parallelStream()
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .toList();
  }

  @Override
  public TipoDocumentoEntidad obtenerTipoDocumentoPorId(String idTipoDocumento) {
    return findByIdOptional(new ObjectId(idTipoDocumento))
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .orElseGet(TipoDocumentoEntidad::new);
  }

  @Override
  public TipoDocumentoEntidad crearTipoDocumento(TipoDocumentoEntidad tipoDocumento) {
    tipoDocumento.setDelete(false);
    tipoDocumento.persist();
    return tipoDocumento;
  }

  @Override
  public TipoDocumentoEntidad actualizarTipoDocumento(String idTipoDocumento, TipoDocumentoEntidad tipoDocumento) {
    return findByIdOptional(new ObjectId(idTipoDocumento))
          .map(p -> {
            p.setTipoDocumento(tipoDocumento.getTipoDocumento());
            p.setDelete(tipoDocumento.getDelete());
            update(p);
            return p;
          })
          .orElseThrow(() -> new RuntimeException("TipoDocumento no encontrado"));
  }

  @Override
  public TipoDocumentoEntidad eliminarTipoDocumento(String idTipoDocumento) {
    TipoDocumentoEntidad tipoDocumento = this.obtenerTipoDocumentoPorId(idTipoDocumento);
    tipoDocumento.setDelete(true);
    return this.actualizarTipoDocumento(idTipoDocumento, tipoDocumento);
  }
}

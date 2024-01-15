package org.veterinaria.dominio.modelo.tipodocumento;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@MongoEntity(collection = "collect-TipoDocumento")
public class TipoDocumentoEntidad extends PanacheMongoEntity {
  public String tipoDocumento;
  public Boolean delete;
}
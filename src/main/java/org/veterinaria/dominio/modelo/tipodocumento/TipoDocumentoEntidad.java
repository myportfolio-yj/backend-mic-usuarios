package org.veterinaria.dominio.modelo.tipodocumento;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MongoEntity(collection = "collect-TipoDocumento")
public class TipoDocumentoEntidad extends PanacheMongoEntity {
  private String tipoDocumento;
  private Boolean delete;
}
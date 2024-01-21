package org.veterinaria.dominio.modelo.peluquero;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MongoEntity(collection = "collect-Peluquero")
public class PeluqueroEntidad extends PanacheMongoEntity {
  private String nombres;
  private String apellidos;
  private String celular;
  private String fijo;
  private String email;
  private String idTipoDocumento;
  private String documento;
  private String password;
  private Boolean delete;
}

package org.veterinaria.dominio.modelo.veterinario;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@MongoEntity(collection = "collect-Veterinario")
public class VeterinarioEntidad extends PanacheMongoEntity {
  private String codVeterinario;
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

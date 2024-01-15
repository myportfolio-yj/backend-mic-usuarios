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
  public String codVeterinario;
  public String nombres;
  public String apellidos;
  public String celular;
  public String fijo;
  public String email;
  public String idTipoDocumento;
  public String documento;
  public String password;
  public Boolean delete;
}
package org.veterinaria.dominio.modelo.cliente;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@MongoEntity(collection = "collect-Cliente")
public class ClienteEntidad extends PanacheMongoEntity {
  private String nombres;
  private String apellidos;
  private String celular;
  private String fijo;
  private String email;
  private String idTipoDocumento;
  private String documento;
  private List<String> IdMascotas;
  private String password;
  private Boolean delete;
}
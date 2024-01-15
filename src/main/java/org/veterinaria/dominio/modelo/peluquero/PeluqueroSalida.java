package org.veterinaria.dominio.modelo.peluquero;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.veterinaria.dominio.modelo.tipodocumento.TipoDocumentoSalida;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@RegisterForReflection
public class PeluqueroSalida {
  private String id;
  private String nombres;
  private String apellidos;
  private String celular;
  private String fijo;
  private String email;
  private TipoDocumentoSalida tipoDocumento;
  private String documento;
}

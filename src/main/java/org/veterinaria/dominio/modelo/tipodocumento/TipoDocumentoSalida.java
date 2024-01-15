package org.veterinaria.dominio.modelo.tipodocumento;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class TipoDocumentoSalida {
  private String id;
  private String tipoDocumento;
}

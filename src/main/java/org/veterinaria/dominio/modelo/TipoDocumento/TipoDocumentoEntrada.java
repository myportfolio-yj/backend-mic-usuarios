package org.veterinaria.dominio.modelo.TipoDocumento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumentoEntrada {
  private String tipoDocumento;
}

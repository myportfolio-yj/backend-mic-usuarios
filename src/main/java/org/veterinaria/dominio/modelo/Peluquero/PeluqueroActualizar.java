package org.veterinaria.dominio.modelo.Peluquero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeluqueroActualizar {
  private String nombres;
  private String apellidos;
  private String celular;
  private String fijo;
  private String email;
  private String idTipoDocumento;
  private String documento;
}
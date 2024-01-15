package org.veterinaria.dominio.modelo.cliente;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recordatorio {
  private String nombre;
  private String fecha;
  private String tipo;
  private String detalle;
}

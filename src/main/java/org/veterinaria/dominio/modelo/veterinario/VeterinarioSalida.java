package org.veterinaria.dominio.modelo.veterinario;

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
@RegisterForReflection
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VeterinarioSalida {
  private String id;
  private String codVeterinario;
  private String nombres;
  private String apellidos;
  private String celular;
  private String fijo;
  private String email;
  private TipoDocumentoSalida tipoDocumento;
  private String documento;
}

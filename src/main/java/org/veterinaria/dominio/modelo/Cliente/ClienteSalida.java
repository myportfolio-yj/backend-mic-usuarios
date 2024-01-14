package org.veterinaria.dominio.modelo.Cliente;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.veterinaria.dominio.modelo.Citas.Cita;
import org.veterinaria.dominio.modelo.Mascota.MascotaSalida;
import org.veterinaria.dominio.modelo.TipoDocumento.TipoDocumentoSalida;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@RegisterForReflection
public class ClienteSalida {
  private String id;
  private String nombres;
  private String apellidos;
  private String celular;
  private String fijo;
  private String email;
  private TipoDocumentoSalida tipoDocumento;
  private String documento;
  private List<MascotaSalida> mascotas;
  private List<Cita> citas;
  private List<Recordatorio> recordatorio;
}

package org.veterinaria.dominio.modelo.Cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteActualizar {
  private String nombres;
  private String apellidos;
  private String celular;
  private String fijo;
  private String email;
  private String idTipoDocumento;
  private String documento;
  private List<String> idMascotas;
}
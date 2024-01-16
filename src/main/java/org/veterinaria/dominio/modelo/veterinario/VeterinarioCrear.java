package org.veterinaria.dominio.modelo.veterinario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VeterinarioCrear {
  private String codVeterinario;
  private String nombres;
  private String apellidos;
  private String celular;
  private String fijo;
  private String email;
  private String idTipoDocumento;
  private String documento;
  private String password;
  private String confirmarPassword;

  public String encryptPassword(String password) {
    return BCrypt.hashpw(password, BCrypt.gensalt());
  }

  public void prepare(String password) {
    this.setPassword(this.encryptPassword(password));
  }
}

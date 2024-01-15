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
public class VeterinarioActualizarPassword {
  private String password;
  private String newPassword;
  private String confirmarPassword;

  public String encryptPassword(String password) {
    return BCrypt.hashpw(password, BCrypt.gensalt());
  }

  public void prepare(String password) {
    this.setNewPassword(this.encryptPassword(password));
  }
}

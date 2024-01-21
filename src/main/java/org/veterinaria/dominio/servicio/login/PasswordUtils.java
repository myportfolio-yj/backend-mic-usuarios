package org.veterinaria.dominio.servicio.login;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

@AllArgsConstructor
@NoArgsConstructor
public class PasswordUtils {
  public static boolean checkPassword(String password, String hashedPassword) {
    return BCrypt.checkpw(password, hashedPassword);
  }
}

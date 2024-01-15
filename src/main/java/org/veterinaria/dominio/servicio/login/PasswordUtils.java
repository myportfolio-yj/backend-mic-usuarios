package org.veterinaria.dominio.servicio.login;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {
  public static boolean checkPassword(String password, String hashedPassword) {
    return BCrypt.checkpw(password, hashedPassword);
  }
}

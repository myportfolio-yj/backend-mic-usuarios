package org.veterinaria.infraestructura.adaptador.entrada;

public class UnauthorizedException extends RuntimeException {
  public UnauthorizedException(String message) {
    super(message);
  }
}

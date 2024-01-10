package org.veterinaria.infraestructura.adaptador.salida.Excepciones;

public class ClienteNotFoundException extends RuntimeException {
  public ClienteNotFoundException(String idCliente) {
    super("No se pudo encontrar el Cliente con el ID: " + idCliente);
  }
}

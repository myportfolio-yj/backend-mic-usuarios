package org.veterinaria.infraestructura.adaptador.salida.Excepciones;

public class VeterinarioNotFoundException extends RuntimeException {
  public VeterinarioNotFoundException(String idVeterinario) {
    super("No se pudo encontrar el veterinario con el ID: " + idVeterinario);
  }
}

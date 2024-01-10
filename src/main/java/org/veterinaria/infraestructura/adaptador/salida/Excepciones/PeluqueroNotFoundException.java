package org.veterinaria.infraestructura.adaptador.salida.Excepciones;

public class PeluqueroNotFoundException extends RuntimeException {
  public PeluqueroNotFoundException(String idPeluquero) {
    super("No se pudo encontrar el peluquero con el ID: " + idPeluquero);
  }
}

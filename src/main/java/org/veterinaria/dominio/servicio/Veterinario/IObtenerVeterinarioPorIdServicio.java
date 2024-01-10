package org.veterinaria.dominio.servicio.Veterinario;

import org.veterinaria.dominio.modelo.Veterinario.VeterinarioSalida;

public interface IObtenerVeterinarioPorIdServicio {
  VeterinarioSalida obtenerVeterinarioPorId(String idVeterinario);
}

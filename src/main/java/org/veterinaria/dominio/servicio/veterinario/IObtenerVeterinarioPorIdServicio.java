package org.veterinaria.dominio.servicio.veterinario;

import org.veterinaria.dominio.modelo.veterinario.VeterinarioSalida;

public interface IObtenerVeterinarioPorIdServicio {
  VeterinarioSalida obtenerVeterinarioPorId(String idVeterinario);
}

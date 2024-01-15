package org.veterinaria.dominio.servicio.veterinario;

import org.veterinaria.dominio.modelo.veterinario.VeterinarioSalida;

import java.util.List;

public interface IObtenerVeterinarioServicio {
  List<VeterinarioSalida> obtenerVeterinario();
}

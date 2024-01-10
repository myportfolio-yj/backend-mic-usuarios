package org.veterinaria.dominio.servicio.Veterinario;

import org.veterinaria.dominio.modelo.Veterinario.VeterinarioSalida;

import java.util.List;

public interface IObtenerVeterinarioServicio {
  List<VeterinarioSalida> obtenerVeterinario();
}

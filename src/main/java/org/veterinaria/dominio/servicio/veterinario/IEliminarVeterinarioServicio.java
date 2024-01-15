package org.veterinaria.dominio.servicio.veterinario;

import org.veterinaria.dominio.modelo.veterinario.VeterinarioSalida;

public interface IEliminarVeterinarioServicio {
  VeterinarioSalida eliminarVeterinario(String idVeterinario);
}

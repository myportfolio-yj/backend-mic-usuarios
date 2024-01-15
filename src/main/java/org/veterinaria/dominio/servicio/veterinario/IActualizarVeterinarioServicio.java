package org.veterinaria.dominio.servicio.veterinario;

import org.veterinaria.dominio.modelo.veterinario.VeterinarioActualizar;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioSalida;

public interface IActualizarVeterinarioServicio {
  VeterinarioSalida actualizarVeterinario(String idVeterinario, VeterinarioActualizar veterinario);
}

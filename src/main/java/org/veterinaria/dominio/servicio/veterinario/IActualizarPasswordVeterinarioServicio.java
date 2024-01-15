package org.veterinaria.dominio.servicio.veterinario;

import org.veterinaria.dominio.modelo.veterinario.VeterinarioActualizarPassword;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioSalida;

public interface IActualizarPasswordVeterinarioServicio {
  VeterinarioSalida actualizarPasswordVeterinario(String idVeterinario, VeterinarioActualizarPassword veterinario);
}

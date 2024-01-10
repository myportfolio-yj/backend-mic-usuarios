package org.veterinaria.dominio.servicio.Veterinario;

import org.veterinaria.dominio.modelo.Veterinario.VeterinarioActualizarPassword;
import org.veterinaria.dominio.modelo.Veterinario.VeterinarioSalida;

public interface IActualizarPasswordVeterinarioServicio {
  VeterinarioSalida actualizarPasswordVeterinario(String idVeterinario, VeterinarioActualizarPassword veterinario);
}

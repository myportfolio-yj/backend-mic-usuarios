package org.veterinaria.dominio.servicio.Veterinario;

import org.veterinaria.dominio.modelo.Veterinario.VeterinarioActualizar;
import org.veterinaria.dominio.modelo.Veterinario.VeterinarioSalida;

public interface IActualizarVeterinarioServicio {
  VeterinarioSalida actualizarVeterinario(String idVeterinario, VeterinarioActualizar veterinario);
}

package org.veterinaria.dominio.servicio.veterinario;

import org.veterinaria.dominio.modelo.veterinario.VeterinarioCrear;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioSalida;

public interface ICrearVeterinarioServicio {
  VeterinarioSalida crearVeterinario(VeterinarioCrear veterinario);
}

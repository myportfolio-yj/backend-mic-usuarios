package org.veterinaria.dominio.servicio.Veterinario;

import org.veterinaria.dominio.modelo.Veterinario.VeterinarioCrear;
import org.veterinaria.dominio.modelo.Veterinario.VeterinarioSalida;

public interface ICrearVeterinarioServicio {
  VeterinarioSalida crearVeterinario(VeterinarioCrear veterinario);
}

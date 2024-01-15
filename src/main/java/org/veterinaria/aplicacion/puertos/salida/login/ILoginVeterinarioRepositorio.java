package org.veterinaria.aplicacion.puertos.salida.login;

import org.veterinaria.dominio.modelo.veterinario.VeterinarioEntidad;

public interface ILoginVeterinarioRepositorio {
  VeterinarioEntidad findByEmailVeterinario(String email);
}

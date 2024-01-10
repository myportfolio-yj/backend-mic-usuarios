package org.veterinaria.aplicacion.puertos.salida.Login;

import org.veterinaria.dominio.modelo.Veterinario.VeterinarioEntidad;

public interface ILoginVeterinarioRepositorio {
  VeterinarioEntidad findByEmailVeterinario(String email);
}

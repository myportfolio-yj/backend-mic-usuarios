package org.veterinaria.aplicacion.puertos.salida.Veterinario;

import org.veterinaria.dominio.modelo.Veterinario.VeterinarioEntidad;

import java.util.List;

public interface IVeterinarioRepositorio {
  List<VeterinarioEntidad> obtenerTodosVeterinario();

  VeterinarioEntidad obtenerVeterinarioPorId(String idVeterinario);

  VeterinarioEntidad crearVeterinario(VeterinarioEntidad veterinario);

  VeterinarioEntidad actualizarVeterinario(String idVeterinario, VeterinarioEntidad veterinario);

  VeterinarioEntidad eliminarVeterinario(String idVeterinario);
  VeterinarioEntidad actualizarPassword(String idCliente, VeterinarioEntidad veterinario);
}

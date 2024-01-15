package org.veterinaria.aplicacion.puertos.salida.veterinario;

import org.veterinaria.dominio.modelo.veterinario.VeterinarioEntidad;

import java.util.List;

public interface IVeterinarioRepositorio {
  List<VeterinarioEntidad> obtenerTodosVeterinario();

  VeterinarioEntidad obtenerVeterinarioPorId(String idVeterinario);

  VeterinarioEntidad crearVeterinario(VeterinarioEntidad veterinario);

  VeterinarioEntidad actualizarVeterinario(String idVeterinario, VeterinarioEntidad veterinario);

  VeterinarioEntidad eliminarVeterinario(String idVeterinario);

  VeterinarioEntidad actualizarPassword(String idCliente, VeterinarioEntidad veterinario);
}

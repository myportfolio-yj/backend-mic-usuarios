package org.veterinaria.dominio.modelo.mascota;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mascota {
  private String id;
  private String codIdentificacion;
  private String nombre;
  private String apellido;
  private String fechaNacimiento;
  private Sexo sexo;
  private Especie especie;
  private Raza raza;
  private Boolean esterilizado;
  private List<Alergia> alergias;
  private List<Vacuna> vacunas;
  private List<Recordatorio> recordatorios;
  private String foto;
  private String qr;
}
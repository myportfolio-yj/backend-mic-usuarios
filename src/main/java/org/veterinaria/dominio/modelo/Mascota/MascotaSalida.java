package org.veterinaria.dominio.modelo.Mascota;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quarkus.runtime.annotations.RegisterForReflection;
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
@RegisterForReflection
public class MascotaSalida {
  private String id;
  private String codIdentificacion;
  private String lable;
  private String nombre;
  private String apellido;
  private String fechaNacimiento;
  private Sexo sexo;
  private Especie especie;
  private Raza raza;
  private Boolean esterilizado;
  private List<Alergia> alergias;
  private List<Vacuna> vacunas;
  private String foto;
  private String qr;
}
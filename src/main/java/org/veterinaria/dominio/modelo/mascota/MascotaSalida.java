package org.veterinaria.dominio.modelo.mascota;

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
  private SexoSalida sexo;
  private EspecieSalida especie;
  private RazaSalida raza;
  private Boolean esterilizado;
  private List<AlergiaSalida> alergias;
  private List<VacunaSalida> vacunas;
  private String foto;
  private String qr;
}
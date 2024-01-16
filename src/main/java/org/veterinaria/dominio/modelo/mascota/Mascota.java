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
  private SexoSalida sexo;
  private EspecieSalida especie;
  private RazaSalida raza;
  private Boolean esterilizado;
  private List<AlergiaSalida> alergias;
  private List<VacunaSalida> vacunas;
  private List<RecordatorioSalida> recordatorios;
  private String foto;
  private String qr;
}
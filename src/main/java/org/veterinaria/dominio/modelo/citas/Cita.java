package org.veterinaria.dominio.modelo.citas;

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
public class Cita {
  private String id;
  private String idCliente;
  private String nombreMascota;
  private String idMascota;
  private String tipoCita;
  private String idTipoCita;
  private List<String> atencionesPeluqueria;
  private String fecha;
  private String turno;
  private String observaciones;
  @Builder.Default
  private String image = "https://res.cloudinary.com/dmaoa8dcd/image/upload/v1705193414/Appomsv/clock1_tqr8ky.png";
  @Builder.Default
  private String imageLabel = "Clock";
}

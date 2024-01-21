package org.veterinaria.dominio.modelo.cliente;

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
public class GeolocalizacionArraySalida {
  private String mascotaId;
  private String mascotaNombre;
  private List<GeolocalizacionSalida> geolocalizaciones;
}

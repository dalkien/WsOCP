package co.com.claro.ocp.dto;

import co.com.claro.ocp.entity.NovedadesEmpleados;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NovedadesEmpleadosResponse {

    @Getter @Setter
    List<NovedadesEmpleados> novedadesEmpleados;

    @Getter @Setter
    GenericResponse response;

}

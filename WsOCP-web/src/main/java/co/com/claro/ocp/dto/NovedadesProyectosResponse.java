package co.com.claro.ocp.dto;

import co.com.claro.ocp.entity.NovedadesProyectos;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NovedadesProyectosResponse {

    @Getter @Setter
    List<NovedadesProyectos> novedadesProyectos;

    @Getter @Setter
    GenericResponse response;
}

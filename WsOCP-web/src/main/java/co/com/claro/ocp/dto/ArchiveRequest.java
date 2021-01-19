package co.com.claro.ocp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class ArchiveRequest {

    @Getter
    @Setter
    private String archivo;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String tipo;

    @Getter
    @Setter
    private String novedad;

   /* atribute archivo nomre archivo tipo novedad*/
}

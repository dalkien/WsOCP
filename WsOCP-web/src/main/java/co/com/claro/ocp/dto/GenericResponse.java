package co.com.claro.ocp.dto;

import lombok.Getter;
import lombok.Setter;

public class GenericResponse {

    @Getter
    @Setter
    private String descripcion;

    @Getter
    @Setter
    private String messageCode;

    @Getter
    @Setter
    private String returnCode;

    public GenericResponse() {
    }

    public GenericResponse(String descripcion, String messageCode, String returnCode) {
        this.descripcion = descripcion;
        this.messageCode = messageCode;
        this.returnCode = returnCode;
    }
}

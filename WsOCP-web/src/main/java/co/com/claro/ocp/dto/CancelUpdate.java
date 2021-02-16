package co.com.claro.ocp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CancelUpdate {

    private Long idMod;

    private String state;

    private String User;
}

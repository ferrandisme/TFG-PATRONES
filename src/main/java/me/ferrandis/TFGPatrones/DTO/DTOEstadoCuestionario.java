package me.ferrandis.TFGPatrones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DTOEstadoCuestionario {

    String texto;
    boolean acabado;
    boolean solucionado;

}

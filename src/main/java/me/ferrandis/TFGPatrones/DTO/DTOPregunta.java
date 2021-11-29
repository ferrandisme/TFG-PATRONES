package me.ferrandis.TFGPatrones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOPregunta {

    public String ID;
    Integer orden;
    String texto;
    List<String> resultado;
    String tipo;
}

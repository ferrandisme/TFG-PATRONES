package me.ferrandis.TFGPatrones.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class DTOPregunta {

        public String ID;

        String texto;

        List<String> resultado;
}

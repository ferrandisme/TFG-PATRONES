package me.ferrandis.TFGPatrones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DTOPatron {

    String nombre;
    String resumen;

    List<String> textoExplicacion;
    List<String> URLImagenes;
}

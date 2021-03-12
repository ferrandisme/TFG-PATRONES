package me.ferrandis.TFGPatrones.DTO;

import lombok.AllArgsConstructor;
import me.ferrandis.TFGPatrones.modelo.ItemTest;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.List;

@AllArgsConstructor
public class DTOTest {

    public List<Float> puntuaciones;
    public int item;
    public int preguntaActual;

    public String ID;
    public String tipo;
    public List<Integer> ordenRespuestas;

    //Informacion no cambiante
    @Transient
    public List<ItemTest> preguntas;

}

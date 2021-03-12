package me.ferrandis.TFGPatrones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.ferrandis.TFGPatrones.modelo.ItemTest;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.List;

@Deprecated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOTest {

    public List<Float> puntuaciones;
    public int item;
    public int preguntaActual;

    public String ID;
    public String tipo;
    public List<Integer> ordenRespuestas;

    //Informacion no cambiante
    public List<ItemTest> preguntas;

    public class InformacionTest {
        public float puntuacion;
        public String nombre;
    }

}

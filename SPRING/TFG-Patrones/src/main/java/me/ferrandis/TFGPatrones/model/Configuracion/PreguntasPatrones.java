package me.ferrandis.TFGPatrones.model.Configuracion;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class PreguntasPatrones {

    @Id
    String version;

    List<String> estructuralesID;
    List<String> comportamientoID;
    List<String> creacionalesID;
}

package me.ferrandis.TFGPatrones.Encapsulaciones;

import lombok.Data;

@Deprecated
@Data
public class DatosVentanaPrincipal {

    int numeroPatrones;

    public DatosVentanaPrincipal(int numeroPatrones){
        this.numeroPatrones = numeroPatrones;
        System.out.print(numeroPatrones);
    }
}

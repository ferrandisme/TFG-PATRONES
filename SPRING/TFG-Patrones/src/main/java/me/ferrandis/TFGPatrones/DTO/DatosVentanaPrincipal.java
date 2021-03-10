package me.ferrandis.TFGPatrones.DTO;

import lombok.Data;

@Data
public class DatosVentanaPrincipal {

    int numeroPatrones;

    public DatosVentanaPrincipal(int numeroPatrones){
        this.numeroPatrones = numeroPatrones;
        System.out.print(numeroPatrones);
    }
}

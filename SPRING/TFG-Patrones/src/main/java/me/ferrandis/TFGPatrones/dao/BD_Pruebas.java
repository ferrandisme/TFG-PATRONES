package me.ferrandis.TFGPatrones.dao;

import org.springframework.stereotype.Repository;

@Repository("BDPruebas")
public class BD_Pruebas implements VentanaPrincipalDAO{

    @Override
    public int getNumeroPatrones() {
        return 12;
    }
}

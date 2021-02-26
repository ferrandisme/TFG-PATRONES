package me.ferrandis.TFGPatrones.servicio;


import me.ferrandis.TFGPatrones.dao.BDPatrones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VentanaPrincipalServicio {

    private final BDPatrones BDPatrones;


    @Autowired
    public VentanaPrincipalServicio(@Qualifier("MONGOPatrones") BDPatrones dao) {
        this.BDPatrones = dao;
    }

    public int getNumeroPatrones(){
        return BDPatrones.getListaPatrones().size();
    }
}

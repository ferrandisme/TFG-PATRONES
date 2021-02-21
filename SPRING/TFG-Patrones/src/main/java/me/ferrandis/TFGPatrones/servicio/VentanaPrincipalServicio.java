package me.ferrandis.TFGPatrones.servicio;


import me.ferrandis.TFGPatrones.dao.BaseDatos;
import me.ferrandis.TFGPatrones.dao.VentanaPrincipalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VentanaPrincipalServicio {

    private final BaseDatos baseDatos;


    @Autowired
    public VentanaPrincipalServicio(@Qualifier("MONGODB") BaseDatos dao) {
        this.baseDatos = dao;
    }

    public int getNumeroPatrones(){
        return baseDatos.getListaPatrones().size();
    }
}

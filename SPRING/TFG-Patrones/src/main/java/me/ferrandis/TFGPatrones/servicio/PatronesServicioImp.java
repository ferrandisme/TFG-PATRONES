package me.ferrandis.TFGPatrones.servicio;

import me.ferrandis.TFGPatrones.dao.BDPatrones;
import me.ferrandis.TFGPatrones.modelo.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronesServicioImp implements PatronesServicio{

    private final BDPatrones BDPatrones;

    @Autowired
    public PatronesServicioImp(@Qualifier("MONGOPatrones") BDPatrones dao) {
        this.BDPatrones = dao;
    }

    public List<Patron> getListaPatrones(){
        return BDPatrones.getListaPatrones();
    }

    public Patron getPatron(String nombre){
        return BDPatrones.getPatron(nombre);
    }
}

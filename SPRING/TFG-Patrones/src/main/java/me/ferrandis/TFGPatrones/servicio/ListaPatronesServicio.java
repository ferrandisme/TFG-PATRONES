package me.ferrandis.TFGPatrones.servicio;

import me.ferrandis.TFGPatrones.dao.BaseDatos;
import me.ferrandis.TFGPatrones.modelo.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaPatronesServicio {

    private final BaseDatos baseDatos;

    @Autowired
    public ListaPatronesServicio(@Qualifier("MONGODB") BaseDatos dao) {
        this.baseDatos = dao;
    }

    public List<Patron> getListaPatrones(){
        return baseDatos.getListaPatrones();
    }
}

package me.ferrandis.TFGPatrones.servicio;
import me.ferrandis.TFGPatrones.dao.BaseDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TestServicio {

    private final BaseDatos baseDatos;

    @Autowired
    public TestServicio(@Qualifier("MONGODB") BaseDatos dao) {
        this.baseDatos = dao;
    }

    
}

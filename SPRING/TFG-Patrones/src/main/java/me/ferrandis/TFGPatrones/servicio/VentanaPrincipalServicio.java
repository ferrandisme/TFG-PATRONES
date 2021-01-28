package me.ferrandis.TFGPatrones.servicio;


import me.ferrandis.TFGPatrones.dao.VentanaPrincipalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VentanaPrincipalServicio {

    private final VentanaPrincipalDAO ventanaPrincipalDAO;

    @Autowired
    public VentanaPrincipalServicio(@Qualifier("BDPruebas") VentanaPrincipalDAO dao) {
        this.ventanaPrincipalDAO = dao;
    }

    public int getNumeroPatrones(){
        return ventanaPrincipalDAO.getNumeroPatrones();
    }
}

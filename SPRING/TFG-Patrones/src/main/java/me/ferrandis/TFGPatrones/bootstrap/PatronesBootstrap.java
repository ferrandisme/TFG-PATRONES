package me.ferrandis.TFGPatrones.bootstrap;

import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.modelo.Patron;
import me.ferrandis.TFGPatrones.servicio.PatronesServicio;
import me.ferrandis.TFGPatrones.servicio.TestServicio;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Component
public class PatronesBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    public final PatronesServicio patronesServicio;
    public final TestServicio testServicio;

    public PatronesBootstrap(PatronesServicio patronesServicio, TestServicio testServicio){
        this.patronesServicio = patronesServicio;
        this.testServicio = testServicio;
    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.err.println("ACTIVADO MODO DE BORRADO DE BD EN CADA INICIO");
        patronesServicio.deleteAll();
        testServicio.deleteAll();
        if (patronesServicio.getPatrones().size() == 0)
         cargarPatrones();
        log.debug("[!] Cargado set inicial de datos");
    }

    public void cargarPatrones(){
        log.debug("[!] Cargando patrones...");
        Patron patron = new Patron();
        patron.setNombre("Mediador");
        patron.setResumen("Descripcion");

        List<String> texto = new ArrayList<>();
        texto.add("Para el ejemplo de hoy vamos a analizar un caso de estudio basado en las aplicaciones de FaceBook. Este es un ejemplo simplificado y no es como funcionan en la vida real. Vamos a suponer que las 4 aplicaciones intercambias datos y avisos directamentre entre si ya que el usuario tiene vinculadas las 4 a una unica cuenta de correo electronico. Esto se hace con el fin de mostrar los mejores anuncios en cada una de las redes sociales. Haciendo asi que si por ejemplo buscas videojeugos en instagram, al entrar a facebook te sugiera anuncios sobre el ultimo lanzamiento de la PS5.");
        texto.add("Eres el arquitecto de software de la empresa y te han solicitado que les ayudes a solucionar el problema. Como ejemplo te han puesto instagram. Esta realiza llamadas de forma directa a FaceBook, Messenger y Whatsapp de los servicios. Por ejemplo, cada vez que inicias sesion le pide a las otras aplicaciones contenidos que hayas visitado recientemente para mostrarte los mejores anuncios. Esto es un problema, ya que aunque en el ejemplo se muestran solo 4 aplicaciones, realmente en la realidad existen muchas mas. El problema de comunicacion que tienen es el mostrado en la imagen. Como podemos observar, solo con 4 interacturando entre si ya se monta un caos. Imaginad un programa que tenga 12 clases llamandose entre si para intercambiar informacion como debe ser. Cuanto mas se espera mas dificil se vuelve aplicar un patron y peor codigo creamos.");
        texto.add("La solucion que se propone es esta. Simplifica mucho el esquema, ya que tenemos un mediador que se encarga de gestionar los puntos de fallo en un único sitio. Esto significa que haremos llamadas y internamente de encargara de gestionar las distintas dependencias.");
        patron.setTextoExplicacion(texto);

        List<String> url = new ArrayList<>();
        url.add("https://i.imgur.com/seuWaPP.png");
        url.add("https://i.imgur.com/UFNiqnx.png");
        url.add("https://i.imgur.com/KxmlXrZ.png");
        patron.setURLImagenes(url);


        patronesServicio.savePatron(patron);
    }
}

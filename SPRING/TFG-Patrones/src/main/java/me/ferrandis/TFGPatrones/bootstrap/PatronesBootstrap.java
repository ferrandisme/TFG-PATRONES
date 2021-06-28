package me.ferrandis.TFGPatrones.bootstrap;

import lombok.extern.slf4j.Slf4j;
import me.ferrandis.TFGPatrones.model.Patron;
import me.ferrandis.TFGPatrones.model.Pregunta;
import me.ferrandis.TFGPatrones.repository.PatronRepository;
import me.ferrandis.TFGPatrones.repository.PreguntaRepository;
import me.ferrandis.TFGPatrones.service.PatronesServicio;
import me.ferrandis.TFGPatrones.service.CuestionarioServicio;
import me.ferrandis.TFGPatrones.service.PreguntasServicio;
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
    public final CuestionarioServicio cuestionarioServicio;
    public final PatronRepository patronRepository;
    public final PreguntaRepository preguntaRepository;

    public PatronesBootstrap(PatronesServicio patronesServicio, CuestionarioServicio cuestionarioServicio, PatronRepository patronRepository, PreguntaRepository preguntaRepository){
        this.patronesServicio = patronesServicio;
        this.cuestionarioServicio = cuestionarioServicio;
        this.patronRepository = patronRepository;
        this.preguntaRepository = preguntaRepository;
    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.error("ACTIVADO MODO DE BORRADO DE BD EN CADA INICIO");
        patronesServicio.deleteAll();
        cuestionarioServicio.deleteAll();
        preguntaRepository.deleteAll();
        if (patronesServicio.getPatrones().size() == 0)
            cargarPatrones();
        log.debug("[!] Cargado set inicial de datos");
    }

    public void cargarPatrones(){
        log.debug("[!] Cargando patrones...");
        Patron patron = new Patron();
        patron.setNombre("Mediador");
        patron.setResumen("Descripcion de ejemplo del patron donde se explica un caso de uso o que es :)");

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

        List<String> documentacion = new ArrayList<>();
        documentacion.add("https://google.es");
        documentacion.add("https://cliente.tuneupprocess.com");
        patron.setDocumentacion(documentacion);

        List<String> sinergias = new ArrayList<>();
        sinergias.add("Prueba a combinar ese patron con X patron para crear un buen efecto");
        sinergias.add("Este patron junto a X formara un Y que puede ser interesante para tu aplicación");
        patron.setSinergias(sinergias);

        patronRepository.save(patron);

        patron = new Patron();
        patron.setNombre("Fabrica");
        patron.setResumen("Descripcion Farica)");
        patron.setSinergias(new ArrayList<>());
        patron.setURLImagenes(new ArrayList<>());
        patron.setDocumentacion(new ArrayList<>());
        patron.setTextoExplicacion(new ArrayList<>());

        patronRepository.save(patron);
        //-------------------------

        log.debug("[!] Cargando preguntas...");

        Pregunta pregunta = new Pregunta();
        pregunta.setID("1");
        pregunta.setOrden(0);
        pregunta.setTexto("Texto de la pregunta de encontrar tipò");
        pregunta.setTipo(CuestionarioServicio.ENCONTRAR_TIPO);
        List<String> resultado = new ArrayList<>();
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add(CuestionarioServicio.TIPO + PreguntasServicio.ESTRUCTURAL);
        pregunta.setResultado(resultado);
        preguntaRepository.save(pregunta);

        pregunta = new Pregunta();
        pregunta.setID("2");
        pregunta.setOrden(0);
        pregunta.setTexto("Texto de la pregunta, la 5 elimina mediador");
        pregunta.setTipo(PreguntasServicio.ESTRUCTURAL);
        resultado = new ArrayList<>();
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add(CuestionarioServicio.ELIMINAR + "Mediador");
        pregunta.setResultado(resultado);
        preguntaRepository.save(pregunta);

        pregunta = new Pregunta();
        pregunta.setID("3");
        pregunta.setOrden(1);
        pregunta.setTexto("Si has respondido 5 esto no deberia de existir");
        pregunta.setTipo(PreguntasServicio.ESTRUCTURAL);
        resultado = new ArrayList<>();
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add(CuestionarioServicio.ELIMINAR + "Mediador");
        pregunta.setResultado(resultado);
        preguntaRepository.save(pregunta);

        pregunta = new Pregunta();
        pregunta.setID("3");
        pregunta.setOrden(2);
        pregunta.setTexto("Esta no deberia de existir si has marcado la 5 antes.");
        pregunta.setTipo(PreguntasServicio.ESTRUCTURAL);
        resultado = new ArrayList<>();
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add(CuestionarioServicio.SOLUCION + "Mediador");
        pregunta.setResultado(resultado);
        preguntaRepository.save(pregunta);


        pregunta = new Pregunta();
        pregunta.setID("4");
        pregunta.setOrden(3);
        pregunta.setTexto("Esta la solucion es fabrica");
        pregunta.setTipo(PreguntasServicio.ESTRUCTURAL);
        resultado = new ArrayList<>();
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add(CuestionarioServicio.SOLUCION + "Fabrica");
        pregunta.setResultado(resultado);
        preguntaRepository.save(pregunta);


        pregunta = new Pregunta();
        pregunta.setID("43");
        pregunta.setOrden(-1);
        pregunta.setTexto("Esto es una prueba de que el orden funciona");
        pregunta.setTipo(PreguntasServicio.ESTRUCTURAL);
        resultado = new ArrayList<>();
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add("");
        pregunta.setResultado(resultado);
        preguntaRepository.save(pregunta);


        log.warn("Finalizada carga de datos de ejemplo y borrado de la base de datos");
    }
}

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
        patron.setNombre("Mediator");
        patron.setResumen("Encapsula un grupo de objetos que interactuan enter si");

        List<String> texto = new ArrayList<>();
        texto.add("Para el ejemplo de hoy vamos a analizar un caso de estudio basado en las aplicaciones de FaceBook. Este es un ejemplo simplificado y no es como funcionan en la vida real. Vamos a suponer que las 4 aplicaciones intercambias datos y avisos directamentre entre si ya que el usuario tiene vinculadas las 4 a una unica cuenta de correo electronico. Esto se hace con el fin de mostrar los mejores anuncios en cada una de las redes sociales. Haciendo asi que si por ejemplo buscas videojeugos en instagram, al entrar a facebook te sugiera anuncios sobre el ultimo lanzamiento de la PS5.");
        texto.add("Eres el arquitecto de software de la empresa y te han solicitado que les ayudes a solucionar el problema. Como ejemplo te han puesto instagram. Esta realiza llamadas de forma directa a FaceBook, Messenger y Whatsapp de los servicios. Por ejemplo, cada vez que inicias sesion le pide a las otras aplicaciones contenidos que hayas visitado recientemente para mostrarte los mejores anuncios. Esto es un problema, ya que aunque en el ejemplo se muestran solo 4 aplicaciones, realmente en la realidad existen muchas mas. El problema de comunicacion que tienen es el mostrado en la imagen. Como podemos observar, solo con 4 interacturando entre si ya se monta un caos. Imaginad un programa que tenga 12 clases llamandose entre si para intercambiar informacion como debe ser. Cuanto mas se espera mas dificil se vuelve aplicar un patron y peor codigo creamos.");
        texto.add("La solucion que se propone es esta. Simplifica mucho el esquema, ya que tenemos un mediador que se encarga de gestionar los puntos de fallo en un único sitio. Esto significa que haremos llamadas y internamente de encargara de gestionar las distintas dependencias.");
        patron.setTextoExplicacion(texto);

        List<String> url = new ArrayList<>();
        url.add("https://i.imgur.com/pkY1KxP.png");
        url.add("https://i.imgur.com/nIpJ5i7.png");
        url.add("https://i.imgur.com/N9Q4rDn.png");
        patron.setURLImagenes(url);

        List<String> documentacion = new ArrayList<>();;
        documentacion.add("https://refactoring.guru/es/design-patterns/factory-method");
        patron.setDocumentacion(documentacion);

        List<String> sinergias = new ArrayList<>();
        sinergias.add("Puede ser usado con el patrón Observador para gestionar dependencias complejas.");
        patron.setSinergias(sinergias);
        patronRepository.save(patron);

        //PROTOTYPE

       createPrototype();


        //Creacionales
        crearPatron("Factory Method", "Creación de objeto concreto a traves de uno generico");
        crearPatron("Abstract Factory", "Permite instanciar grupos de objetos relacionados de forma generica.");
        crearPatron("Builder", "Util para crear objetos paso a paso, pudiendo variarlo mientras se construye.");
        //crearPatron("Prototype", "Copia de objetos existentes.");
        crearPatron("Singleton", "Limita una clase a una unica instancia y da acceso global a esta.");

        //Estructurales
        crearPatron("Adapter", "Posibilita la comunicación entre interfaces imcompatibles.");
        crearPatron("Bridge", "Para clases grandes permite la división entre abstracción e implementación de forma independiente.");
        crearPatron("Composite", "Permite componer objetos en estructura de arbol.");
        crearPatron("Decorator", "Añade funcionalidad a objetos encapsulandolos.");
        crearPatron("Facade", "Interfaz de acceso a un grupo complejo de clases.");
        crearPatron("Flyweight", "Optimización de la memoria permitiendo compartir partes comunes del estado de varios objetos.");
        crearPatron("Proxy", "Contra el acceso a un objeto.");

        //Estructurales
        crearPatron("Chain of responsibility", "Delega el procesamiento de una solicitud hasta llegar al manejador adecuado.");
        crearPatron("Command", "Encapsula los datos de una solicitud en un objeto independiente");
        crearPatron("Iterator", "Itera sobre una colección sin exponer su implementación.");
        crearPatron("Memento", "Permite guardar y recuperar un objeto sin revelar su implementación.");
        crearPatron("Observer", "Notifica a una serie de observadores de un cambio en un objeto.");
        crearPatron("State", "Altera su comportamiento cuando su estado interno cambia.");
        crearPatron("Strategy", "Define una familia de algoritmos intercambiables entre si.");
        crearPatron("Template Method", "Especifica el esqueleto de un algoritmo con sus pasos a segir.");
        crearPatron("Visitor", "Desacopla el algoritmo de los objetos sobre los que opera.");

        //-------------------------

        log.debug("[!] Cargando preguntas...");

        Pregunta pregunta = new Pregunta();
        pregunta.setID("1");
        pregunta.setOrden(0);
        pregunta.setTexto("Mi problema está relacionado algoritmos y asignación de responsabilidades");
        pregunta.setTipo(CuestionarioServicio.ENCONTRAR_TIPO);
        List<String> resultado = new ArrayList<>();
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add(CuestionarioServicio.TIPO + PreguntasServicio.COMPORTAMIENTO);
        resultado.add(CuestionarioServicio.TIPO + PreguntasServicio.COMPORTAMIENTO);
        pregunta.setResultado(resultado);
        preguntaRepository.save(pregunta);

         pregunta = new Pregunta();
        pregunta.setID("2");
        pregunta.setOrden(2);
        pregunta.setTexto("Mi problema está en cómo se relacionan las distintas clases entre si");
        pregunta.setTipo(CuestionarioServicio.ENCONTRAR_TIPO);
        resultado = new ArrayList<>();
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add(CuestionarioServicio.TIPO + PreguntasServicio.ESTRUCTURAL);
        resultado.add(CuestionarioServicio.TIPO + PreguntasServicio.ESTRUCTURAL);
        pregunta.setResultado(resultado);
        preguntaRepository.save(pregunta);


         pregunta = new Pregunta();
        pregunta.setID("3");
        pregunta.setOrden(3);
        pregunta.setTexto("Mi problema está relacionado con la creación de objetos");
        pregunta.setTipo(CuestionarioServicio.ENCONTRAR_TIPO);
        resultado = new ArrayList<>();
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add(CuestionarioServicio.TIPO + PreguntasServicio.CREACIONAL);
        resultado.add(CuestionarioServicio.TIPO + PreguntasServicio.CREACIONAL);
        pregunta.setResultado(resultado);
        preguntaRepository.save(pregunta);


        pregunta = new Pregunta();
        pregunta.setID("-9");
        pregunta.setOrden(-1);
        pregunta.setTexto("Tengo un problema con la creación de objetos NUEVOS.");
        pregunta.setTipo(PreguntasServicio.CREACIONAL);
        resultado = new ArrayList<>();
        resultado.add(CuestionarioServicio.ELIMINAR + "Builder");
        resultado.add(CuestionarioServicio.ELIMINAR + "Builder");
        resultado.add("");
        resultado.add("");
        resultado.add("");

        pregunta.setResultado(resultado);
        preguntaRepository.save(pregunta);

        pregunta = new Pregunta();
        pregunta.setID("5");
        pregunta.setOrden(5);
        pregunta.setTexto("Existe un objeto que es complejo de construir (constructores grandes, mucho código disperso para su creación, …). Se quiere construir paso a paso como si se tratase de ir construyendo un edificio donde se puede personalizar sus componentes.");
        pregunta.setTipo(PreguntasServicio.CREACIONAL);
        resultado = new ArrayList<>();
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add(CuestionarioServicio.SOLUCION + "Builder");
        resultado.add(CuestionarioServicio.SOLUCION + "Builder");
        pregunta.setResultado(resultado);
        preguntaRepository.save(pregunta);

        pregunta = new Pregunta();
        pregunta.setID("6");
        pregunta.setOrden(6);
        pregunta.setTexto("Busco una forma de clonar un objeto de forma completa (incluso sus atributos privados)");
        pregunta.setTipo(PreguntasServicio.CREACIONAL);
        resultado = new ArrayList<>();
        resultado.add("");
        resultado.add("");
        resultado.add("");
        resultado.add(CuestionarioServicio.SOLUCION + "Prototype");
        resultado.add(CuestionarioServicio.SOLUCION + "Prototype");
        pregunta.setResultado(resultado);
        preguntaRepository.save(pregunta);


        log.warn("Finalizada carga de datos de ejemplo y borrado de la base de datos");
    }

    private void createPrototype() {
        Patron patron = new Patron();
        patron.setNombre("Prototype");
        patron.setResumen("Copia de objetos existentes");

        List<String> texto = new ArrayList<>();
        texto.add("Para el ejemplo vamos a suponer que tenemos como cliente una gran cadena de supermercados. En un punto de la realización de pedidos para un distribuidor, este supermercado quiere clonar el pedido y personalizarlo para cada provincia. Actualmente, no tenemos una forma de hacer esto. Volver a hacer los pasos seria muy costoso por las carga que se realiza sobre base de datos.");
        texto.add("Para cada Pedido creamos un metodo de clonación, el cual se encarga de clonar todos sus datos y información. Esta puede contener contenido como variables privados o relaciones con objetos. ");
        texto.add("Con esto tenemos un metodo de clonado que se encarga de la clonación de pedidos para poder reutilziar esta información.");
        patron.setTextoExplicacion(texto);

        List<String> url = new ArrayList<>();
        url.add("https://i.imgur.com/BqWvHZv.png");
        url.add("https://i.imgur.com/AJzRcNk.png");
        url.add("httpscamara://i.imgur.com/K2wRRck.png");
        patron.setURLImagenes(url);

        List<String> documentacion = new ArrayList<>();;
        documentacion.add("https://refactoring.guru/es/design-patterns/prototype");
        patron.setDocumentacion(documentacion);

        List<String> sinergias = new ArrayList<>();
        sinergias.add("Permite configurar Factory dinamicamente");
        patron.setSinergias(sinergias);

        patronRepository.save(patron);

    }

    private void crearPatron(String name, String description){
        Patron patron = new Patron();
        patron.setNombre(name);
        patron.setResumen(description);
        patron.setSinergias(new ArrayList<>());
        patron.setURLImagenes(new ArrayList<>());
        patron.setDocumentacion(new ArrayList<>());
        patron.setTextoExplicacion(new ArrayList<>());

        patronRepository.save(patron);
    }
}

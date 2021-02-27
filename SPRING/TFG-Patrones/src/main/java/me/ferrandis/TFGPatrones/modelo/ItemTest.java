package me.ferrandis.TFGPatrones.modelo;

import java.util.ArrayList;
import java.util.List;

public class ItemTest {

    public String nombre;
    public List<String> preguntas;

    public String getPregunta(int contador){
        return preguntas.get(contador);
    }

    public ItemTest(String nombre , List<String> preguntas)
    {
        this.preguntas = preguntas;
        this.nombre = nombre;
    }

    public static List<ItemTest> getTestCreacionales(){
        List<ItemTest> test = new ArrayList<ItemTest>();

        ArrayList<String> preguntas = new ArrayList<>();
        preguntas.add("No conozco las dependencias y tipos exactos de los objetos con los que va a trabajar mi código");
        preguntas.add("Me gustaria dar a los programadores futuros que usen estas clases una forma de extender los componentes internos del mismo");
        preguntas.add("Quiero ahorrar recursos del sistema mediante la reutilización de objetos existentes");
        test.add(new ItemTest("Factory" , preguntas ));

        preguntas = new ArrayList<>();
        preguntas.add("Quiero evitar constructores sobresaturados (muchos parametros o constructores distintos) o con parametros a null");
        preguntas.add("Quiero crear distintas representaciones de distintos objetos (ejemplo: Coche rojo y Coche azul)");
        test.add(new ItemTest("Builder" ,  preguntas));

        preguntas = new ArrayList<>();
        preguntas.add("Mi codigo tiene que funcionar con varias familias de productos relacionados pero no quiero que dependa de clases concretas de estos productos " +
                "(Normalmente porque no los conoces de antemano o quieres facilitar la extensibilidad)");
        test.add(new ItemTest("Abstract Factory" , preguntas ));

        preguntas = new ArrayList<>();
        preguntas.add("Busco una forma de llevar un control estricto de las variables globales");
        preguntas.add("Quiero tener una unica instancia de una clase en todo el programa, la cual este disponible para ser utilizada");
        test.add(new ItemTest("Singleton" ,  preguntas));

        preguntas = new ArrayList<>();
        preguntas.add("Me gustaria reducir las subclases que solo se diferencian en la forma en la que se inicializan sus objetos");
        preguntas.add("Quiero clonar objetos sin acoplarlos a otra clase");
        test.add(new ItemTest("Prototype" ,  preguntas));

        return test;
    }

    public static List<ItemTest> getTestEstructurales(){
        List<ItemTest> test = new ArrayList<ItemTest>();

        ArrayList<String> preguntas = new ArrayList<>();
        preguntas.add("No conozco las dependencias y tipos exactos de los objetos con los que va a trabajar mi código");
        preguntas.add("Me gustaria dar a los programadores futuros que usen estas clases una forma de extender los componentes internos del mismo");
        preguntas.add("Quiero ahorrar recursos del sistema mediante la reutilización de objetos existentes");
        test.add(new ItemTest("Factory" , preguntas ));

        preguntas = new ArrayList<>();
        preguntas.add("Builder");
        preguntas.add("prueba 2");
        test.add(new ItemTest("Prue" ,  preguntas));

        return test;
    }
}

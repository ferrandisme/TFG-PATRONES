package me.ferrandis.TFGPatrones.modelo;

import java.util.ArrayList;
import java.util.List;

public class ItemTest {

    public String nombre;
    public List<String> preguntas;

    public String getPregunta(int contador){
        System.out.println("CONTADOR " +contador);
        return preguntas.get(contador);
    }

    public ItemTest(String nombre , List<String> preguntas)
    {
        this.preguntas = preguntas;
        this.nombre = nombre;
    }

    public static List<ItemTest> getTestEstructurales(){
        List<ItemTest> test = new ArrayList<ItemTest>();

        ArrayList<String> preguntas = new ArrayList<>();
        preguntas.add("test1");
        preguntas.add("test 2");
        test.add(new ItemTest("Test 1" , preguntas ));

        preguntas = new ArrayList<>();
        preguntas.add("prueba 1");
        preguntas.add("prueba 2");
        test.add(new ItemTest("Prueba 1" ,  preguntas));

        return test;
    }
}

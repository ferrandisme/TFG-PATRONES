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
    private static void getTestEstructurales(){
        List<ItemTest> test = new ArrayList<ItemTest>();

        ArrayList<String> questions = new ArrayList<>();
        questions.add("test1");
        questions.add("test 2");
        test.add(new ItemTest("Test 1" , questions ));
        questions = new ArrayList<>();
        questions.add("prueba 1");
        questions.add("prueba 2");
        test.add(new ItemTest("Prueba 1" ,  questions));
    }
}

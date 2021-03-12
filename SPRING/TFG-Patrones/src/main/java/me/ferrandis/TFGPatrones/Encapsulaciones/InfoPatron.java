package me.ferrandis.TFGPatrones.Encapsulaciones;


import lombok.Data;

@Deprecated
//Clase creada por simplicidad con el uso de thymeleaf
@Data
public class InfoPatron {

    public InfoPatron(String texto, String url) {
        this.texto = texto;
        this.url = url;
    }
    String texto;
    String url;
}

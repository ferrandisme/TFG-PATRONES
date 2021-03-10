package me.ferrandis.TFGPatrones.DTO;


import lombok.Data;

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

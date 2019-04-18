package com.example.tecsup.myapplication;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private String nombre;
    static private List<Musica> playlista = new ArrayList<>();

    public PlayList(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Musica> getPlaylista() {
        return playlista;
    }

    public void setPlaylista(List<Musica> playlista) {
        this.playlista = playlista;
    }
}

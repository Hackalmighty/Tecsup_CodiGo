package com.example.tecsup.myapplication;

import android.media.MediaPlayer;
import android.widget.ImageView;

public class Musica {

    int portada;
    MediaPlayer audio;
    String titulo;

    public Musica(int portada, MediaPlayer audio, String titulo) {
        this.portada = portada;
        this.audio = audio;
        this.titulo = titulo;
    }


    public MediaPlayer getAudio() {
        return audio;
    }

    public void setAudio(MediaPlayer audio) {
        this.audio = audio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPortada() {
        return portada;
    }

    public void setPortada(int portada) {
        this.portada = portada;
    }
}

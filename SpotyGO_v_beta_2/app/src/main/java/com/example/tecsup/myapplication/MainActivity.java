package com.example.tecsup.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_play;
    Button btn_next;
    Button btn_back;
    Musica musicaseleccionda;
    Button btn_aleatorio;
    int pos=0;
    PlayList las_romanticas;

    private boolean randomActivado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        las_romanticas = new PlayList("LAS ROMATICAS");
        agregarAudios();

        //Asignar boton a un atributo
        btn_play = (Button)findViewById(R.id.btn_play);
        btn_next = (Button)findViewById(R.id.btn_siguiente);
        btn_back = (Button)findViewById(R.id.btn_atras);
        btn_aleatorio =(Button)findViewById(R.id.btn_aleatorio);

        setEventos();
    }

    private void agregarAudios() {

        //** CREAMOS LA CANCION 2 ROXETE
        MediaPlayer media2 = MediaPlayer.create(this,R.raw.roxette);
        Musica cancion2 = new Musica(R.drawable.roxete_album,media2,"Roxette - dangerous"); //
        //AGRREGAMOS A NUESTRO PLAYLIST
        las_romanticas.getPlaylista().add(cancion2);

        MediaPlayer media3 = MediaPlayer.create(this,R.raw.fuiste);
        Musica cancion3 = new Musica(R.drawable.arjona_album,media3,"Arjona - fuiste tu"); //
        //AGRREGAMOS A NUESTRO PLAYLIST
        las_romanticas.getPlaylista().add(cancion3);

        //** CREAMOS LA CANCION 1 MOLOTOV
        MediaPlayer media1 = MediaPlayer.create(this,R.raw.cuto);
        Musica cancion1 = new Musica(R.drawable.molotov,media1,"MOLOTOV - CUTO"); //
        //AGRREGAMOS A NUESTRO PLAYLIST
        las_romanticas.getPlaylista().add(cancion1);

    }

    private void setEventos() {


        /**
         * Listener de click el boton Play
         */
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ESTA ES LA CANCION SELECCIONADA DEL PLAY LIST
                musicaseleccionda = las_romanticas.getPlaylista().get(pos);

                if(musicaseleccionda.getAudio().isPlaying()){
                    pausar();
                }else{
                    reproducir();
                }
            }
        });
        btn_aleatorio.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                if(randomActivado){
                    randomActivado=false;
                    Toast.makeText(MainActivity.this, "Aleatorio desactivado..", Toast.LENGTH_SHORT).show();
                    btn_aleatorio.setBackgroundResource(R.drawable.random);
                }else{
                    Toast.makeText(MainActivity.this, "Aleatorio activado..", Toast.LENGTH_SHORT).show();
                    btn_aleatorio.setBackgroundResource(R.drawable.randomactivado);
                    randomActivado = true;
                }
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                musicaseleccionda.getAudio().pause();
                musicaseleccionda.getAudio().seekTo(0);

                pos++;

                if(randomActivado){
                    pos = (int) (Math.random() * (las_romanticas.getPlaylista().size()-1));
                }

                musicaseleccionda = las_romanticas.getPlaylista().get(pos); // hemos cambiado de musica
                reproducir();
            }
        });


    }

    private void pausar() {
        musicaseleccionda.getAudio().pause();
        btn_play.setBackgroundResource(R.drawable.playb);
        Toast.makeText(MainActivity.this, "PAUSADO..", Toast.LENGTH_SHORT).show();
    }

    private void reproducir() {

        musicaseleccionda.getAudio().start(); //INICIE LA CANCION

        ImageView imagen = findViewById(R.id.imgbtn);
        imagen.setImageResource(musicaseleccionda.getPortada());

        Toast.makeText(MainActivity.this, musicaseleccionda.getTitulo(), Toast.LENGTH_SHORT).show();

        TextView titulo = findViewById(R.id.titulo);
        titulo.setText(musicaseleccionda.getTitulo());

        btn_play.setBackgroundResource(R.drawable.pauseb);
    }


}

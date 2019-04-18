package com.example.tecsup.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_play;
    Button btn_next;
    Button btn_back;
    Musica musicaseleccionda;
    int pos=0;
    List<Musica> PlayList = new ArrayList<Musica>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignar boton a un atributo
        btn_play = (Button)findViewById(R.id.btn_play);
        btn_next = (Button)findViewById(R.id.btn_siguiente);
        btn_back = (Button)findViewById(R.id.btn_atras);


        //** CREAMOS LA CANCION 1 MOLOTOV
        MediaPlayer media1 = MediaPlayer.create(this,R.raw.cuto);
        Musica cancion1 = new Musica(R.drawable.molotov,media1,"MOLOTOV - CUTO"); //
        //AGRREGAMOS A NUESTRO PLAYLIST
        PlayList.add(cancion1);


        //** CREAMOS LA CANCION 2 ROXETE
        MediaPlayer media2 = MediaPlayer.create(this,R.raw.roxette);
        Musica cancion2 = new Musica(R.drawable.roxete_album,media2,"Roxette - dangerous"); //
        //AGRREGAMOS A NUESTRO PLAYLIST
        PlayList.add(cancion2);

        MediaPlayer media3 = MediaPlayer.create(this,R.raw.fuiste);
        Musica cancion3 = new Musica(R.drawable.arjona_album,media3,"Arjona - fuiste tu"); //
        //AGRREGAMOS A NUESTRO PLAYLIST
        PlayList.add(cancion3);

        setEventos();
    }

    private void setEventos() {

        /**
         * Listener de click el boton Play
         */
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ESTA ES LA CANCION SELECCIONADA DEL PLAY LIST
                musicaseleccionda = PlayList.get(pos);

                if(musicaseleccionda.getAudio().isPlaying()){
                    pausar();
                }else{
                    reproducir();
                }
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicaseleccionda.getAudio().stop();
                pos++;
                musicaseleccionda = PlayList.get(pos); // hemos cambiado de musica
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

package com.santiago.tutifruti;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    class CustomTextWatcher implements TextWatcher{
        EditText texto;
        String[] opciones;
        int indicePuntaje;

        public CustomTextWatcher(EditText editText, String[] op, int ip) {
            texto = editText;
            opciones = op;
            indicePuntaje = ip;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.toString().toCharArray().length > 0 && s.toString().toCharArray()[0] != l ){
                texto.setText("");
            }
            Log.d("opciones",opciones.toString());
            puntajeDetallado[indicePuntaje] = ObtenerPuntaje(s.toString(), opciones);


        }
    }

    //Declarando componentes del Layout
    TextView letra;
    TextView temporizador;
    Button botonIniciar;
    LinearLayout vlciudad;
    LinearLayout vlpais;
    LinearLayout vlanimal;
    LinearLayout vlcolor;
    LinearLayout vlfruta;
    LinearLayout vltotal;

    //Declarando otras variables
    char l;
    CountDownTimer cd;
    int totalFinal = 0;
    int totalParcial = 0;
    int[] puntajeDetallado = new int[] {0,0,0,0,0};
    String[] ciudades = new String[]{"Arequipa", "Lima", "Cajamarca"};
    String[] paises = new String[]{"China", "Qatar", "Brasil"};
    String[] animales = new String[]{"cuy", "gato", "peroo"};
    String[] colores = new String[]{"Rojo", "Verde", "Azul"};
    String[] frutas = new String[]{"manzana", "uva", "chirimoya"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Llamamos al onCreate del padre
//Relacionabamos con nuestro layout        super.onCreate(savedInstanceState);
        //Relacionabamos con nuestro layout
        setContentView(R.layout.activity_main);

        //Enlazamos las variables con los objetos del layout
        letra = findViewById(R.id.tvLetra);
        temporizador = findViewById(R.id.temporizador);
        botonIniciar = findViewById(R.id.botonIniciar);
        vlciudad = findViewById(R.id.vlCiudad);
        vlpais = findViewById(R.id.vlPais);
        vlanimal = findViewById(R.id.vlAnimal);
        vlcolor = findViewById(R.id.vlColor);
        vlfruta = findViewById(R.id.vlFruta);
        vltotal = findViewById(R.id.vlTotal);

        //Creamos nuestro objeto temporizador, que tendra intervalos de 1 seg, y termina a los 60 seg
        cd = new CountDownTimer(60000, 1000) {

            //Metodo que se llamara en cada segundo
            public void onTick(long millisUntilFinished) {
                temporizador.setText(""+ millisUntilFinished / 1000);
            }

            //Metodo que se llamara cuando termine el contador
            public void onFinish() {
                botonIniciar.setEnabled(true);
                temporizador.setText(""+0);
                MostrarPuntajeRonda();
            }
        };
    }

    void MostrarPuntajeRonda(){
        //Creo un TextView
        TextView t = new TextView(this);
        //Calculo el puntaje total de la ronda
        int ptotalRonda  = 0;
        for (int i =0; i< puntajeDetallado.length;i++){
            Log.d("puntaje",puntajeDetallado[i] +" ");
            ptotalRonda+= puntajeDetallado[i];
        }
        //asigno el puntaje al text view
        t.setText(""+ptotalRonda);
        // agrego mi textview al lay out
        vltotal.addView(t);
    }

    // Recibe el click del boton
    public void PresionoIniciar(View v ){
        l = LetraAleatoria();
        letra.setText("" + l);
        IniciarTemporizador();
        botonIniciar.setEnabled(false);
        CrearEditText();
    }

    //Crea edit texts para cada linear layout
    private void CrearEditText(){
        // Creamos un Edit Text
        EditText ciudad = new EditText(this);
        // Creamos un Text Watcher
        CustomTextWatcher tw = new CustomTextWatcher(ciudad,ciudades,0);
        // Agremamos el TextWatcher a el listener de ciudad
        ciudad.addTextChangedListener(tw);
        // Agregamos el edit text ciudad a nuestro vertical layout
        vlciudad.addView(ciudad);

        EditText pais = new EditText(this);
        CustomTextWatcher tw2 = new CustomTextWatcher(pais,paises,1);
        pais.addTextChangedListener(tw2);
        vlpais.addView(pais);

        EditText animal = new EditText(this);
        CustomTextWatcher tw3 = new CustomTextWatcher(animal,animales,2);
        animal.addTextChangedListener(tw3);
        vlanimal.addView(animal);

        EditText color = new EditText(this);
        CustomTextWatcher tw4 = new CustomTextWatcher(color,colores,3);
        color.addTextChangedListener(tw4);
        vlcolor.addView(color);

        EditText fruta = new EditText(this);
        CustomTextWatcher tw5 = new CustomTextWatcher(fruta,frutas,4);
        fruta.addTextChangedListener(tw5);
        vlfruta.addView(fruta);
    }

    private void IniciarTemporizador(){
        cd.start();
    }

    public char LetraAleatoria(){
        // 65 al 90
        //int n = (int)(65+(Math.random()*25));
        int n = (int)(97+(Math.random()*25));
        return 'c';
    }

    int ObtenerPuntaje(String palabra, String[] opciones){
        //Iteramos por las opciones
        for(int i = 0; i < opciones.length ; i++){
            //Comparamos la palabra en minusculas, con las opciones en minusculas
            if(palabra.toLowerCase().equals(opciones[i].toLowerCase())){
                return 100;
            }
        }
        return 0;
    }
}

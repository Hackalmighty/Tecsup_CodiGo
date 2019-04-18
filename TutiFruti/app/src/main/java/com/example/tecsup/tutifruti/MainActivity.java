package com.example.tecsup.tutifruti;


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

        public CustomTextWatcher(EditText editText, String[] op, int ip){
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
            if(s.toString().toCharArray().length>0 && s.toString().toCharArray()[0]!=l){
                ciudad.setText("");
            }
            log.d("opciones", opciones.toString());
            puntajedetallado[indicePuntaje] = ObtenerPuntaje(s.toString(), opciones);
        }


    }

    //Declarando componentes del Layout
    TextView letra;
    TextView temporizador;
    Button botoniniciar;
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
    //int puntajeacumulado=0;
    int[] puntajedetallado = new int [] {0,0,0,0,0};
    String [] ciudades = new String []{"Arequipa", "Lima", "Cajaramarca"};
    String [] paises = new String []{"China", "Qatar", "Brasil"};
    String [] animales = new String []{"Cuy", "Gato", "Perro"};
    String [] colores = new String []{ "Rojo", "Verde", "Azul"};
    String [] frutas = new String []{"Manzana", "Uva", "Chirimoya"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Llamamos al onCreate del padre
        super.onCreate(savedInstanceState);
        //Relacionabamos con nuestro layout
        setContentView(R.layout.activity_main);

        //Enlazamos las variables con los objetos del layout
        letra = findViewById(R.id.tvLetra);
        //puntajeacumulado = findViewById(R.id.tvLetra);
        temporizador=findViewById(R.id.temporizador);
        botoniniciar=findViewById(R.id.botonIniciar);
        vlciudad=findViewById(R.id.vlCiudad);
        vlpais=findViewById(R.id.vlPais);
        vlanimal=findViewById(R.id.vlAnimal);
        vlcolor=findViewById(R.id.vlColor);
        vlfruta=findViewById(R.id.vlFruta);
        vltotal=findViewById(R.id.vlTotal);

        //Creamos nuestro objeto temporizador, que tendra intervalos de 1 seg, y termina a los 60 seg
        cd = new CountDownTimer(60000,1000) {

            //Metodo que se llamara en cada segundo
            public void onTick(long millisUntilFinished) {
                temporizador.setText(""+millisUntilFinished/1000);
            }

            //Metodo que se llamara cuando termine el contador
            public void onFinish() {
                botoniniciar.setEnabled(true);
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
        for (int i =0; i< puntajedetallado.length;i++){
            Log.d("puntaje",puntajedetallado[i] +" ");
            ptotalRonda+= puntajedetallado[i];
        }
        //asigno el puntaje al text view
        t.setText(""+ptotalRonda);
        // agrego mi textview al lay out
        vltotal.addView(t);
    }

    public void PresionoIniciar(View v){
        l = LetraAleatoria();
        letra.setText("" +l);
        IniciarTemporizador();
        botoniniciar.setEnabled(false);
        CrearEditText();
    }
    //Crea edit texts para cada linear layout
    private void CrearEditText() {
        // Creamos un Edit Text
        final EditText ciudad = new EditText(this);
        // Creamos un Text Watcher
        CustomTextWatcher tw = new CustomTextWatcher(ciudad,ciudades,0);
        // Agremamos el TextWatcher a el listener de ciudad
        ciudad.addTextChangedListener(tw);
        // Agregamos el edit text ciudad a nuestro vertical layout
        vlciudad.addView(ciudad);

        final EditText pais = new EditText(this);
        CustomTextWatcher tw1 = new CustomTextWatcher(pais,paises,1);
        ciudad.addTextChangedListener(tw);
        vlciudad.addView(ciudad);

        final EditText animal = new EditText(this);
        CustomTextWatcher tw2 = new CustomTextWatcher(animal,animales,2);
        ciudad.addTextChangedListener(tw);
        vlciudad.addView(animal);

        final EditText color = new EditText(this);
        CustomTextWatcher tw3 = new CustomTextWatcher(color,colores,3);
        ciudad.addTextChangedListener(tw);
        vlciudad.addView(ciudad);

        final EditText fruta = new EditText(this);
        CustomTextWatcher tw4 = new CustomTextWatcher(fruta,frutas,4);
        ciudad.addTextChangedListener(tw);
        vlciudad.addView(ciudad);




    }


    private void IniciarTemporizador(){
        cd.start();
    }

    public char LetraAleatoria(){
        //del 65 al 90
        //int n = (int)(65 + (Math.random()*25));
        int n = (int)(97 + (Math.random()*25));
        return (char) n;
    }

    int ObtenerPuntaje(String palabra, String[]opciones){
        for(int i = 0; i <opciones.length; i++){
            //comparamos la palabra en minusculas, con las opciones ne minusculas
            if(palabra.toLowerCase().equals(opciones[i].toLowerCase())){
                return 100;
            }
        }
        return 0;
    }
}

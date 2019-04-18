package com.example.tecsup.registrowilly;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Registro extends AppCompatActivity {

    Button btnImprimir;
    TextView nom;
    TextView ape;
    TextView pass;
    TextView edad;
    TextView mail;
    TextView celular;
    RadioGroup RG;
    RadioButton radhombre;
    RadioButton radmujer;
    CheckBox cb_programacion;
    CheckBox cb_viajes;
    CheckBox cb_musica;
    CheckBox cb_autos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        List<String> spiner = new ArrayList<String>();
        spiner.add("Arequipa");
        spiner.add("Lima");
        spiner.add("Cuzco");
        spiner.add("Cajamarca");
        spiner.add("Tacna");
        Spinner spinner = findViewById(R.id.spn);

        ArrayAdapter<String> adapter =new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_dropdown_item,spiner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnImprimir = findViewById(R.id.btn_imprimir);
        nom = findViewById(R.id.etNombre);
        ape = findViewById(R.id.etApellido);
        pass = findViewById(R.id.etPassword);
        edad = findViewById(R.id.etEdad);
        mail = findViewById(R.id.etEmail);
        celular = findViewById(R.id.etCelular);
        radhombre = findViewById(R.id.rbtn_hombre);
        radmujer = findViewById(R.id.rbtn_mujer);
        RG=findViewById(R.id.rg);
        cb_programacion = findViewById(R.id.chkProgramacion);
        cb_viajes=findViewById(R.id.chkViajes);
        cb_musica=findViewById(R.id.chkMusica);
        cb_autos=findViewById(R.id.chkAutos);




        btnImprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println(nom.getText());
                System.out.println(ape.getText());
                System.out.println(pass.getText());
                System.out.println(edad.getText());
                System.out.println(mail.getText());

                if(cb_programacion.isChecked())
                {
                    System.out.println("Interes: "+cb_programacion.getText());
                }
                 if(cb_viajes.isChecked())
                {
                    System.out.println("Interes: "+cb_viajes.getText());
                }
                 if(cb_musica.isChecked())
                {
                    System.out.println("Interes: "+cb_musica.getText());
                }
                 if(cb_autos.isChecked())
                {
                    System.out.println("Interes: "+cb_autos.getText());
                }





            }
        });



    }









}

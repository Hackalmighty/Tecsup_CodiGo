package com.example.tecsup.remedo_de_intent_willy_xd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundoWillyXD extends AppCompatActivity {
    Button b;
    int num_boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_willy_xd);
        b = findViewById(R.id.button5);

        Intent i =getIntent();
        num_boton = i.getIntExtra("boton", 0);
        b.setText(i.getIntExtra("boton",0)+"");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent respuesta = new Intent();
                respuesta.putExtra("boton", num_boton);
                setResult(RESULT_OK, respuesta);
                finish();
            }
        });

    }
}

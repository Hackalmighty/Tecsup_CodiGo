package com.example.tecsup.remedo_de_intent_willy_xd;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityIntentWilly extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    Button b4;

    int c1 = 0;
    int c2 = 0;
    int c3 = 0;
    int c4 = 0;

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intent_willy);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);

        tv1.setText(" " + 0);
        tv2.setText(" " + 0);
        tv3.setText(" " + 0);
        tv4.setText(" " + 0);

        llenarTextView();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SegundoWillyXD.class);
                i.putExtra("boton", 1);
                startActivityForResult(i,1);// voy a iniciar, pero voy a esperar un resultado

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SegundoWillyXD.class);
                i.putExtra("boton", 2);
                startActivityForResult(i,1);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SegundoWillyXD.class);
                i.putExtra("boton", 3);
                startActivityForResult(i,1);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SegundoWillyXD.class);
                i.putExtra("boton", 4);
                startActivityForResult(i,1);

            }
        });

    }

    private void llenarTextView() {
        tv1.setText(" " + c1);
        tv2.setText(" " + c2);
        tv3.setText(" " + c3);
        tv4.setText(" " + c4);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            int d = data.getIntExtra("boton", 0);

            switch (d){
                case 1:
                    c1++;
                    break;
                case 2:
                    c2++;
                    break;
                case 3:
                    c3++;
                    break;
                case 4:
                    c4++;
                    break;
            }

            llenarTextView();





    }
}

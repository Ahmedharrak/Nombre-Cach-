package com.example.nombrecach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity4 extends AppCompatActivity {
    private Button b1,b2,b3;
    private EditText ed;
    private TextView tx,tx11;
    private String KEY_Value = "value_key";
    private String KEY_RESULTAT = "resultat_key";
    private static final String KEY_NOM = "nom_key";
    private int min = 0;
    private int max = 9999;
    private int random = new Random().nextInt((max - min) + 1) + min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        b1 = findViewById(R.id.b9);
        b2 = findViewById(R.id.b10);
        b3 = findViewById(R.id.b11);
        tx11 = findViewById(R.id.edit_view7);
        tx = findViewById(R.id.edit_view8);
        ed = findViewById(R.id.edit_text4);
        ed.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "10000")});
        if (savedInstanceState != null) {
            String savedResultat = savedInstanceState.getString(KEY_RESULTAT);
            tx.setText(savedResultat);

            String savedValue = savedInstanceState.getString(KEY_Value);
            ed.setText(savedValue);

        }
        Bundle extras= getIntent().getExtras();
        if(extras != null)
        {
            String newString=extras.getString(KEY_NOM);
            Toast.makeText(getApplicationContext(), "Bienvenu "+newString, Toast.LENGTH_SHORT).show();
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(ed.getText().toString());

                if ( random > num1){
                    tx.setText("Le nombre est très petit ! Essayez avec un plus grand nombre");
                }
                else if(random < num1){
                    tx.setText("Le nombre est très grand ! Essayez avec un plus petit nombre");
                }
                else if(random == num1){
                    tx.setText("Bien joué !");
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity4.this,MainActivity4.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putString(KEY_RESULTAT, tx.getText().toString());
        savedInstanceState.putString(KEY_Value, ed.getText().toString());


        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tx.setText(savedInstanceState.getString(KEY_RESULTAT));
        ed.setText(savedInstanceState.getString(KEY_Value));



    }
}
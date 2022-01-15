package com.example.nombrecach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b1,b2;
    private EditText ed;
    private RadioGroup rg;
    private RadioButton r1,r2,r3;
    private static final String KEY_NOM = "nom_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        ed = findViewById(R.id.edit_text1);
        rg = findViewById(R.id.rd);
        r1 = findViewById(R.id.radio1);
        r2 = findViewById(R.id.radio2);
        r3 = findViewById(R.id.radio3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Entrer votre Nom", Toast.LENGTH_SHORT).show();

                }
                else{
                    if (r1.isChecked()){
                        Intent i = new Intent(MainActivity.this,MainActivity2.class);
                        i.putExtra(KEY_NOM,ed.getText().toString() );
                        startActivity(i);
                    }
                    else if(r2.isChecked()){
                        Intent i = new Intent(MainActivity.this,MainActivity3.class);
                        i.putExtra(KEY_NOM,ed.getText().toString() );
                        startActivity(i);
                    }
                    else if(r3.isChecked()){
                        Intent i = new Intent(MainActivity.this,MainActivity4.class);
                        i.putExtra(KEY_NOM,ed.getText().toString() );
                        startActivity(i);
                    }
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (savedInstanceState != null) {
            String savedNom = savedInstanceState.getString(KEY_NOM);
            ed.setText(savedNom);
        }else{
            Toast.makeText(this, "Nouvelle Page", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean("myOption1", r1.isChecked());
        savedInstanceState.putBoolean("myOption2", r2.isChecked());
        savedInstanceState.putBoolean("myOption3", r3.isChecked());
        savedInstanceState.putString(KEY_NOM, ed.getText().toString());
        super.onSaveInstanceState(savedInstanceState);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        r1.setChecked(savedInstanceState.getBoolean("myOption1"));
        r2.setChecked(savedInstanceState.getBoolean("myOption2"));
        r3.setChecked(savedInstanceState.getBoolean("myOption3"));
        ed.setText(savedInstanceState.getString(KEY_NOM));

    }
}
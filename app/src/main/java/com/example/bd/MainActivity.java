package com.example.bd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.bd.bd.Bdcrud;
import com.example.bd.bd.DBhelper;

public class MainActivity extends AppCompatActivity {


    private Button boton1;

    EditText txtplaca,txtmodelo,txtcolor;
    Button enviardato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1 = findViewById(R.id.boton1);
        txtplaca=findViewById(R.id.placa);
        txtcolor=findViewById(R.id.color);
        txtmodelo=findViewById(R.id.modelo);

        enviardato=findViewById(R.id.enviar);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBhelper database = new DBhelper(MainActivity.this);
                SQLiteDatabase db =database.getWritableDatabase();
                 if(db != null){
                     Toast.makeText(MainActivity.this,"BASE DE DATOS CREADA",Toast.LENGTH_LONG).show();
                 }else{
                     Toast.makeText(MainActivity.this,"ERROR AL CREAR LA BASE DE DATOS",Toast.LENGTH_LONG).show();
                 }
            }
        });
        enviardato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bdcrud database = new Bdcrud(MainActivity.this);
                long  id = database.insertardato(txtplaca.getText().toString(),txtmodelo.getText().toString(),txtcolor.getText().toString());

                if( id > 0 ){
                    Toast.makeText(MainActivity.this,"DATO INSERTADO",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"ERROR AL INSERTAR DATO",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
package com.example.usuario.icantfindjson.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.usuario.icantfindjson.R;

public class MainActivity extends AppCompatActivity {
Button btnQuiniela,btnContactos,btnGson,btnRepositorio,btnCreacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnQuiniela=findViewById(R.id.btnQuiniela);
        btnContactos=findViewById(R.id.btnContactos);
        btnGson=findViewById(R.id.btnContactosGson);
        btnRepositorio=findViewById(R.id.btnRepositorios);
        btnCreacion=findViewById(R.id.btnCreacion);
        btnQuiniela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,QuinielaActivity.class));
            }
        });
        btnContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ContactosActivity.class));
            }
        });
        btnGson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,GsonActivity.class));
            }
        });
        btnRepositorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RepositorioActivity.class));
            }
        });
        btnCreacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CreacionJsonActivity.class));
            }
        });

    }
}

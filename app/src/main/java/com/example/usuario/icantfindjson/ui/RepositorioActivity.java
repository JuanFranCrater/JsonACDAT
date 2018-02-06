package com.example.usuario.icantfindjson.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usuario.icantfindjson.R;
import com.example.usuario.icantfindjson.pojo.ClickListener;
import com.example.usuario.icantfindjson.pojo.RecyclerTouchListener;
import com.example.usuario.icantfindjson.pojo.Repo;
import com.example.usuario.icantfindjson.pojo.RepositoryAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositorioActivity extends AppCompatActivity implements View.OnClickListener, Callback<ArrayList<Repo>> {

    EditText nombreUsuario;
    Button botonDescarga;
    RecyclerView rvRepos;
    private RepositoryAdapter adapter;
    private ArrayList<Repo> repos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositorio);
        nombreUsuario = (EditText) findViewById(R.id.editText);
        botonDescarga = (Button) findViewById(R.id.button);
        botonDescarga.setOnClickListener(this);
        rvRepos = (RecyclerView) findViewById(R.id.recyclerView);
        repos=new ArrayList<>();
        adapter = new RepositoryAdapter(this,repos);
        rvRepos.setAdapter(adapter);
        rvRepos.setLayoutManager(new LinearLayoutManager(this));
        rvRepos.addOnItemTouchListener(new RecyclerTouchListener(this, rvRepos, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "position " + position + " was clicked!",
                        Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse((String) repos.get(position).getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                else
                    Toast.makeText(getApplicationContext(), "No hay un navegador",
                            Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onResponse(Call<ArrayList<Repo>> call, Response<ArrayList<Repo>> response) {

    }

    @Override
    public void onFailure(Call<ArrayList<Repo>> call, Throwable t) {

    }
}

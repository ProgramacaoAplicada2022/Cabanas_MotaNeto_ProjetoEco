package com.example.Projeto_Eco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Abadateoria extends AppCompatActivity {
    private Button botaovoltar7;
    private Button consumoButton;
    private Button lampadaButton;
    private Button gelButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abadateoria);
        botaovoltar7 = findViewById(R.id.botaovoltar7);
        consumoButton = findViewById(R.id.botaoproximo2);
        lampadaButton = findViewById(R.id.botaoproximo);
        gelButton = findViewById(R.id.botaoproximo3);
      gelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaiparatelageladeira();
            }
        });
        lampadaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaiparateolampada();
            }
        });
        consumoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaiparatelaconsumo();
            }
        });
        botaovoltar7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltaparaselecoes();
            }
        });
    }
    public void voltaparaselecoes(){
        Intent intent = new Intent(this,teladeselecoes.class);
        startActivity(intent);
    }
    public void vaiparateolampada(){
        Intent intent = new Intent(this,teoLampada.class);
        startActivity(intent);
    }
    public void vaiparatelaconsumo(){
        Intent intent = new Intent(this,teoconsu.class);
        startActivity(intent);
    }
    public void vaiparatelageladeira(){
        Intent intent = new Intent(this,teogel.class);
        startActivity(intent);
    }

}
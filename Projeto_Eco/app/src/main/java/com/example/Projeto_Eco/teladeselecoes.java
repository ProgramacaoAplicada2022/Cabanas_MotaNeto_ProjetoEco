package com.example.Projeto_Eco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class teladeselecoes extends AppCompatActivity {
    private Button botaocontas;
    private Button botaoquiz;
    private Button botaoteoria;
    private Button botaovoltar;
    private Button botaovoltartelainicial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teladeselecoes);
        botaocontas = findViewById(R.id.botaocontas);
        botaoquiz=findViewById(R.id.botaoquiz);
        botaoteoria=findViewById(R.id.botaoteoria);
        botaovoltar=findViewById(R.id.botaovoltar);
        botaovoltartelainicial = findViewById(R.id.botaovoltartelainicial);
        botaovoltar .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openteladelogin();
            }
        });
        botaocontas .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openteladecontas();
            }
        });
        botaoquiz .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openteladequiz();
            }
        });
        botaoteoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openteladeteoria();
            }
        });
        botaovoltartelainicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {opentelainicial();
            }
        });
    }
    public void openteladecontas(){
        Intent intent = new Intent(this,teladecontas.class);
        startActivity(intent);
    }
    public void openteladequiz(){
        Intent intent = new Intent(this,Teladequiz.class);
        startActivity(intent);
    }
    public void openteladeteoria(){
        Intent intent = new Intent(this,Abadateoria.class);
        startActivity(intent);
    }
    public void openteladelogin(){
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }
    public void opentelainicial(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}
package com.example.Projeto_Eco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class teladeteoria extends AppCompatActivity {
    private Button botaovoltar5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teladeteoria);
        botaovoltar5= findViewById(R.id.botaovoltar5);
        botaovoltar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openteladeselecoes();
            }
        });
    }
    public void openteladeselecoes(){
        Intent intent = new Intent(this,teladeselecoes.class);
        startActivity(intent);
    }
}
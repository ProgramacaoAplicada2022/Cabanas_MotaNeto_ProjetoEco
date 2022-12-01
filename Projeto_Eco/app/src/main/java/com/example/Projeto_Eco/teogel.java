package com.example.Projeto_Eco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class teogel extends AppCompatActivity {
    private Button botao11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teogel);
        botao11 = findViewById(R.id.botaovoltar11);
        botao11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openaba();
            }
        });
    }
    public void openaba(){
        Intent intent = new Intent(this,Abadateoria.class);
        startActivity(intent);
    }
}
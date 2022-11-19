package com.example.Projeto_Eco;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class login extends AppCompatActivity {
    private Button botao_login13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        botao_login13 = findViewById(R.id.botao_login13);
        botao_login13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogin();
            }
        });
    }
    public void openlogin(){
        Intent intent = new Intent(this,teladeselecoes.class);
        startActivity(intent);
    }

}
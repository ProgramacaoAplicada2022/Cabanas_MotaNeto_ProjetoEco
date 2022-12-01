package com.example.Projeto_Eco;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Teladequiz extends AppCompatActivity implements View.OnClickListener {
    TextView totaldequestoesview;
    TextView questoesview;
    Button RA,RB,RC,RD;
    Button responder;
    int score=0;
    int totalquestoes = Perguntaserespostas.questao.length;//a partir da classe
    int atualquestao=0;
    String Escolhida="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teladequiz);
        totaldequestoesview = findViewById(R.id.TotaldeQuestoes);
        questoesview = findViewById(R.id.perguntas);
        RA = findViewById(R.id.RA);
        RB = findViewById(R.id.RB);
        RC = findViewById(R.id.RC);
        RD = findViewById(R.id.RD);
        responder = findViewById(R.id.responder);
        RA.setOnClickListener(this);
        RB.setOnClickListener(this);
        RC.setOnClickListener(this);
        RD.setOnClickListener(this);
        responder.setOnClickListener(this);

        totaldequestoesview.setText("Total de Questões:"+totalquestoes);
        novaquestao();



    }


    @Override
    public void onClick(View view) {
        RA.setBackgroundColor(Color.WHITE);
        RB.setBackgroundColor(Color.WHITE);
        RC.setBackgroundColor(Color.WHITE);
        RD.setBackgroundColor(Color.WHITE);

Button click = (Button)view;
if(click.getId()==R.id.responder){
    if(Escolhida.equals(Perguntaserespostas.Respostascorretas[atualquestao])){
        score++;
    }
    atualquestao++;
    novaquestao();


}else{
    //botao de escolhas
    Escolhida = click.getText().toString();
    click.setBackgroundColor(Color.CYAN);
}
    }

    void novaquestao(){
        if(atualquestao == totalquestoes){
            terminarquiz();
            return;
        }//fim do quiz
        questoesview.setText(Perguntaserespostas.questao[atualquestao]);
        RA.setText(Perguntaserespostas.escolhas[atualquestao][0]);
        RB.setText(Perguntaserespostas.escolhas[atualquestao][1]);
        RC.setText(Perguntaserespostas.escolhas[atualquestao][2]);
        RD.setText(Perguntaserespostas.escolhas[atualquestao][3]);

    }
    void terminarquiz(){
        String mensagem="";
        if(score == 0){
            mensagem = "Você é consciente com os gastos.O meio ambiente e o Eco agradecem";

        }
        if(score == totalquestoes/3){
            mensagem = "Você é consciente em quase todos os quesitos,continue assim";

        }
        if(score == totalquestoes*2/3){
            mensagem = " Pode melhorar através da nossa aba de teoria,vem com a gente!";

        }
        if(score == totalquestoes){
            mensagem = "A consciência de gastos foi ruim,vem aprender com a teoria da Eco!";
        }

        new AlertDialog.Builder(this)
                .setTitle(mensagem)
                .setMessage("Escolhas que geram gastos: "+ score+" de "+totalquestoes)
                .setPositiveButton("Restart",((dialogInterface, i) -> restart()))
                .setNeutralButton("Teoria",((dialogInterface, i) -> teoria()))
                .setCancelable(false)
                .show();
    }
    void restart(){
score =0;
atualquestao=0;
novaquestao();;
    }
    void teoria(){
        Intent intent = new Intent(this,Abadateoria.class);
        startActivity(intent);
    }
}
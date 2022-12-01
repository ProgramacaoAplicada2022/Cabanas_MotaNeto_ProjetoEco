package com.example.Projeto_Eco;

import static com.example.Projeto_Eco.ConstanteActivity.CHAVE_CONTA;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Projeto_Eco.Conta.Conta;
import com.example.Projeto_Eco.DAO.ContaDAO;

public class telacalculos extends AppCompatActivity {
    double num1, num2,num3, res,res2;
    private Button botaovoltar3;
    private EditText campoNome;
    private EditText campoPrecoKWH;
    private EditText campoPotencia;
    private EditText campoHorasDeUso;
    private final ContaDAO dao = new ContaDAO();
    private Conta conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telacalculos);

        inicializacaoDosCampos();

        carregaConta();

        configuraBotaoSalvar();

        botaovoltar3 = findViewById(R.id.botaovoltar3);

        botaovoltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openteladecontas();
            }
        });

        Button multiplicar = (Button) findViewById(R.id.multiplicar);

        TextView Kwh = (TextView) findViewById(R.id.Kwh);

        TextView mensal = (TextView) findViewById(R.id.mensal);

        //EditText Poder = (EditText) findViewById(R.id.Poder);
        //EditText Horas = (EditText) findViewById(R.id.Horas);
        //EditText Preço = (EditText) findViewById(R.id.Preço);
        //EditText Nome = (EditText) findViewById(R.id.Nome);

        multiplicar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                num1 = Double.parseDouble(campoPotencia.getText().toString());
                num2 = Double.parseDouble(campoHorasDeUso.getText().toString());
                num3 = Double.parseDouble(campoPrecoKWH.getText().toString());
                res = num1 * num2*0.001;
                res2 = res*num3*30*num2;
                Kwh.setText(String.valueOf(res));
                mensal.setText(String.valueOf(res2));
            }
        });

    }

    private void preencheCampos() {
        campoNome.setText(conta.getNome());
        campoPrecoKWH.setText(conta.getPreco_kWh());
        campoPotencia.setText(conta.getPotencia());
        campoHorasDeUso.setText(conta.getHoras_uso());

        //Ver como preenche com as contas feitas
    }

    private void finalizaFormulario() {
        preencheConta();
        if (conta.temIdValido()) {
            dao.edita(conta);
            Toast.makeText(this, "Salvo!", Toast.LENGTH_SHORT).show();
        } else {
            dao.salva(conta);
            Toast.makeText(this, "Salvo!", Toast.LENGTH_SHORT).show();
        }
        openteladecontas();
    }

    private void carregaConta() {
        Intent dados = getIntent();
        if (dados.hasExtra(CHAVE_CONTA)) {
            conta = (Conta) dados.getSerializableExtra(CHAVE_CONTA);
            preencheCampos(); //preenche os campos com o que ja foi inserido
        } else{
            conta = new Conta();
        }
    }

    private void preencheConta() {
        String nome = campoNome.getText().toString();
        String horas_de_uso = campoHorasDeUso.getText().toString();
        String potencia = campoPotencia.getText().toString();
        String precoKWH = campoPrecoKWH.getText().toString();
        conta.setNome(nome);
        conta.setHoras_uso(horas_de_uso);
        conta.setPotencia(potencia);
        conta.setPreco_kWh(precoKWH);
        conta.setPreco_consumo(Double.toString(res2));
        conta.setConsumo_mensal(Double.toString(res));

    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.Nome);
        campoHorasDeUso = findViewById(R.id.Horas);
        campoPotencia = findViewById(R.id.Poder);
        campoPrecoKWH = findViewById(R.id.Preço);
        //EditText Poder = (EditText) findViewById(R.id.Poder);
        //EditText Horas = (EditText) findViewById(R.id.Horas);
        //EditText Preço = (EditText) findViewById(R.id.Preço);
        //EditText Nome = (EditText) findViewById(R.id.Nome);
    }

    public void openteladecontas(){
        Intent intent = new Intent(this,teladecontas.class);
        startActivity(intent);
    }

        private void salva(Conta conta) {
        dao.salva(conta);
        openteladecontas(); //retorna ´pra anterior
    }
    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.botaoSalvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalizaFormulario();
            }
        });
    }

}


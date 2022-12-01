package com.example.Projeto_Eco;

import static com.example.Projeto_Eco.ConstanteActivity.CHAVE_CONTA;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.Projeto_Eco.Conta.Conta;
import com.example.Projeto_Eco.DAO.ContaDAO;


public class AtributosContasActivity extends AppCompatActivity{
    private EditText campoNome;
    private EditText campoPrecoKWH;
    private EditText campoPotencia;
    private EditText campoHorasDeUso;
    private final ContaDAO dao = new ContaDAO();
    private Conta conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_telacalculos);
        inicializacaoDosCampos(); //onde entra cada atributo
        //configuraBotaoSalvar();
        carregaConta();
    }


    //Ver como mudar esse menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calculos_conta_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    //Ver como mudar esse menu salvar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_calculos_conta_menu_salvar) {
            finalizaFormulario();
        }
        return super.onOptionsItemSelected(item);
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

    private void preencheCampos() {
        campoNome.setText(conta.getNome());
        campoPrecoKWH.setText(conta.getPreco_kWh());
        campoPotencia.setText(conta.getPotencia());
        campoHorasDeUso.setText(conta.getHoras_uso());

        //Ver como preenche com as contas feitas
    }

    //    private void configuraBotaoSalvar() {
//        Button botaoSalvar = findViewById(R.id.activity_calculadora_botao_salvar);
//        botaoSalvar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finalizaFormulario();
//            }
//        });
//    }

    private void finalizaFormulario() {
        preencheConta();
        if (conta.temIdValido()) {
            dao.edita(conta);
        } else {
            dao.salva(conta);
        }
        finish();
    }

    private void inicializacaoDosCampos() {
        //campoNome = findViewById(R.id.activity_formulario_refeicao_nome);
        //campoHorasDeUso = findViewById(R.id.activity_formulario_refeicao_hora);
        //campoPotencia = findViewById(R.id.activity_formulario_refeicao_ptn);
       // campoPrecoKWH = findViewById(R.id.activity_formulario_refeicao_carb);
    }
//    private void salva(Refeicao refeicao) {
//        dao.salva(refeicao);
//        finish(); //retorna ´pra anterior
//    }

    private void preencheConta() {
        String nome = campoNome.getText().toString();
        String horas_de_uso = campoHorasDeUso.getText().toString();
        String potencia = campoPotencia.getText().toString();
        String precoKWH = campoPrecoKWH.getText().toString();
        conta.setNome(nome);
        conta.setHoras_uso(horas_de_uso);
        conta.setPotencia(potencia);
        conta.setPreco_kWh(precoKWH);

        //  Refeicao refeicaoCriada = new Refeicao(nome, ptn, carbo, hortA, hortB);
        //para so atualizar return new Refeicao(nome, ptn, carbo, hortA, hortB);
    }

}

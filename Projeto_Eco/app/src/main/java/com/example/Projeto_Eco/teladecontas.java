package com.example.Projeto_Eco;

import static com.example.Projeto_Eco.ConstanteActivity.CHAVE_CONTA;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Projeto_Eco.DAO.ContaDAO;
import com.example.Projeto_Eco.R;
import com.example.Projeto_Eco.Conta.Conta;
import com.example.Projeto_Eco.Adapter.ListaContasAdapter;

public class teladecontas extends AppCompatActivity {
    private Button botaocalculadora;
    private Button botaovoltar2;
    private Button botaovoltar3;
    private final ContaDAO dao = new ContaDAO();
    private ListaContasAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_teladecontas);

        //configuraFabNovaConta();
        configuraListaContas();

        botaocalculadora = findViewById(R.id.botaocalculadora);
        botaocalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openteladecalculos();
            }
        });
        botaovoltar2= findViewById(R.id.botaovoltar5);
        botaocalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openteladeselecoes();
            }
        });
        botaovoltar3 = findViewById(R.id.botaovoltar3);
        botaovoltar3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {openteladecalculos();
            }
        });

    }

    public void openteladecalculos(){
        Intent intent = new Intent(this,telacalculos.class);
        startActivity(intent);
    }
    public void openteladeselecoes(){
        Intent intent = new Intent(this,teladeselecoes.class);
        startActivity(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_de_refeicoes_menu, menu); //menu.add("Remover");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_lista_alunos_menu_remover) {
            AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Conta contaEscolhida = adapter.getItem(menuInfo.position);
            remove(contaEscolhida);
        }
        openteladecontas();
        return super.onContextItemSelected(item);
    }

    public void openteladecontas(){
        Intent intent = new Intent(this,teladecontas.class);
        startActivity(intent);
    }

    private void remove(Conta conta) {
        dao.remove(conta);
        adapter.remove(conta);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaContas();
    }

    private void atualizaContas() {
        adapter.clear();
        adapter.addAll(dao.todos());
    }

    private void configuraListaContas() {
        ListView listaDeContas = findViewById(R.id.activity_lista_de_contas_listview); //usar listadapter para implementacoes mais complexas
        configuraAdapter(listaDeContas); //preciso ir adicionando aq no codigo
        configuraListenerDeClickPorItem(listaDeContas);
        registerForContextMenu(listaDeContas); //indica que a lista tem um registro de context menu
    }

    private void configuraAdapter(ListView listaDeRefeicoes) {

        adapter = new ListaContasAdapter(this);
        listaDeRefeicoes.setAdapter(adapter);
    }

    private void configuraListenerDeClickPorItem(ListView listaDeRefeicoes) {
        listaDeRefeicoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Conta contaEscolhida = (Conta) adapterView.getItemAtPosition(posicao);
                // Log.i("refeicao", "" + refeicaoEscolhida);
                abreFormularioModoEditaConta(contaEscolhida);
            }
        });
    }

    private void abreFormularioModoEditaConta(Conta conta) {
        //Intent vaiParaAlimentosRefeicaoActivity = new Intent(ActivityListadeContas.this, AlimentosRefeicaoActivity.class);
        Intent vaiParaAtributosContasActivity = new Intent(teladecontas.this, telacalculos.class);
        vaiParaAtributosContasActivity.putExtra(CHAVE_CONTA, conta);
        startActivity(vaiParaAtributosContasActivity);
    }



}
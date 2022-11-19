package com.example.Projeto_Eco;

import static com.example.Projeto_Eco.ConstanteActivity.CHAVE_CONTA;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Projeto_Eco.DAO.ContaDAO;
import com.example.Projeto_Eco.R;
import com.example.Projeto_Eco.Conta.Conta;
import com.example.Projeto_Eco.Adapter.ListaContasAdapter;

public class ActivityListadeContas extends AppCompatActivity{
    private final ContaDAO dao = new ContaDAO();
    private ListaContasAdapter adapter;

    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_teladecontas);  //colocando o arq estatico q criamos como view dessa activity
        //configuraFabNovaConta();
        configuraListaContas();
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
        return super.onContextItemSelected(item);
    }

    //private void configuraFabNovaConta() {
        //FloatingActionButton nova_conta = findViewById(R.id.nova_conta);
       // nova_conta.setOnClickListener(new View.OnClickListener() {
            //@Override
           // public void onClick(View view) {
               // openteladecalculos();
           // }
      //  });
    //}

    //Mudar para adicionar conta
    public void openteladecalculos(){
        Intent intent = new Intent(this,telacalculos.class);
        startActivity(intent);
    }
    private void abreFormularioModoInsereRefeicao() {
       // startActivity(new Intent(this, AlimentosRefeicaoActivity.class));
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
        ListView listaDeContas= findViewById(R.id.activity_lista_de_contas_listview); //usar listadapter para implementacoes mais complexas
        configuraAdapter(listaDeContas); //preciso ir adicionando aq no codigo
        configuraListenerDeClickPorItem(listaDeContas);
        registerForContextMenu(listaDeContas); //indica que a lista tem um registro de context menu
    }

    private void remove(Conta conta) {
        dao.remove(conta);
        adapter.remove(conta);
    }

    private void configuraListenerDeClickPorItem(ListView listaDeRefeicoes) {
        listaDeRefeicoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Conta contaEscolhida = (Conta) adapterView.getItemAtPosition(posicao);
                // Log.i("refeicao", "" + refeicaoEscolhida);
                abreFormularioModoEditaRefeicao(contaEscolhida);
            }
        });
    }

    private void abreFormularioModoEditaRefeicao(Conta conta) {
        //Intent vaiParaAlimentosRefeicaoActivity = new Intent(ActivityListadeContas.this, AlimentosRefeicaoActivity.class);
        Intent vaiParaAlimentosRefeicaoActivity = new Intent(ActivityListadeContas.this, telacalculos.class);
        vaiParaAlimentosRefeicaoActivity.putExtra(CHAVE_CONTA, conta);
        startActivity(vaiParaAlimentosRefeicaoActivity);
    }

    private void configuraAdapter(ListView listaDeContas) {

        adapter = new ListaContasAdapter(this);
        listaDeContas.setAdapter(adapter);
    }


}




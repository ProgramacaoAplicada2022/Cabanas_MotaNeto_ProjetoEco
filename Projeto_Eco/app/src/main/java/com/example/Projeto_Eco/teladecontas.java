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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Projeto_Eco.DAO.ContaDAO;
import com.example.Projeto_Eco.Conta.Conta;
import com.example.Projeto_Eco.Adapter.ListaContasAdapter;

public class teladecontas extends AppCompatActivity {
    private Button botaovoltar3;
    private final ContaDAO dao = new ContaDAO();
    private ListaContasAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_teladecontas);

        configuraListaContas();

        Button botaovoltar5 = findViewById(R.id.botaovoltar5);
        botaovoltar5.setOnClickListener(new View.OnClickListener() {
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
        getMenuInflater().inflate(R.menu.activity_lista_de_contas_menu, menu);
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
        TextView valordaConta = (TextView) findViewById(R.id.ValorTotal);
        valordaConta.setText(String.valueOf(adapter.ValorTotal()));
    }

    private void configuraListaContas() {
        ListView listaDeContas = findViewById(R.id.activity_lista_de_contas_listview);
        configuraAdapter(listaDeContas);
        configuraListenerDeClickPorItem(listaDeContas);
        registerForContextMenu(listaDeContas);
    }

    private void configuraAdapter(ListView listaDeContas) {

        adapter = new ListaContasAdapter(this);
        listaDeContas.setAdapter(adapter);
    }

    private void configuraListenerDeClickPorItem(ListView listaDeContas) {
        listaDeContas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Conta contaEscolhida = (Conta) adapterView.getItemAtPosition(posicao);
                abreFormularioModoEditaConta(contaEscolhida);
            }
        });
    }

    private void abreFormularioModoEditaConta(Conta conta) {
        Intent vaiParaAtributosContasActivity = new Intent(teladecontas.this, telacalculos.class);
        vaiParaAtributosContasActivity.putExtra(CHAVE_CONTA, conta);
        startActivity(vaiParaAtributosContasActivity);
    }

}
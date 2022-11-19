package com.example.Projeto_Eco.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.Projeto_Eco.R;
import com.example.Projeto_Eco.Conta.Conta;

import java.util.ArrayList;
import java.util.List;

public class ListaContasAdapter extends BaseAdapter {
    private final List<Conta> contas = new ArrayList<>();
    private Context context;

    public ListaContasAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return contas.size();
    }

    @Override
    public Conta getItem(int posicao) {
        return contas.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return contas.get(posicao).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_conta, viewGroup, false);
        Conta contaCriada = contas.get(i);

        TextView nome = viewCriada.findViewById(R.id.item_conta_nome);
        nome.setText(contaCriada.getNome());

        TextView potencia = viewCriada.findViewById(R.id.item_potencia);
        potencia.setText("Consumo Mensal: R$" +contaCriada.getPotencia());

        TextView horas_de_uso = viewCriada.findViewById(R.id.item_horas_de_uso);
        horas_de_uso.setText(contaCriada.getHoras_uso() + "horas de uso");

        TextView preco_kwh = viewCriada.findViewById(R.id.item_preco_kwh);
        preco_kwh.setText(contaCriada.getPreco_kWh());

        TextView consumo_mensal = viewCriada.findViewById(R.id.item_consumo_mensal);
        consumo_mensal.setText(contaCriada.getConsumo_mensal() + " W");

        TextView preco_consumo = viewCriada.findViewById(R.id.item_preco_consumo);
        preco_consumo.setText("R$ " + contaCriada.getPreco_consumo());
        return viewCriada;
    }

    public void clear() {
        contas.clear();
    }

    public void addAll(List<Conta> contas) {
        this.contas.addAll(contas);
    }

    public void remove(Conta conta) {contas.remove(conta);
    }
}

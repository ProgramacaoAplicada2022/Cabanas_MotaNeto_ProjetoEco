package com.example.Projeto_Eco.DAO;

import androidx.annotation.Nullable;
import com.example.Projeto_Eco.Conta.Conta;
import java.util.ArrayList;
import java.util.List;


public class ContaDAO {
    private final static List<Conta> contas = new ArrayList<>();
    private static int contadorDeids = 1;

    public void salva(Conta conta) {
        conta.setId(contadorDeids);
        contas.add(conta);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorDeids++;
    }

    public void edita(Conta conta) {
        Conta contaEncontrada = buscaContaPeloId(conta);
        if (contaEncontrada != null) {
            int posicaoDaConta = contas.indexOf(contaEncontrada);
            contas.set(posicaoDaConta, conta);
        }
    }

    @Nullable
    private Conta buscaContaPeloId(Conta conta) {
        for (Conta a :
                contas) {
            if (a.getId() == conta.getId()) {
                return a;
            }
        }
        return null;
    }

    public List<Conta> todos() {

        return new ArrayList<>(contas);
    }


    public void remove(Conta conta) {
        Conta contaDevolvida = buscaContaPeloId(conta);
        if(contaDevolvida != null){
            contas.remove(contaDevolvida);
        }
    }
}

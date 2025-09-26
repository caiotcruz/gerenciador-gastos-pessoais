package repository;

import model.Lancamento;
import util.JsonHelper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LancamentoRepository {
    private static final String ARQUIVO = "lancamentos.json";
    private List<Lancamento> lancamentos;

    public LancamentoRepository() {
        this.lancamentos = carregar();
    }

    // CRUD
    public void adicionar(Lancamento l) {
        lancamentos.add(l);
        salvar();
    }

    public void remover(String id) {
        lancamentos.removeIf(l -> l.getId().equals(id));
        salvar();
    }

    public void atualizar(Lancamento atualizado) {
        for (int i = 0; i < lancamentos.size(); i++) {
            if (lancamentos.get(i).getId().equals(atualizado.getId())) {
                lancamentos.set(i, atualizado);
                break;
            }
        }
        salvar();
    }

    public List<Lancamento> listar() {
        return lancamentos;
    }

    // Persistência
    private void salvar() {
        try {
            JsonHelper.salvarJson(ARQUIVO, lancamentos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Lancamento> carregar() {
        try {
            File f = new File(ARQUIVO);
            if (!f.exists()) return new ArrayList<>();
            Lancamento[] array = JsonHelper.carregarJson(ARQUIVO, Lancamento[].class);
            List<Lancamento> lista = new ArrayList<>();
            for (Lancamento l : array) lista.add(l);
            return lista;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}

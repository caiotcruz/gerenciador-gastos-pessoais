package controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML; // Importe o FXML
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Lancamento;
import repository.LancamentoRepository;
import util.DialogHelper;
import util.Validador;

public class LancamentoController {

    @FXML
    private TableView<Lancamento> tabelaLancamentos;

    @FXML private TableColumn<Lancamento, String> colData;
    @FXML private TableColumn<Lancamento, String> colCategoria;
    @FXML private TableColumn<Lancamento, String> colValor;
    @FXML private TableColumn<Lancamento, String> colDescricao;

    private LancamentoRepository repo;
    private ObservableList<Lancamento> dados;

    @FXML
    public void initialize() {
        this.repo = new LancamentoRepository();
        this.dados = FXCollections.observableArrayList();

        colData.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getData()));
        colCategoria.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getCategoria()));
        colValor.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
                String.format("%.2f", c.getValue().getValor()).replace(".", ",")
        ));
        colDescricao.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getDescricao()));

        tabelaLancamentos.setItems(dados);
        atualizarTabela();
    }

    @FXML
    private void adicionar() {

        String data = DialogHelper.showInput("Data (DD/MM/AAAA):", "");
        if (!Validador.validarData(data)) {
            DialogHelper.showError("Data inválida!");
            return;
        }

        String descricao = DialogHelper.showInput("Descrição (opcional):", "");
        String categoria = DialogHelper.showInput("Categoria:", "");
        double valor;
        try {
            valor = Validador.validarValor(DialogHelper.showInput("Valor (XX,XX ou XX.XX):", ""));
        } catch (NumberFormatException e) {
            DialogHelper.showError("Valor inválido!");
            return;
        }

        Lancamento l = new Lancamento(data, descricao, categoria, valor);
        repo.adicionar(l);
        atualizarTabela();
        DialogHelper.showInfo("Lançamento adicionado!");
    }

    @FXML
    private void editar() {
        Lancamento selecionado = tabelaLancamentos.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            DialogHelper.showError("Selecione um lançamento para editar!");
            return;
        }

        repo.atualizar(selecionado);
        atualizarTabela();
        DialogHelper.showInfo("Lançamento atualizado!");
    }

    @FXML
    private void remover() {
        Lancamento selecionado = tabelaLancamentos.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            DialogHelper.showError("Selecione um lançamento para remover!");
            return;
        }
        repo.remover(selecionado.getId());
        atualizarTabela();
        DialogHelper.showInfo("Lançamento removido!");
    }

    private void atualizarTabela() {
        dados.setAll(repo.listar());
    }
}
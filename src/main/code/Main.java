import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        // 1. Cria o FXMLLoader para carregar o arquivo FXML
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("LancamentoView.fxml")));
        
        // 2. Carrega o FXML. Isso cria a interface e o controller.
        Parent root = loader.load();

        // 3. Cria a cena com o conteúdo carregado do FXML
        Scene scene = new Scene(root);

        // 4. Configura e exibe a janela
        stage.setTitle("Gerenciador de Gastos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
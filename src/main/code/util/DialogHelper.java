package util;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class DialogHelper {

    public static String showInput(String header, String defaultValue) {
        TextInputDialog dialog = new TextInputDialog(defaultValue);
        dialog.setHeaderText(header);
        Optional<String> result = dialog.showAndWait();
        return result.orElse(defaultValue);
    }

    public static void showError(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR, mensagem);
        alert.showAndWait();
    }

    public static void showInfo(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensagem);
        alert.showAndWait();
    }
}
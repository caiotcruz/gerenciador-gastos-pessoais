package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonHelper {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> void salvarJson(String caminho, T objeto) throws IOException {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(objeto, writer);
        }
    }

    public static <T> T carregarJson(String caminho, Class<T> classe) throws IOException {
        try (FileReader reader = new FileReader(caminho)) {
            return gson.fromJson(reader, classe);
        }
    }
}
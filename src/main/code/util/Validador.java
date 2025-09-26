package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Validador {

    private static final DateTimeFormatter FORMATADOR = 
        DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

    public static boolean validarData(String data) {
        try {
            LocalDate.parse(data, FORMATADOR);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static double validarValor(String entrada) throws NumberFormatException {
        entrada = entrada.replace(",", ".");
        double valor = Double.parseDouble(entrada);

        if (valor < 0) throw new NumberFormatException("Valor negativo não é permitido");

        return valor;
    }

}
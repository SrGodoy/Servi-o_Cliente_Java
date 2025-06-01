package br.edu.fateclins.servico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class SenhaSeguraWS {

    // Método 1: Saudação com data/hora (sem parâmetros)
    @WebMethod
    public String saudacao() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHora = agora.format(formatter);

        int hora = agora.getHour();
        if (hora >= 6 && hora < 12) {
            return "Bom dia! Agora são " + dataHora;
        } else if (hora >= 12 && hora < 18) {
            return "Boa tarde! Agora são " + dataHora;
        } else {
            return "Boa noite! Agora são " + dataHora;
        }
    }

    // Método 2: Gerar senha segura (com parâmetros)
    @WebMethod
    public String gerarSenhaSegura(int tamanho, boolean usarNumeros, boolean usarEspeciais) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        if (usarNumeros) caracteres += "0123456789";
        if (usarEspeciais) caracteres += "!@#$%^&*()_+-=[]{}|;:,.<>?";

        Random random = new Random();
        StringBuilder senha = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            senha.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return senha.toString();
    }
}
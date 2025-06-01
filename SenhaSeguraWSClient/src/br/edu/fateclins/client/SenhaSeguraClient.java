package br.edu.fateclins.client;

import java.rmi.RemoteException;
import java.util.Random;
import br.edu.fateclins.servico.SenhaSeguraWSProxy;

public class SenhaSeguraClient {
    public static void main(String[] args) {
        try {
            SenhaSeguraWSProxy proxy = new SenhaSeguraWSProxy();
            
            // Validação dos argumentos (mantido igual)
            if (args.length != 3) {
                System.err.println("Uso: java SenhaSeguraClient <tamanho> <usarNumeros> <usarEspeciais>");
                System.err.println("Exemplo: java SenhaSeguraClient 8 true true");
                return;
            }

            int tamanho = Integer.parseInt(args[0]);
            boolean usarNumeros = Boolean.parseBoolean(args[1]);
            boolean usarEspeciais = Boolean.parseBoolean(args[2]);

            // Tenta chamada SOAP (parte original)
            System.out.println("=== SAUDAÇÃO ===");
            System.out.println(proxy.saudacao());
            
            System.out.println("\n=== SENHA GERADA ===");
            String senha = proxy.gerarSenhaSegura(tamanho, usarNumeros, usarEspeciais);
            System.out.println("Senha: " + senha);

        } catch (Exception e) { // Captura todos os erros
            // Geração local apenas se a SOAP falhar (nova parte)
            int tamanho = args.length > 0 ? Integer.parseInt(args[0]) : 8;
            boolean usarNumeros = args.length > 1 ? Boolean.parseBoolean(args[1]) : true;
            boolean usarEspeciais = args.length > 2 ? Boolean.parseBoolean(args[2]) : true;
            
            String senhaLocal = gerarSenhaLocal(tamanho, usarNumeros, usarEspeciais);
            System.out.println("Senha : " + senhaLocal);
        }
    }

    // Método auxiliar novo (adicionado no final da classe)
    private static String gerarSenhaLocal(int tamanho, boolean numeros, boolean especiais) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        if (numeros) chars += "0123456789";
        if (especiais) chars += "!@#$%&*";
        
        Random rand = new Random();
        StringBuilder senha = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            senha.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return senha.toString();
    }
}
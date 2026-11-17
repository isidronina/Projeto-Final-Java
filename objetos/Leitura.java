import java.util.Scanner;

public class Leitura {
    public static int lerInteiro(Scanner entrada, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String valor = entrada.nextLine().trim();
            try {
                return Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    public static int lerIsbn(Scanner entrada, String mensagem) {
        while (true) {
            int isbn = lerInteiro(entrada, mensagem);
            if (isbn > 0) {
                return isbn;
            }
            System.out.println("O ISBN deve ser um número positivo.");
        }
    }

    public static String lerTextoObrigatorio(Scanner entrada, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String valor = entrada.nextLine();
            if (!valor.trim().isEmpty()) {
                return valor;
            }
            System.out.println("Este campo não pode ficar vazio.");
        }
    }
}

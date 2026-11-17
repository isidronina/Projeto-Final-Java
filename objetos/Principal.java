import java.util.Scanner;
import modelo.Array;
import modelo.Livro;

public class Principal {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Array livro = new Array();

        // Cadastro manual dos livros
        livro.inserir(new Livro("Dom Casmurro", "Machado de Assis", "1899", 18991));
        livro.inserir(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "1943", 19432));
        livro.inserir(new Livro("O Senhor dos Rings", "J.R.R. Tolkien", "1954", 19543));
        livro.inserir(new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "1997", 19974));
        livro.inserir(new Livro("1984", "George Orwell", "1949", 19495));
        livro.inserir(new Livro("O Hobbit", "J.R.R. Tolkien", "1937", 19376));
        livro.inserir(new Livro("O Alquimista", "Paulo Coelho", "1988", 19887));
        livro.inserir(new Livro("A Revolução dos Bichos", "George Orwell", "1945", 19458));
        livro.inserir(new Livro("Cem Anos de Solidão", "Gabriel García Márquez", "1967", 19679));
        livro.inserir(new Livro("O Código Da Vinci", "Dan Brown", "2003", 20030));
        livro.inserir(new Livro("Orgulho e Preconceito", "Jane Austen", "1813", 18131));
        int opcao;

        do {
            System.out.println("\n===== MENU DE LIVROS =====");
            System.out.println("1 - Pesquisar livro por ISBN");
            System.out.println("2 - Atualizar livro por ISBN");
            System.out.println("3 - Remover livro por ISBN");
            System.out.println("4 - Exibir livros");
            System.out.println("5 - Inserir livro");
            System.out.println("0 - Sair");

            opcao = Leitura.lerInteiro(entrada, "Escolha uma opção: ");

            switch (opcao) {

                case 1:
                    int isbnPesquisa = Leitura.lerIsbn(entrada, "Digite o ISBN do livro: ");

                    Livro encontrado = livro.pesquisarIsbn(isbnPesquisa);

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                    break;

                case 2:
                    int isbnAtualizar = Leitura.lerIsbn(entrada, "Digite o ISBN do livro: ");

                    if (livro.pesquisarIsbn(isbnAtualizar) != null) {
                        String autor = Leitura.lerTextoObrigatorio(entrada, "Digite o novo autor: ");
                        String ano = Leitura.lerTextoObrigatorio(entrada, "Digite o novo ano: ");
                        String titulo = Leitura.lerTextoObrigatorio(entrada, "Digite o novo título: ");
                        int novoIsbn = Leitura.lerIsbn(entrada, "Digite o novo ISBN: ");

                        if (livro.atualizarPorIsbn(isbnAtualizar, titulo, autor, ano, novoIsbn)) {
                            System.out.println("Livro atualizado!");
                        } else {
                            System.out.println("Não foi possível atualizar: o novo ISBN já está cadastrado.");
                        }
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                    break;

                case 3:
                    int isbnRemover = Leitura.lerIsbn(entrada, "Digite o ISBN do livro: ");

                    if (livro.removerPorIsbn(isbnRemover)) {
                        System.out.println("Livro removido!");
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                    break;

                case 4:
                    Array livroCopia = new Array();
                    for (int i = 0; i < livro.getControle(); i++) {
                        livroCopia.inserir(livro.getLista()[i]);
                    }

                    Array.mergeSortTitulo(0, livroCopia.getControle(), livroCopia.getLista());

                    System.out.println("Livros ordenados por título!");
                    livroCopia.exibir();
                    break;

                case 5:
                    String titulo = Leitura.lerTextoObrigatorio(entrada, "Digite o título do livro: ");
                    String autor = Leitura.lerTextoObrigatorio(entrada, "Digite o autor do livro: ");
                    String ano = Leitura.lerTextoObrigatorio(entrada, "Digite o ano do livro: ");
                    int isbn = Leitura.lerIsbn(entrada, "Digite o ISBN do livro: ");

                    if (livro.inserir(new Livro(titulo, autor, ano, isbn))) {
                        System.out.println("Livro inserido!");
                    } else {
                        System.out.println("Não foi possível inserir: o ISBN já está cadastrado.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 0);

        entrada.close();
    }
}

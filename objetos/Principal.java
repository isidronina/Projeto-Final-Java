import java.util.Scanner;
import modelo.Array;
import modelo.Produto;

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
            System.out.println("4 - Ordenar livros por ISBN");
            System.out.println("5 - Exibir livros");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("Digite o ISBN do livro: ");
                    int isbnPesquisa = entrada.nextInt();

                    Livro encontrado = livro.pesquisarIsbn(isbnPesquisa);

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                    break;

                case 2:
                    System.out.print("Digite o ISBN do livro: ");
                    int isbnAtualizar = entrada.nextInt();

                    if (livro.pesquisarIsbn(isbnAtualizar) != null) {

                        entrada.nextLine();

                        System.out.print("Digite o novo autor: ");
                        String autor = entrada.nextLine();

                        System.out.print("Digite o novo ano: ");
                        String ano = entrada.nextLine();

                        livro.atualizarPorIsbn(isbnAtualizar, autor, ano);
                        System.out.println("Livro atualizado!");

                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID do livro: ");
                    int idRemover = entrada.nextInt();

                    if (livro.pesquisarId(idRemover) != null) {
                        livro.removerPorId(idRemover);
                        System.out.println("Livro removido!");
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                    break;

                case 4:
                    livro.mergeSort(0, livro.getControle(), livro.getLista());

                    System.out.println("Livros ordenados por ISBN!");
                    livro.exibir();
                    break;

                case 5:
                    livro.exibir();
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

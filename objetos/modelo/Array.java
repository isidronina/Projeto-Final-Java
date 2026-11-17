package modelo;
public class Array {
    private Livro[] lista= new Livro[10];
    private int controle=0; // Controla a quantidade do Array

    public boolean inserir(Livro livro){
        if (livro == null || buscaBinariaRecursiva(livro.getIsbn()) != -1) {
            return false;
        }
        if (controle==lista.length) { 
            lista=alocarNovoArray();
        }
        lista[controle++]=livro;
        mergeSort(0, controle, lista);
        return true;
    }

    private Livro[] alocarNovoArray(){
        Livro [] novo = new Livro[lista.length + lista.length / 2];
        System.arraycopy(lista, 0, novo, 0, lista.length);
        return novo; 
    }

    public int buscaBinariaRecursiva(int isbn) {

        return buscaBinaria(isbn, 0, controle - 1);
    }

    private int buscaBinaria(int isbn, int inicio, int fim) {

        if (inicio > fim) {
            return -1;
        }

        int meio = (inicio + fim) / 2;

        if (lista[meio].getIsbn() == isbn) {
            return meio;
        }

        if (isbn < lista[meio].getIsbn()) {

            return buscaBinaria(isbn, inicio, meio - 1);

        } else {

            return buscaBinaria(isbn, meio + 1, fim);
        }
    }

    public void exibir(){
        for(int i=0;i<controle;i++){
            System.out.println(lista[i].toString()); // o toString ja definido faz essa modificação automaticamente, mas para uso para estudo pode colocar .toString
            System.out.println(".________________________________________________.");
        }
    }

    public Livro pesquisarIsbn(int isbn) {
        int posicao = buscaBinariaRecursiva(isbn);

        if (posicao != -1) {
            return lista[posicao];
        }

        return null;
    }

    public boolean atualizarPorIsbn(int isbn, String titulo, String autor, String ano, int novoIsbn) {
        int posicao = buscaBinariaRecursiva(isbn);
        if (posicao == -1) {
            return false;
        }

        int posicaoNovoIsbn = buscaBinariaRecursiva(novoIsbn);
        if (posicaoNovoIsbn != -1 && posicaoNovoIsbn != posicao) {
            return false;
        }

        lista[posicao].setTitulo(titulo);
        lista[posicao].setAutor(autor);
        lista[posicao].setAno(ano);
        lista[posicao].setIsbn(novoIsbn);
        mergeSort(0, controle, lista);
        return true;
    }

    public boolean removerPorIsbn(int isbn) {
        int posicao = buscaBinariaRecursiva(isbn);
        if (posicao == -1) {
            return false;
        }

        for (int i = posicao; i < controle - 1; i++) {
            lista[i] = lista[i + 1];
        }
        lista[--controle] = null;
        return true;
    }

    public static void mergeSort(int inicio, int tamanho, Livro[] v) {
        if (inicio < tamanho - 1) {
            int meio = (inicio + tamanho) / 2;
            mergeSort(inicio, meio, v);
            mergeSort(meio, tamanho, v);
            intercalar(inicio, meio, tamanho, v);
        }
    }

    private static void intercalar(int inicio, int meio, int tamanho, Livro[] v) {
        int i, j, k;
        Livro[] auxiliar = new Livro[tamanho - inicio];
        i = inicio;
        j = meio;
        k = 0;

        while (i < meio && j < tamanho) {
            if (v[i].getIsbn() <= v[j].getIsbn()) {
                auxiliar[k++] = v[i++];
            } else {
                auxiliar[k++] = v[j++];
            }
        }

        while (i < meio) {
            auxiliar[k++] = v[i++];
        }

        while (j < tamanho) {
            auxiliar[k++] = v[j++];
        }

        for (i = inicio; i < tamanho; i++) {
            v[i] = auxiliar[i - inicio];
        }
    }

    public static void mergeSortTitulo(int inicio, int tamanho, Livro[] v) {
        if (inicio < tamanho - 1) {
            int meio = (inicio + tamanho) / 2;
            mergeSortTitulo(inicio, meio, v);
            mergeSortTitulo(meio, tamanho, v);
            intercalarTitulo(inicio, meio, tamanho, v);
        }
    }

    private static void intercalarTitulo(int inicio, int meio, int tamanho, Livro[] v) {
        int i = inicio;
        int j = meio;
        int k = 0;
        Livro[] auxiliar = new Livro[tamanho - inicio];

        while (i < meio && j < tamanho) {
            if (v[i].getTitulo().compareToIgnoreCase(v[j].getTitulo()) <= 0) {
                auxiliar[k++] = v[i++];
            } else {
                auxiliar[k++] = v[j++];
            }
        }

        while (i < meio) {
            auxiliar[k++] = v[i++];
        }

        while (j < tamanho) {
            auxiliar[k++] = v[j++];
        }

        for (i = inicio; i < tamanho; i++) {
            v[i] = auxiliar[i - inicio];
        }
    }

    public int getControle() {
        return controle;
    }

    public Livro[] getLista() {
    return lista;
    }
}

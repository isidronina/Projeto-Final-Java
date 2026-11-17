package modelo;
public class Array {
    private Livro[] lista= new Livro[10];
    private int controle=0; // Controla a quantidade do Array

    public void inserir(Livro livro){ 
        if (controle==lista.length) { 
            lista=alocarNovoArray();
        }
        lista[controle++]=livro;
    }

    private Livro[] alocarNovoArray(){
        Livro [] novo = new Livro[lista.length + lista.length / 2];
        System.arraycopy(lista, 0, novo, 0, lista.length);
        return novo; 
    }

    public void exibir(){
        for(int i=0;i<controle;i++){
            System.out.println(lista[i].toString()); // o toString ja definido faz essa modificação automaticamente, mas para uso para estudo pode colocar .toString
            System.out.println(".________________________________________________.");
        }
    }

    public Livro pesquisarIsbn(int isbn){
        for(int i=0; i < controle; i++){
            if(isbn == lista[i].getIsbn()){
                return lista[i];
            }
        }
        return null;
    }

    public void atualizarPorIsbn(int isbn, String titulo, String autor, String ano){
        for(int i=0; i < controle; i++){
            if(isbn == lista[i].getIsbn()){
                lista[i].setTitulo(titulo);
                lista[i].setAutor(autor);
                lista[i].setAno(ano);
                lista[i].setIsbn(isbn);
            }
        }
    }

    public void removerPorIsbn(int isbn){
        for(int i=0; i <controle; i++){
            if(isbn == lista[i].getIsbn()){
                for(int j=i;j<controle-1;j++){
                    lista[j]=lista[j+1];
                }
                controle--;
                lista[controle]=null;
                return ;
            }
        }
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

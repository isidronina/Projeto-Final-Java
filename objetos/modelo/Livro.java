package modelo;

public class Livro{
    private String titulo, autor, ano;
    private int isbn;

        public Livro(String titulo, String autor, String ano, int isbn){
            this.titulo=titulo;
            this.autor=autor;
            this.ano=ano;
            this.isbn=isbn;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public String getAno() {
            return ano;
        }

        public int getIsbn() {
            return isbn;
        }


        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public void setAno(String ano) {
            this.ano = ano;
        }

        public void setIsbn(int isbn) {
            this.isbn = isbn;
        }

        @Override //é uma marcação
        public String toString(){ //o toString sobrepoe o objeto
            return "Título: " +titulo+ " Autor: " +autor+ " Ano: " +ano+ " ISBN: " +isbn;
        }
}
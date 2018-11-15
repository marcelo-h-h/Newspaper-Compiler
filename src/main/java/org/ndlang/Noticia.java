package org.ndlang;

class Noticia {
    private String titulo;
    private String descricao;
    private String imagePath;

    public Noticia(String titulo, String descricao, String imagePath) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagePath = imagePath;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getImagePath(){
        return this.imagePath;
    }
}
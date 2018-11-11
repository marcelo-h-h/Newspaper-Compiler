package org.ndlang;

class Noticia {
    private String titulo;
    private String descricao;

    public Noticia(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
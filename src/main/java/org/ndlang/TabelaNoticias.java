package org.ndlang;

import java.util.Hashtable;

class TabelaNoticias {
    private Hashtable<String, Noticia> noticias;

    public TabelaNoticias() {
        this.noticias = new Hashtable<String, Noticia>();
    }

    public boolean adicionarNoticia(String id, Noticia noticia) {
        return (this.noticias.put(id, noticia) == null);
    }

    public Noticia getNoticia(String id) {
        return this.noticias.get(id);
    }
}
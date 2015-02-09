package br.com.aprender.livraria.controller;

import java.util.List;
import javax.inject.Inject;
import br.com.aprender.livraria.interfaces.Estante;
import br.com.aprender.livraria.interfaces.LivroDAO;
import br.com.aprender.livraria.modelo.Livro;

public class EstanteNoBancoDeDados implements Estante {

    private final LivroDAO dao;

    @Inject
    public EstanteNoBancoDeDados(LivroDAO dao) {
        this.dao = dao;
    }

    public EstanteNoBancoDeDados() {
        this(null);
    }

    @Override
    public void guarda(Livro livro) {
        this.dao.adiciona(livro);

    }

    @Override
    public List<Livro> todosOsLivros() {
        return this.dao.todos();
    }

    @Override
    public Livro buscaPorIsbn(String isbn) {
        return this.dao.buscaPorIsbn(isbn);
    }

    @Override
    public Livro deleta(Livro livro) {
        return this.dao.deleta(livro);
    }
}

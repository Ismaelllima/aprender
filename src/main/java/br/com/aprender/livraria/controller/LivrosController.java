package br.com.aprender.livraria.controller;

import java.util.List;

import javax.inject.Inject;
import br.com.aprender.livraria.interfaces.Estante;
import br.com.aprender.livraria.modelo.Livro;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LivrosController {

    private Estante estante;    
    private Result result;   
    private Validator validator;
    
    @Inject
    public LivrosController(Estante estante, Result result, Validator validator) {		
		this.estante = estante;
		this.result = result;
		this.validator = validator;
	}

	LivrosController() {
    }

    public void ver() {

    }
          
    @Get("livros/adicionar")
    public void formulario() {

    }

    public void deletar() {

    }

    public void salva(Livro livro, UploadedFile capa) {
        validator.validate(livro);
        validator.onErrorRedirectTo(this).formulario();
        estante.guarda(livro);
        result.include("mensagem", "Livro cadastrado com sucesso!");
        result.redirectTo(this).lista();
    }

    @Get
    @Path("/livros")
    public void lista() {
        result.include("livroList", estante.todosOsLivros());
    }

    @Get("/livros/{isbn}/editar")
    public void edita(String isbn) {

        Livro livroEncontrado = estante.buscaPorIsbn(isbn);
        if (livroEncontrado != null) {
            result.include(livroEncontrado);

            result.of(this).formulario();
        } else {
            result.notFound();
        }
    }

    @Get("/livros/{isbn}/excluir")
    public void confirmaExclusao(String isbn) {
        Livro verLivro = estante.buscaPorIsbn(isbn);
        if (verLivro == null) {
            result.notFound();
        }        
        result.include(verLivro);
        result.of(this).deletar();

    }
    @Get("livros/{isbn}/remove")
    public void remove(String isbn) {
        estante.deleta(estante.buscaPorIsbn(isbn));
        result.redirectTo(this).lista();
    }

    @Get("livros/detalhes/{isbn}")
    public void detalhes(String isbn) {
        Livro verLivro = estante.buscaPorIsbn(isbn);

        if (verLivro == null) {
            result.notFound();
        }

        result.include(verLivro);

        result.of(this).ver();
    }

}

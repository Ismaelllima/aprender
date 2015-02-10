package br.com.aprender.livraria.controller;

import br.com.aprender.livraria.interfaces.Diretorio;
import javax.inject.Inject;
import br.com.aprender.livraria.interfaces.Estante;
import br.com.aprender.livraria.modelo.Arquivo;
import br.com.aprender.livraria.modelo.Livro;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.download.ByteArrayDownload;
import br.com.caelum.vraptor.observer.download.Download;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.Validator;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.net.URI;
import java.util.Calendar;
import javax.validation.Valid;

@Controller
public class LivrosController {

    private Estante estante;
    private Result result;
    private Validator validator;
    private Diretorio imagens;

    @Inject
    public LivrosController(Estante estante, Diretorio imagens, Result result, Validator validator) {
        this.estante = estante;
        this.imagens = imagens;
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

    @Post("/livros")
    public void salva(@Valid Livro livro, UploadedFile capa) throws IOException {
        validator.onErrorRedirectTo(this).formulario();

        if (capa != null) {
            URI imagemCapa = imagens.grava(new Arquivo(capa.getFileName(), ByteStreams.toByteArray(capa.getFile()), capa.getContentType(), Calendar.getInstance()));

            livro.setCapa(imagemCapa);
        }
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

    @Get("livros/{isbn}/detalhes")
    public void detalhes(String isbn) {
        Livro verLivro = estante.buscaPorIsbn(isbn);

        if (verLivro == null) {
            result.notFound();
        }

        result.include(verLivro);

        result.of(this).ver();
    }

    @Get("livros/{isbn}/capa")
    public Download capa(String isbn) {
        Livro livro = estante.buscaPorIsbn(isbn);
        
        Arquivo capa = imagens.recupera(livro.getCapa());
        
        if(capa == null){
            result.notFound();
            return null;
        }
        
        return new ArquivoDownload(capa);
    }

}
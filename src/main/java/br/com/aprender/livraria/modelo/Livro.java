package br.com.aprender.livraria.modelo;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Livro {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "O campo Titulo não pode ser nulo!!!")
    private String titulo;

    @NotEmpty(message = "O campo Capa não pode ser vazio!")
    private String capa;

    @Column(length = 5000)
    @NotEmpty(message = " O campo Descrição não pode ser vazio!!!")
    private String descricao;

    @NotEmpty(message = " O campo ISBN não pode ser vazio!!!")
    @Column(unique = true)
    private String isbn;

    @NotNull(message = " O campo Preço não pode ser nulo!!!")
    @DecimalMin("0.0")
    private BigDecimal preco;

    @NotNull(message = " O campo é Obrigatorio!")
    @Past(message = " A data não pode ser futura!")
    @Temporal(TemporalType.DATE)
    private Date dataPublicacao;

    public String getTitulo() {
        return titulo;
    }

    public URI getCapa() {

        if (capa == null) return null;
        
        return URI.create(capa);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCapa(URI capa) {
        this.capa = capa == null ? null : capa.toString();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

}
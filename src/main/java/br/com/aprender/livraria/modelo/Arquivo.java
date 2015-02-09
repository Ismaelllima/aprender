/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprender.livraria.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author UNASUS9
 */
@Entity
public class Arquivo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @Lob
    private byte[] conteudo;
    private String ContentType;    
   
    private Calendar datamodificacao;

    Arquivo() {
    }

    public Arquivo(String nome, byte[] conteudo, String ContentType, Calendar datamodificacao) {
        this.nome = nome;
        this.conteudo = conteudo;
        this.ContentType = ContentType;
        this.datamodificacao = datamodificacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String ContentType) {
        this.ContentType = ContentType;
    }

    public Calendar getDatamodificacao() {
        return datamodificacao;
    }

    public void setDatamodificacao(Calendar datamodificacao) {
        this.datamodificacao = datamodificacao;
    }

}

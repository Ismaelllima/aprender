/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprender.livraria.modelo;

import java.util.Calendar;

/**
 *
 * @author UNASUS9
 */
public class Arquivo {
    private String nome;
    private byte[] conteudo;
    private String ContentType;
    private Calendar datamodificacao;

    public Arquivo(String nome, byte[] conteudo, String ContentType, Calendar datamodificacao) {
        this.nome = nome;
        this.conteudo = conteudo;
        this.ContentType = ContentType;
        this.datamodificacao = datamodificacao;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprender.livraria.interfaces;

import br.com.aprender.livraria.modelo.Arquivo;
import java.net.URI;

/**
 *
 * @author UNASUS9
 */
public interface Diretorio {
    URI grava(Arquivo arquivo);
    
    Arquivo recupera(URI chave);
    
}

package br.com.aprender.livraria.interfaces;

import br.com.aprender.livraria.modelo.Arquivo;
import java.net.URI;

public interface Diretorio {
    
    URI grava(Arquivo arquivo);
    
    Arquivo recupera(URI chave);
    
}
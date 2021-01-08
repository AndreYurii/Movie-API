package com.produtos.apirest.service;

import com.produtos.apirest.model.Filme;
import com.produtos.apirest.model.Genero;

public interface FilmeService extends GenericService<Class, Long>{

    Filme buscaPorGenero(String genero);
}

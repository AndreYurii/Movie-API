package com.produtos.apirest.service.impl;

import com.produtos.apirest.model.Filme;
import com.produtos.apirest.model.Genero;
import com.produtos.apirest.repository.FilmeRepository;
import com.produtos.apirest.repository.GeneroRepository;
import com.produtos.apirest.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeServiceImpl extends GenericServiceImpl<Filme, Long>  implements GenericService<Filme, Long> {

    @Autowired
    FilmeRepository repository;

    public List<Filme> buscaPorGenero(String name){
        return repository.findByGenero_Name(name);
    }
}

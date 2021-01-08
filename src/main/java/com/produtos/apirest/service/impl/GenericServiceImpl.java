package com.produtos.apirest.service.impl;

import com.produtos.apirest.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public abstract class GenericServiceImpl<T, K> implements GenericService<T, K> {

    @Autowired
    private CrudRepository<T, K> repository;

    @Override
    public List<T> buscarTodos() {
        return (List<T>) repository.findAll();
    }

    @Override
    public T buscaPorId(K id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public T salvar(T entity) {
        return repository.save(entity);
    }

    @Override
    public void deletar(K id) {
        repository.deleteById(id);
    }

    @Override
    public T atualizar(T entity, K id) {
        return repository.save(entity);
    }
}

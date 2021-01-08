package com.produtos.apirest.service;

import java.util.List;

public interface GenericService<T, Key> {

        List<T> buscarTodos();
        T buscaPorId(Key id);
        T salvar(T entity);
        void deletar(Key id);
        T atualizar(T entity, Key id);
}

package com.produtos.apirest.repository;

import com.produtos.apirest.model.Conta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Long> {
}

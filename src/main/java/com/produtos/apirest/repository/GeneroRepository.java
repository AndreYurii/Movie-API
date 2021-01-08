package com.produtos.apirest.repository;

import com.produtos.apirest.model.Filme;
import com.produtos.apirest.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Filme findByName(String name);
}

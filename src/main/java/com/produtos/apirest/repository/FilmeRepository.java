package com.produtos.apirest.repository;

import com.produtos.apirest.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findByGenero_Name(String name);
}

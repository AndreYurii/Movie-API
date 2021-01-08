package com.produtos.apirest.controller;

import com.produtos.apirest.model.Filme;
import com.produtos.apirest.model.Genero;
import com.produtos.apirest.service.FilmeService;
import com.produtos.apirest.service.GenericService;
import com.produtos.apirest.service.impl.FilmeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/filme")
public class FilmeController extends GenericRestController<Filme, Long> {

    public FilmeController(GenericService<Filme, Long> service) {
        super(service);
    }

    @Autowired
    FilmeServiceImpl service;

    @GetMapping("/genero")
    public ResponseEntity<?>buscaPorGenero(@RequestParam String name) {
        List<Filme> filmes = service.buscaPorGenero(name);
        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }
}

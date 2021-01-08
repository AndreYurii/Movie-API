package com.produtos.apirest.controller;

import com.produtos.apirest.service.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

public abstract class GenericRestController<T, ID> {

    private GenericService<T, ID> service;

    public GenericRestController(GenericService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> buscarTodos() {
        return new ResponseEntity<>(this.service.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<T> buscaPorId(@PathVariable(name = "id") ID id) {
        T entity = this.service.buscaPorId(id);
        return  isNull(entity) ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<T> salvar(@Validated @RequestBody T entity, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<>(this.service.salvar(entity), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> remove(@PathVariable(name = "id") ID id) {
        T entity = this.service.buscaPorId(id);

        if (isNull(entity)) {
            return ResponseEntity.notFound().build();
        }

        this.service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@RequestBody T entity, @PathVariable(name = "id") ID id) {
        T entitybd = this.service.buscaPorId(id);

        if (isNull(entitybd)) {
            return ResponseEntity.notFound().build();
        }

        this.service.salvar(entity);
        return new ResponseEntity<>(this.service.salvar(entity), HttpStatus.CREATED);
    }
}

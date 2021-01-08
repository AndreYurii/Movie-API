package com.produtos.apirest.controller;

import com.produtos.apirest.model.Conta;
import com.produtos.apirest.service.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conta")
public class ContaController extends GenericRestController<Conta, Long> {

    public ContaController(GenericService<Conta, Long> service) {
        super(service);
    }

    @GetMapping(path = "/teste")
    public ResponseEntity<?> teste(){
        String teste = "testando";
        return new ResponseEntity<>(teste, HttpStatus.OK);
    }
}

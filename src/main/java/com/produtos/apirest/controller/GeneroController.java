package com.produtos.apirest.controller;

import com.produtos.apirest.model.Genero;
import com.produtos.apirest.service.GenericService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/genero")
public class GeneroController extends GenericRestController<Genero, Long>{

    public GeneroController(GenericService<Genero, Long> service) {
        super(service);
    }
}

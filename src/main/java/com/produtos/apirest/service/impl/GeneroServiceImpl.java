package com.produtos.apirest.service.impl;

import com.produtos.apirest.model.Genero;
import com.produtos.apirest.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl extends GenericServiceImpl<Genero, Long> implements GenericService<Genero, Long> {
}

package com.produtos.apirest.service.impl;

import com.produtos.apirest.model.Conta;
import com.produtos.apirest.repository.ContaRepository;
import com.produtos.apirest.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl extends GenericServiceImpl<Conta, Long> implements GenericService<Conta, Long> {

}

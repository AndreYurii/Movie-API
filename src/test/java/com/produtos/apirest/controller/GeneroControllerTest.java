package com.produtos.apirest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.produtos.apirest.model.Filme;
import com.produtos.apirest.model.Genero;
import com.produtos.apirest.repository.FilmeRepository;
import com.produtos.apirest.repository.GeneroRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URI;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class GeneroControllerTest {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @MockBean
    private GeneroRepository repository;

    @Autowired
    private GeneroController controller;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void DeveSalvarUmNovoGenero() throws Exception{
        Genero genero = criaGenero();

        URI uri = new URI("/genero");

        Mockito.when(repository.save(null)).thenReturn(genero);

        MockHttpServletRequestBuilder requestBuilder = post(uri)
                .content(objectMapper.writeValueAsString(genero))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is(201));
    }

    @Test
    public void deveBuscarUmGenero() throws Exception {
        Genero genero = criaGenero();

        URI uri = new URI("/genero");

        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(genero));

        MockHttpServletRequestBuilder requestBuilder = get(uri)
                .content(objectMapper.writeValueAsString(genero))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is(200));
    }

    @Test
    public void deveAtualizarUmGenero() throws Exception{
        Genero genero = criaGenero();

        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(genero));
        Mockito.when(repository.save(any(Genero.class))).thenReturn(genero);

        MockHttpServletRequestBuilder requestBuilder = put("/genero/{id}",1)
                .content(objectMapper.writeValueAsString(genero))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is(201));
    }

    @Test
    public void deveDeletarUmGenero() throws Exception{
        Genero genero = criaGenero();

        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(genero));

        MockHttpServletRequestBuilder requestBuilder = delete("/genero/{id}",1)
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().is(204));
    }

    private Genero criaGenero(){
        Genero genero = new Genero();
        genero.setId(1L);
        genero.setName("Action");
        return genero;
    }
}

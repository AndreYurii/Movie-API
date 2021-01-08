package com.produtos.apirest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.produtos.apirest.model.Filme;
import com.produtos.apirest.model.Genero;
import com.produtos.apirest.repository.FilmeRepository;
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
public class FilmeControllerTest {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @MockBean
    private FilmeRepository repository;

    @Autowired
    private FilmeController controller;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void DeveSalvarUmNovoFilme() throws Exception{
        Filme filme = criaFilme();

        URI uri = new URI("/filme");

        Mockito.when(repository.save(null)).thenReturn(filme);

        MockHttpServletRequestBuilder requestBuilder = post(uri)
                .content(objectMapper.writeValueAsString(filme))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is(201));
    }

    @Test
    public void deveBuscarUmFilme() throws Exception {
        Filme filme = criaFilme();

        URI uri = new URI("/filme");

        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(filme));

        MockHttpServletRequestBuilder requestBuilder = get(uri)
                .content(objectMapper.writeValueAsString(filme))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is(200));
    }

    @Test
    public void deveAtualizarUmFilme() throws Exception{
        Filme filme = criaFilme();

        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(filme));
        Mockito.when(repository.save(any(Filme.class))).thenReturn(filme);

        MockHttpServletRequestBuilder requestBuilder = put("/filme/{id}",1)
                .content(objectMapper.writeValueAsString(filme))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is(201));
    }

    @Test
    public void deveDeletarUmFilme() throws Exception{
        Filme filme = criaFilme();

        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(filme));

        MockHttpServletRequestBuilder requestBuilder = delete("/filme/{id}",1)
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().is(204));
    }

    private Filme criaFilme(){
        Filme filme = new Filme();
        filme.setId(1L);
        filme.setAdult(true);
        filme.setBackdrop_path("planoDeFundo.jpeg");
        filme.setGenero(new Genero());
        filme.setOriginal_language("en");
        filme.setOriginal_title("Donnie Darko");
        filme.setPopularity("0.8");
        filme.setRelease_date("1999-10-12");
        filme.setRevenue(10000000);
        filme.setRuntime(139);
        filme.setOverview("A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression...");
        filme.setTagline("How much can you know about yourself if you've never been in a fight?");
        return filme;
    }



}

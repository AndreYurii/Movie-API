package com.produtos.apirest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.produtos.apirest.model.Conta;
import com.produtos.apirest.repository.ContaRepository;
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
public class ContaControllerTest {
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @MockBean
    private ContaRepository repository;

    @Autowired
    private ContaController controller;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void DeveSalvarUmaNovaConta() throws Exception{
        Conta conta = criaConta();

        URI uri = new URI("/conta");

        Mockito.when(repository.save(null)).thenReturn(conta);

        MockHttpServletRequestBuilder requestBuilder = post(uri)
                .content(objectMapper.writeValueAsString(conta))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is(201));
    }

    @Test
    public void deveBuscarUmaConta() throws Exception {
        Conta conta = criaConta();

        URI uri = new URI("/conta");

        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(conta));

        MockHttpServletRequestBuilder requestBuilder = get(uri)
                .content(objectMapper.writeValueAsString(conta))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is(200));
    }

    @Test
    public void deveAtualizarUmaConta() throws Exception{
        Conta conta = criaConta();

        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(conta));
        Mockito.when(repository.save(any(Conta.class))).thenReturn(conta);

        MockHttpServletRequestBuilder requestBuilder = put("/conta/{id}",1)
                .content(objectMapper.writeValueAsString(conta))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().is(201));
    }

    @Test
    public void deveDeletarUmaConta() throws Exception{
        Conta conta = criaConta();

        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(conta));

        MockHttpServletRequestBuilder requestBuilder = delete("/conta/{id}",1)
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().is(204));
    }

    private Conta criaConta(){
        Conta conta = new Conta();
        conta.setId(1L);
        conta.setInclude_adult("true");
        conta.setName("andre yuri");
        conta.setUsername("AY");
        conta.setIso_639_1("pt");
        conta.setIso_3166_1("RJ");
        return conta;

    }
}

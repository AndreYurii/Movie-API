package com.produtos.apirest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean adult;
    private String backdrop_path;
    private String original_language;
    private String original_title;
    private String overview;
    private String popularity;
    private String release_date;
    private Integer revenue;
    private Integer runtime;
    private String tagline;

    @ManyToOne(fetch = FetchType.EAGER)
    private Genero genero;
}

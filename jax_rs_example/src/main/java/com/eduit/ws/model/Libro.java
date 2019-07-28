package com.eduit.ws.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Libro {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("autor")
    private String autor;
    @JsonProperty("nacional")
    private boolean nacional;

    public Libro() {
    }

    public Libro(Long id, String titulo, String autor, boolean nacional) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.nacional = nacional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isNacional() {
        return nacional;
    }

    public void setNacional(boolean nacional) {
        this.nacional = nacional;
    }
}

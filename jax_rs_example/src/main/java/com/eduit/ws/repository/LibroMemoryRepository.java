package com.eduit.ws.repository;

import com.eduit.ws.model.Libro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Marcelo on 10/06/2016.
 */
public class LibroMemoryRepository {

    private static  Map<Long,Libro> base = new HashMap<>();

    public LibroMemoryRepository() {
    }

    public Libro insert(Libro libro){
        base.put(libro.getId(),libro);
        return libro;
    }

    public Libro update(Libro libro){
        base.put(libro.getId(),libro);
        return libro;
    }

    public void delete (Long id){
        base.remove(id);
    }

    public Libro getById(Long id){
        return base.get(id);
    }


    public List<Libro> getAll(){
        return base.values().stream().collect(Collectors.toList());
    }

    public List<Libro> getByTitulo (String titulo){
        return base.values().stream().filter(libro -> libro.getTitulo().equals(titulo)).collect(Collectors.toList());
    }

}

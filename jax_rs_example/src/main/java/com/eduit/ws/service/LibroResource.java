package com.eduit.ws.service;

import com.eduit.ws.model.Libro;
import com.eduit.ws.repository.LibroMemoryRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/v1/libro")
public class LibroResource {

    private LibroMemoryRepository libroMemoryRepository = new LibroMemoryRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Libro> getAll(@QueryParam("titulo") String titulo){
        if(titulo != null){
                return libroMemoryRepository.getByTitulo(titulo);
        }
        return libroMemoryRepository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Libro getById(@PathParam("id")Long id){
        return libroMemoryRepository.getById(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Libro insert (Libro libro){
        return libroMemoryRepository.insert(libro);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Libro update (Libro libro){
        return libroMemoryRepository.insert(libro);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id){
        libroMemoryRepository.delete(id);
    }

}


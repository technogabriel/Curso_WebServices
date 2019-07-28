package com.eduit.rest.client;


import com.eduit.rest.client.model.Libro;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.javaws.jnl.LibraryDesc;

import java.io.IOException;

public class App {


    public static void main(String[] args) throws UnirestException, IOException {


       Unirest.setObjectMapper(new com.mashape.unirest.http.ObjectMapper() {

           ObjectMapper objectMapper = new ObjectMapper();

           @Override
           public <T> T readValue(String s, Class<T> aClass) {
               try {
                   return objectMapper.readValue(s, aClass);
               } catch (IOException e) {
                   throw new RuntimeException("could not parse json " + s, e);
               }
           }

           @Override
           public String writeValue(Object o) {
               try {
                   return objectMapper.writeValueAsString(o);
               } catch (JsonProcessingException e) {
                   throw new RuntimeException("could not create json from object " + o, e);
               }
           }
       });
        Libro libro = new Libro (id:111L, titulo: "titulo1", autor: "aaa", nacional:true);
        HttpResponse <Libro> libroHttpResponse= Unirest.post(url:"http://127.0.0.1:8080/store/api/v1/libro")
        .header(name:"Content-Type", value:"application/json")
        .header(name:"Authorization", value:"123")
        .body(libro)
                .asObject(Libro.class);

        if(response.getStatus() / 100==2){
            Libro libroResponse = response.getBody();
            System.out.println(libroResponse);
        }else{
            throw new RuntimeException ("response status"+ status);
        }
HttpResponse <Libro> libroHttpResponse = Unirest.get("http://127.0.0.1:8080/store/api/v1/libro/{id}")
                .header(name:"Content-Type", value:"application/json")
                .header(name:"Authorization", value:"123")
        .routeParam(name:"id", value:"111")
        .asObject(Libro.class);

        status= libroHttpResponse.getStatus();
        if(status /100 ==2){
            Libro libroResponse= libroHttpResponse.getBody();
            System.out.println(libroResponse);
        } else {
            throw new RuntimeException ("response status" + status);
        }

        Unirest.shutdown();

    }


}

package com.eduit.spring.ws.repository;

import com.eduit.spring.ws.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ItemRepository extends CrudRepository<Item, Long> {


    List<Item> getByName(String name);


}

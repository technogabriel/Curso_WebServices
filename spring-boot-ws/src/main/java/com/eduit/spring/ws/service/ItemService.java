package com.eduit.spring.ws.service;


import com.eduit.spring.ws.model.Item;
import com.eduit.spring.ws.repository.ItemRepository;
import com.eduit.spring.ws.resource.request.ItemRequest;
import com.eduit.spring.ws.resource.response.ItemResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public ItemResponse getById(Long id){
        Item item = itemRepository.findOne(id);
        ItemResponse itemResponse = toItemResponse(item);
        return itemResponse ;
    }

    public boolean exists(long id){
        return itemRepository.exists(id);
    }


    public List<ItemResponse> getAll(){
        List<ItemResponse> itemResponses = new ArrayList<>();
        itemRepository.findAll().forEach(item -> {
            ItemResponse itemResponse = toItemResponse(item);
            itemResponses.add(itemResponse);
        });
        return itemResponses;
    }

    private ItemResponse toItemResponse(Item item) {
        return new ItemResponse(item.getId(),
                        item.getName(),
                        item.getPrice(),
                        item.getQuantity());
    }

    @Transactional
    public ItemResponse saveOrUpdate(ItemRequest itemRequest){
        Item item = new Item(itemRequest.getId(),itemRequest.getName(),itemRequest.getPrice(),itemRequest.getQuantity());
        Item saved = itemRepository.save(item);
        ItemResponse itemResponse = toItemResponse(saved);
        return itemResponse;
    }

    public void delete(long id){
        itemRepository.delete(id);
    }





}

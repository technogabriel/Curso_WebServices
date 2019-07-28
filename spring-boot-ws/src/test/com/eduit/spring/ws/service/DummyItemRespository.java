package com.eduit.spring.ws.service;

import com.eduit.spring.ws.model.Item;
import com.eduit.spring.ws.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

public class DummyItemRespository implements ItemRepository {


    @Override
    public List<Item> getByName(String name) {
        return null;
    }

    @Override
    public <S extends Item> S save(S s) {
        return null;
    }

    @Override
    public <S extends Item> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Item findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Item> findAll() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("item",10.0F,10));
        items.add(new Item("item2",10.0F,10));
        items.add(new Item("item",20.0F,100));
        return items;
    }

    @Override
    public Iterable<Item> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Item item) {

    }

    @Override
    public void delete(Iterable<? extends Item> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}

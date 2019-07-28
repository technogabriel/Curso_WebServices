package com.eduit.spring.ws.service;

import com.eduit.spring.ws.model.Item;
import com.eduit.spring.ws.resource.response.ItemResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ItemServiceTest {


    private ItemService itemService;
    private List<ItemResponse> itemResponses;

    @Test
    public void mustCreateThreeItemResponsesWhenGetAll(){
        givenAnItemService();
        whenGetAll();
        thenShouldCreateThreeItemResponses();
    }

    private void thenShouldCreateThreeItemResponses() {
        Assert.assertEquals(3 , itemResponses.size());
    }

    private void whenGetAll() {
        itemResponses = itemService.getAll();
    }

    private void givenAnItemService() {
        itemService = new ItemService(new DummyItemRespository());
    }


}

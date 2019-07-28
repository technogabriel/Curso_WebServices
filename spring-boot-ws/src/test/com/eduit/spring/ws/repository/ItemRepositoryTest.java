package com.eduit.spring.ws.repository;

import com.eduit.spring.ws.model.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemRepositoryTest {


    @Autowired
    private ItemRepository itemRepository;
    private List<Item> items;


    @Test
    public void shouldFindTwoItems(){
        givenAnItemRepositoryWithThreeItems();
        whenFindByName();
        thenMustFindTwoItems();
    }

    private void thenMustFindTwoItems() {
        Item item = items.get(0);
        Item item1 = items.get(1);

        Assert.assertEquals(2, items.size());
        items.forEach(i->  Assert.assertEquals("item",i.getName()));

        Assert.assertEquals(10L,item.getQuantity().longValue());
        Assert.assertEquals(10.0F,item.getPrice().floatValue(),0);

        Assert.assertEquals(100L,item1.getQuantity().longValue());
        Assert.assertEquals(20.0F,item1.getPrice().floatValue(),0);
    }

    private void whenFindByName() {
        items = itemRepository.getByName("item");
    }

    private void givenAnItemRepositoryWithThreeItems() {
        itemRepository.save(new Item("item",10.0F,10));
        itemRepository.save(new Item("item2",10.0F,10));
        itemRepository.save(new Item("item",20.0F,100));
    }


}

package com.example.AloneFunctionDevelop.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {

    private static Map<Integer, Item> store = new ConcurrentHashMap<>(); // 동시성



    public Item findItemByNum(int num) {
        Item item = store.get(num);
        return item;
    }

    public List<Item> findAllItem() {
        return new ArrayList<>(store.values());
    }

    public void save(Item item) {
        store.put(item.getNum(), item);
    }


}

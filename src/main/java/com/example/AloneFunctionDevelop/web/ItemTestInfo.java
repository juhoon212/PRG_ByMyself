package com.example.AloneFunctionDevelop.web;

import com.example.AloneFunctionDevelop.domain.Item;
import com.example.AloneFunctionDevelop.domain.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class ItemTestInfo {

    private final ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        itemRepository.save(new Item(1, "test1"));
        itemRepository.save(new Item(2, "test2"));
    }
}

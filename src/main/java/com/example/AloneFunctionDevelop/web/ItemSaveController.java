package com.example.AloneFunctionDevelop.web;


import com.example.AloneFunctionDevelop.domain.Item;
import com.example.AloneFunctionDevelop.domain.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basic")
public class ItemSaveController {

    private final ItemRepository itemRepository;

    @GetMapping("/items")
    public String showForm(Model model) {
        List<Item> items = itemRepository.findAllItem();
        model.addAttribute("items", items);

        return "basic/items";
    }


    @GetMapping("/saveForm")
    public String showAddForm() {
        return "basic/saveForm";
    }

    //@PostMapping("/saveForm")
    public String saveItemBefore(@ModelAttribute Item item) {

        itemRepository.save(item);

        return "basic/item";
    }



    @PostMapping("/saveForm")
    public String saveItemAfter(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {

        itemRepository.save(item);
        redirectAttributes.addAttribute("param", true);
        redirectAttributes.addAttribute("itemNum", item.getNum());


        return "redirect:/basic/item/{itemNum}";
    }

    @GetMapping("/item/{itemNum}")
    public String findItemByNum(@PathVariable Integer itemNum, Model model) {
        Item item = itemRepository.findItemByNum(itemNum);
        model.addAttribute("item", item);
        return "basic/item";
    }




}

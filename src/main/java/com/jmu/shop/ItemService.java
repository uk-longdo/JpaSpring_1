package com.jmu.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(@RequestParam Map<String, Object> formData){
        Item item = new Item();
        item.title = formData.get("title").toString();
        item.price = Integer.valueOf(formData.get("price").toString());
        itemRepository.save(item);
    }
}

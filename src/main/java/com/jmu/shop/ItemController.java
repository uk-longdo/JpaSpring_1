package com.jmu.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final NoticeRepository noticeRepository;
    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items",result);
        var a = new Item();
        System.out.println(a.toString());
        return "list.html";
    }

    @GetMapping("/insert")
    String insert(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items",result);
        var a = new Item();
        System.out.println(a.toString());
        return "insert.html";
    }

    @GetMapping("/edit")
    String edit(Model model){
        return "edit.html";
    }

    @GetMapping("/notice")
    String notice(Model model){
        List<Notice> result = noticeRepository.findAll();
        model.addAttribute("notice",result);
        var a = new Item();
        System.out.println(a.toString());
        return "notice.html";
    }


    @PostMapping("/edit_insert")
    String edit_insert(@RequestParam Map<String, Object> formData){
        System.out.println(formData.get("title"));
        System.out.println(formData.get("price"));

        Item item = new Item();
        item.title = formData.get("title").toString();
        item.price = Integer.valueOf(formData.get("price").toString());

        itemRepository.save(item);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id,Model model){
        System.out.println(id);
        Item item = new Item();

        Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()){
            System.out.println(result.get());
            model.addAttribute("detail",result.get());
            return "detail.html";
        }else{
            return "redirect:/list";
        }
    }
}

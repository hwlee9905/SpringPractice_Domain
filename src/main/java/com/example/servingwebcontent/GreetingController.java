package com.example.servingwebcontent;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", defaultValue = "World") String name, Model model) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7);
        Map<String, String> map = new HashMap<String, String>();

        // listIterator()를 통해 반복자 생성
        ListIterator<Integer> iterator = numbers.listIterator();
        model.addAttribute("name", name);

        return "greeting";
    }

}

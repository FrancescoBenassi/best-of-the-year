package org.java.lessons.spring_mvc.best_of_the_year.controller;

import java.util.ArrayList;

import org.java.lessons.spring_mvc.best_of_the_year.classes.Movie;
import org.java.lessons.spring_mvc.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PageController {

    @GetMapping("/index")
    public String index(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    

}

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

    private ArrayList<Movie> getBestMovies() {
        ArrayList<Movie> movies = new ArrayList();
        movies.add(new Movie(1, "Titolo1"));
        movies.add(new Movie(2, "Titolo2"));
        movies.add(new Movie(3, "Titolo3"));
        return movies;
    }

    private ArrayList<Song> getBestSongs() {
        ArrayList<Song> songs = new ArrayList();
        songs.add(new Song(1, "Titolo1"));
        songs.add(new Song(2, "Titolo2"));
        songs.add(new Song(3, "Titolo3"));
        return songs;

    }

}

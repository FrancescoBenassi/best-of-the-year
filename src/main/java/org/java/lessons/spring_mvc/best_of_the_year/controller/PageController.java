package org.java.lessons.spring_mvc.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.lessons.spring_mvc.best_of_the_year.classes.Movie;
import org.java.lessons.spring_mvc.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PageController {

    private ArrayList<Movie> movies = new ArrayList();
    private ArrayList<Song> songs = new ArrayList();

    @GetMapping("/home")
    public String indexName(Model model) {
        return "home";
    }

    @GetMapping("/index")
    public String index(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    private ArrayList<Movie> getBestMovies() {
        if (movies.size() == 0) {
            movies.add(new Movie(1, "Film1"));
            movies.add(new Movie(2, "Film2"));
            movies.add(new Movie(3, "Film3"));
        }
        return movies;
    }

    private ArrayList<Song> getBestSongs() {
        if (songs.size() == 0) {
            songs.add(new Song(1, "Canzone1"));
            songs.add(new Song(2, "Canzone2"));
            songs.add(new Song(3, "Canzone3"));
        }
        return songs;
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        model.addAttribute("movies", getBestMovies());
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("songs", getBestSongs());
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String movieId(@PathVariable int id, Model model) {
        List<Movie> movies = getBestMovies();

        Movie movieId = null;
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                movieId = movie;
                break;
            }
        }
        model.addAttribute("item", movieId);
        return "details";
    }

    @GetMapping("/songs/{id}")
    public String songId(Model model, @PathVariable int id) {
        ArrayList<Song> songs = getBestSongs();
        Song songId = null;
        for (Song song : songs) {
            if (song.getId() == id) {
                songId = song;
                break;
            }
        }
        model.addAttribute("item", songId);
        return "details";
    }
}

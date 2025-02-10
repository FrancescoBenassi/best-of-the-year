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

    @GetMapping("/movies")
    public String movies(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("movies", getBestMovies());
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("songs", getBestSongs());
        return "songs";
    }

    @GetMapping("/movie/{id}")
    public String movieId(Model model, @PathVariable("id") int id) {
        ArrayList<Movie> movies = getBestMovies();
        Movie movieId = null;
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                movieId = movie;
                break;
            }
        }
        model.addAttribute("movie", movieId);
        return "movie";

    }

    @GetMapping("/song/{id}")
    public String songId(Model model, @PathVariable("id") int id) {
        ArrayList<Song> songs = getBestSongs();
        Song songId = null;
        for (Song song : songs) {
            if (song.getId() == id) {
                songId = song;
                break;
            }
        }
        model.addAttribute("song", songId);
        return "song";
    }

}

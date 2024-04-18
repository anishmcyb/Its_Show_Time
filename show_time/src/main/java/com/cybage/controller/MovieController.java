package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cybage.entity.MovieEntity;

import com.cybage.service.MovieService;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

   
    @GetMapping("/findByCity/{city}")
    public ResponseEntity<List<MovieEntity>> findByCity(@PathVariable String city) {
        List<MovieEntity> movies = movieService.findByCity(city);
        if (movies.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(movies);
        }}
     @GetMapping("/findByLanguage")
    public ResponseEntity<List<MovieEntity>> getMoviesByLanguage(@RequestParam String language) {
        List<MovieEntity> movies = movieService.findByLanguage(language);
        if (!movies.isEmpty()) {
            return ResponseEntity.ok(movies);
        } else {
            return ResponseEntity.notFound().build();
        }}
    
     @GetMapping("/findByGenre")
     public ResponseEntity<List<MovieEntity>> getMoviesByGenre(@RequestParam String genre) {
         List<MovieEntity> movies = movieService.findByGenre(genre);
         if (!movies.isEmpty()) {
             return ResponseEntity.ok(movies);
         } else {
             return ResponseEntity.notFound().build();
         }}
    
}
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

import com.cybage.entity.EventEntity;
import com.cybage.entity.MovieEntity;
import com.cybage.service.EventService;
@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/events")
public class EventController {
	
	
	    @Autowired
	    private EventService eventService;
	    @GetMapping("/findByCity/{city}")
	    public ResponseEntity<List<EventEntity>> findByCity(@PathVariable String city) {
	        List<EventEntity> events = eventService.findByCity(city);
	        if (events.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        } else {
	            return ResponseEntity.ok(events);
	        }}
	    @GetMapping("/findByGenre")
	     public ResponseEntity<List<EventEntity>> getMoviesByGenre(@RequestParam String genre) {
	         List<EventEntity> events =eventService.findByGenre(genre);
	         if (!events.isEmpty()) {
	             return ResponseEntity.ok(events);
	         } else {
	             return ResponseEntity.notFound().build();
	         }}

	       
	        @GetMapping("/price-range/0-300")
	        public List<EventEntity> getEventsByPriceRange0To300() {
	            return eventService.findEventsByPriceRange0To300();
	        }

	        @GetMapping("/price-range/300-500")
	        public List<EventEntity> getEventsByPriceRange300To500() {
	            return eventService.findEventsByPriceRange300To500();
	        }

	        @GetMapping("/price-range/500-900")
	        public List<EventEntity> getEventsByPriceRange500To900() {
	            return eventService.findEventsByPriceRange500To900();
	        }

	        @GetMapping("/price-range/900-above")
	        public List<EventEntity> getEventsByPriceAbove900() {
	            return eventService.findEventsByPriceAbove900();
	        }
	    }

	    
	    

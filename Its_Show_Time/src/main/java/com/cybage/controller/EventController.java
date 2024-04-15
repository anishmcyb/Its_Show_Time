package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.bean.EventBean;
import com.cybage.service.EventService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/events")
public class EventController {
	@Autowired
	private EventService eventService;

	@PostMapping("/addEvent")
	public ResponseEntity<EventBean> addEvent(@RequestBody EventBean eventBean) {
		EventBean newEventBean = eventService.addEvent(eventBean);
		ResponseEntity<EventBean> responseEntity = new ResponseEntity<EventBean>(newEventBean, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/displayEventById/{eventId}")
	public ResponseEntity<EventBean> displayEventById(@PathVariable("eventId")int eventId){
		EventBean fetchedEvent = eventService.displayEventById(eventId);
		if(fetchedEvent!=null) {
			return ResponseEntity.ok(fetchedEvent);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/displayEvents")
	public ResponseEntity<List<EventBean>> displayEvents() {
		List<EventBean> eventList = eventService.displayEvents();
		if (eventList != null && !eventList.isEmpty()) {
			return ResponseEntity.ok(eventList);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/deleteEvent/{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable("id") int id) {
		String deleteEvent = eventService.deleteEvent(id);
		if (deleteEvent != null && deleteEvent.contains("deleted successfully")) {
			return ResponseEntity.ok(deleteEvent);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/deleteEventByName/{name}")
	public ResponseEntity<String> deleteEventByName(@PathVariable("name") String name) {
		boolean deleteEvent = eventService.deleteEventByName(name);
		if (deleteEvent) {
			return ResponseEntity.ok("Event with " + name + " has deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such event found");
		}
	}

	@GetMapping("/searchEvents/{letter}")
	public ResponseEntity<List<EventBean>> searchEvents(@PathVariable("letter") String eventName) {
		List<EventBean> eventList = eventService.searchEvents(eventName);
		if (eventList != null && !eventList.isEmpty()) {
			return ResponseEntity.ok(eventList);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/updateEvent")
	public ResponseEntity<EventBean> updateEvent(@RequestBody EventBean eventBean) {
		EventBean updatedEventBean = eventService.updateEvent(eventBean);
		ResponseEntity<EventBean> responseEntity = new ResponseEntity<EventBean>(updatedEventBean, HttpStatus.OK);
		return responseEntity;
	}

}

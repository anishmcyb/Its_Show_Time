package com.cybage.service;

import java.util.List;

import com.cybage.bean.EventBean;

public interface EventService {

	EventBean addEvent(EventBean eventBean);

	List<EventBean> displayEvents();

	String deleteEvent(int id);

	boolean deleteEventByName(String name);

	List<EventBean> searchEvents(String eventName);

	EventBean updateEvent(EventBean eventBean);

	EventBean displayEventById(int eventId);

}

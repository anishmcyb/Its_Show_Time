package com.cybage.service;

import java.util.List;

import com.cybage.entity.EventEntity;

public interface EventService {

	List<EventEntity> findByCity(String city);

	List<EventEntity> findByGenre(String genre);

	

	List<EventEntity> findEventsByPriceRange0To300();

	
	List<EventEntity> findEventsByPriceRange300To500();

    List<EventEntity> findEventsByPriceRange500To900();

    List<EventEntity> findEventsByPriceAbove900();
	
}

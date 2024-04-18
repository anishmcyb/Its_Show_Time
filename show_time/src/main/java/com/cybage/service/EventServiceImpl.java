package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.EventDao;

import com.cybage.entity.EventEntity;
@Service
public class EventServiceImpl implements EventService{
	@Autowired
	private EventDao eventDao;
	@Override
	public List<EventEntity> findByCity(String city) {
		// TODO Auto-generated method stub
		return eventDao.findByCity(city);
	}
	@Override
	public List<EventEntity> findByGenre(String genre) {
		
		    return eventDao.findByGenre(genre);
		}

	
	    

	    @Override
	    public List<EventEntity> findEventsByPriceRange0To300() {
	        return eventDao.findByPriceRange0To300();
	    }

	    @Override
	    public List<EventEntity> findEventsByPriceRange300To500() {
	        return eventDao.findByPriceRange300To500();
	    }

	    @Override
	    public List<EventEntity> findEventsByPriceRange500To900() {
	        return eventDao.findByPriceRange500To900();
	    }

	    @Override
	    public List<EventEntity> findEventsByPriceAbove900() {
	        return eventDao.findByPriceAbove900();
	    }
	}

	


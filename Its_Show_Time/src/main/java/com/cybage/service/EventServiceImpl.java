package com.cybage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.bean.EventBean;
import com.cybage.dao.EventDao;
import com.cybage.entity.EventEntity;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	@Override
	public EventBean addEvent(EventBean eventBean) {
		EventEntity eventEntity = new EventEntity();
		// convert bean to entity
		BeanUtils.copyProperties(eventBean, eventEntity);
		// save the newly added record into the database
		EventEntity newEventEntity = eventDao.save(eventEntity);
		// convert back form entity to bean
		BeanUtils.copyProperties(newEventEntity, eventBean);
		return eventBean;
	}

	@Override
	public List<EventBean> displayEvents() {
		// find the record first
		List<EventEntity> eventEntities = eventDao.findAll();
		// create a list of EventBean
		List<EventBean> eventBeanList = new ArrayList<EventBean>();
		// convert entity to bean and add to bean-list
		for (EventEntity eventEntity : eventEntities) {
			EventBean customerBean = new EventBean();
			BeanUtils.copyProperties(eventEntity, customerBean);
			eventBeanList.add(customerBean);
		}
		return eventBeanList;
	}

	@Override
	public String deleteEvent(int id) {
		Optional<EventEntity> requiredEventEntity = eventDao.findById(id);
		if (requiredEventEntity.isPresent()) {
			EventEntity deleteEventEntity = requiredEventEntity.get();
			eventDao.delete(deleteEventEntity);
			return "Event deleted successfully";
		} else {
			return "Event not deleted or not found";
		}
	}

	@Override
	public boolean deleteEventByName(String name) {
		List<EventEntity> events = eventDao.findByEventName(name);
		if (!events.isEmpty()) {
			for (EventEntity event : events) {
				eventDao.delete(event);
			}
			return true;
		}
		return false;
	}

	@Override
	public List<EventBean> searchEvents(String letter) {
		List<EventEntity> eventEntityList = eventDao.searchEvent(letter);
		List<EventBean> eventBeanList = new ArrayList<EventBean>();
		for (EventEntity eventEntity : eventEntityList) {
			EventBean eventBean = new EventBean();
			BeanUtils.copyProperties(eventEntity, eventBean);
			eventBeanList.add(eventBean);
		}
		return eventBeanList;
	}

	@Override
	public EventBean updateEvent(EventBean eventBean) {
		Optional<EventEntity> requiredEventEntity = eventDao.findById(eventBean.getEventId());
		if (requiredEventEntity.isPresent()) {
			EventEntity updateEventEntity = requiredEventEntity.get();
			// convert bean to entity
			BeanUtils.copyProperties(eventBean, updateEventEntity);
			eventDao.save(updateEventEntity);
			// convert back to bean from entity
			EventBean newEventBean = new EventBean();
			BeanUtils.copyProperties(updateEventEntity, newEventBean);
			return newEventBean;
		} else {
			return null;
		}
	}

	@Override
	public EventBean displayEventById(int eventId) {
		Optional<EventEntity> eventEntity = eventDao.findById(eventId);
		if (eventEntity.isPresent()) {
			EventBean eventBean = new EventBean();
			BeanUtils.copyProperties(eventEntity.get(), eventBean);
			return eventBean;
		} else {
			return null;
		}
	}

}

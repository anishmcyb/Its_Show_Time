package com.cybage.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import com.cybage.ItsShowTimeApplication;
import com.cybage.bean.EventBean;
import com.cybage.entity.EventEntity;
import com.cybage.dao.EventDao;

@SpringBootTest
@ContextConfiguration(classes = { ItsShowTimeApplication.class })
public class TestEventServiceImpl {
	@Autowired
	private EventServiceImpl eventServiceImpl;

	@Test
	public void addEvent() {
		EventBean eventBean = new EventBean(1, "Comedy Nights", "Hindi", "Mumbai", "comedy", 120, "2024-05-01", 299,
				"comedy.jpg", "Kapil Sharma", "kapil.jpa", "It is comedy show hosted by Kapil Sharma");
		EventBean returnedEvent = eventServiceImpl.addEvent(eventBean);
		Assertions.assertEquals(eventBean, returnedEvent);
	}

	@Test
	public void deleteEvent() {
		EventBean eventBean = new EventBean(1, "Comedy Nights", "Hindi", "Mumbai", "comedy", 120, "2024-05-01", 299,
				"comedy.jpg", "Kapil Sharma", "kapil.jpa", "It is comedy show hosted by Kapil Sharma");
		EventBean newEvent = eventServiceImpl.addEvent(eventBean);
		String result = eventServiceImpl.deleteEvent(newEvent.getEventId());
		Assertions.assertEquals("Event deleted successfully", result);
	}

	@Test
	public void updateEvent() {
		EventBean eventBean = new EventBean(1, "Comedy Nights", "Hindi", "Mumbai", "comedy", 120, "2024-05-01", 299,
				"comedy.jpg", "Kapil Sharma", "kapil.jpa", "It is comedy show hosted by Kapil Sharma");
		EventBean addedBean = eventServiceImpl.addEvent(eventBean);
		// update the records
		addedBean.setEventName("Cash Game Show");
		addedBean.setLanguage("Telugu");
		addedBean.setDescription("It is game show");

		EventBean updatedEvent = eventServiceImpl.updateEvent(addedBean);

		// Verify the updated task details
		Assertions.assertEquals("Cash Game Show", updatedEvent.getEventName());
		Assertions.assertEquals("Telugu", updatedEvent.getLanguage());
		Assertions.assertEquals("It is game show", updatedEvent.getDescription());
	}

	@Test
	public void displayEvents() {
		EventBean eventBean1 = new EventBean(1, "Comedy Nights", "Hindi", "Mumbai", "comedy", 120, "2024-05-01", 299,
				"comedy.jpg", "Kapil Sharma", "kapil.jpa", "It is comedy show hosted by Kapil Sharma");
		EventBean eventBean2 = new EventBean(2, "Dance India Dance", "Hindi", "Delhi", "dance", 180, "2024-05-02", 499,
				"dance.jpg", "Remo D'Souza", "remo.jpa", "It is dance show hosted by Remo D'Souza");

		EventEntity eventEntity1 = new EventEntity();
		EventEntity eventEntity2 = new EventEntity();

		BeanUtils.copyProperties(eventBean1, eventEntity1);
		BeanUtils.copyProperties(eventBean2, eventEntity2);

		List<EventEntity> eventEntities = new ArrayList<EventEntity>();
		eventEntities.add(eventEntity1);
		eventEntities.add(eventEntity2);

		List<EventBean> eventBeanList = new ArrayList<EventBean>();
		EventBean evenBean1Copy = new EventBean();
		EventBean eventBean2Copy = new EventBean();

		BeanUtils.copyProperties(eventEntity1, evenBean1Copy);
		BeanUtils.copyProperties(eventEntity2, eventBean2Copy);

		eventBeanList.add(evenBean1Copy);
		eventBeanList.add(eventBean2Copy);

		EventDao eventDaoMock = mock(EventDao.class);
		ReflectionTestUtils.setField(eventServiceImpl, "eventDao", eventDaoMock);

		Optional<List<EventEntity>> optionalEventEntities = Optional.of(eventEntities);

		when(eventDaoMock.findAll()).thenReturn(eventEntities);

		List<EventBean> result = eventServiceImpl.displayEvents();

//		Assertions.assertEquals(eventBeanList, result);   // this doesn't match the address
		Assertions.assertIterableEquals(eventBeanList, result);
	}

	@Test
	public void searchEvents() {
		String letter = "C";
		EventBean eventBean1 = new EventBean(1, "Comedy Nights", "Hindi", "Mumbai", "comedy", 120, "2024-05-01", 299,
				"comedy.jpg", "Kapil Sharma", "kapil.jpa", "It is comedy show hosted by Kapil Sharma");
		EventBean eventBean2 = new EventBean(3, "Comedy Circus", "Hindi", "Mumbai", "comedy", 120, "2024-05-03", 299,
				"comedy.jpg", "Kapil Sharma", "kapil.jpa", "It is comedy show hosted by Kapil Sharma");

		EventEntity eventEntity1 = new EventEntity();
		EventEntity eventEntity2 = new EventEntity();

		BeanUtils.copyProperties(eventBean1, eventEntity1);
		BeanUtils.copyProperties(eventBean2, eventEntity2);

		List<EventEntity> eventEntities = new ArrayList<EventEntity>();
		eventEntities.add(eventEntity1);
		eventEntities.add(eventEntity2);

		List<EventBean> eventBeanList = new ArrayList<EventBean>();
		EventBean evenBean1Copy = new EventBean();
		EventBean eventBean2Copy = new EventBean();

		BeanUtils.copyProperties(eventEntity1, evenBean1Copy);
		BeanUtils.copyProperties(eventEntity2, eventBean2Copy);

		eventBeanList.add(evenBean1Copy);
		eventBeanList.add(eventBean2Copy);

		EventDao eventDaoMock = mock(EventDao.class);
		ReflectionTestUtils.setField(eventServiceImpl, "eventDao", eventDaoMock);

		Optional<List<EventEntity>> optionalEventEntities = Optional.of(eventEntities);

		when(eventDaoMock.searchEvent(letter)).thenReturn(eventEntities);

		List<EventBean> result = eventServiceImpl.searchEvents(letter);

		Assertions.assertIterableEquals(eventBeanList, result);
	}
}

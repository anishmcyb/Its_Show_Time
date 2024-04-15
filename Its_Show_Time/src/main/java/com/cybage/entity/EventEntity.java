package com.cybage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EventEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventId;
	private String eventName;
	private String language;
	private String city;
	private String genre;
	private int duration;
	private String releaseDate;
	private double price;
	private String eventPosterUrl;
	private String artist;
	private String artistUrl;
	private String description;
	public EventEntity() {
		super();
	}
	public EventEntity(int eventId, String eventName, String language, String city, String genre, int duration,
			String releaseDate, double price, String eventPosterUrl, String artist, String artistUrl,String description) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.language = language;
		this.city = city;
		this.genre = genre;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.price = price;
		this.eventPosterUrl = eventPosterUrl;
		this.artist = artist;
		this.artistUrl = artistUrl;
		this.description = description;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getEventPosterUrl() {
		return eventPosterUrl;
	}
	public void setEventPosterUrl(String eventPosterUrl) {
		this.eventPosterUrl = eventPosterUrl;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getArtistUrl() {
		return artistUrl;
	}
	public void setArtistUrl(String artistUrl) {
		this.artistUrl = artistUrl;
	}
	@Override
	public String toString() {
		return "EventEntity [eventId=" + eventId + ", eventName=" + eventName + ", language=" + language + ", city="
				+ city + ", genre=" + genre + ", duration=" + duration + ", releaseDate=" + releaseDate + ", price="
				+ price + ", eventPosterUrl=" + eventPosterUrl + ", artist=" + artist + ", artistUrl=" + artistUrl
				+ ", description=" + description + "]";
	}
	
	
	
	
}

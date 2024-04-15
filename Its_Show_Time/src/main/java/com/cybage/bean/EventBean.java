package com.cybage.bean;

public class EventBean {
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
	public EventBean() {
		super();
	}
	public EventBean(int eventId, String eventName, String language, String city, String genre, int duration,
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
		return "EventBean [eventId=" + eventId + ", eventName=" + eventName + ", language=" + language + ", city="
				+ city + ", genre=" + genre + ", duration=" + duration + ", releaseDate=" + releaseDate + ", price="
				+ price + ", eventPosterUrl=" + eventPosterUrl + ", artist=" + artist + ", artistUrl=" + artistUrl
				+ ", description=" + description + "]";
	}
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (getClass() != obj.getClass()) {
	        return false;
	    }
	    final EventBean other = (EventBean) obj;
	    if (this.eventId != other.eventId) {
	        return false;
	    }
	    if ((this.eventName == null) ? (other.eventName != null) : !this.eventName.equals(other.eventName)) {
	        return false;
	    }
	    if ((this.language == null) ? (other.language != null) : !this.language.equals(other.language)) {
	        return false;
	    }
	    if ((this.city == null) ? (other.city != null) : !this.city.equals(other.city)) {
	        return false;
	    }
	    if ((this.genre == null) ? (other.genre != null) : !this.genre.equals(other.genre)) {
	        return false;
	    }
	    if (this.duration != other.duration) {
	        return false;
	    }
	    if (this.releaseDate == null) {
	        if (other.releaseDate != null) {
	            return false;
	        }
	    } else if (!this.releaseDate.equals(other.releaseDate)) {
	        return false;
	    }
	    if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
	        return false;
	    }
	    if ((this.eventPosterUrl == null) ? (other.eventPosterUrl != null) : !this.eventPosterUrl.equals(other.eventPosterUrl)) {
	        return false;
	    }
	    if ((this.artist == null) ? (other.artist != null) : !this.artist.equals(other.artist)) {
	        return false;
	    }
	    if ((this.artistUrl == null) ? (other.artistUrl != null) : !this.artistUrl.equals(other.artistUrl)) {
	        return false;
	    }
	    if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
	        return false;
	    }
	    return true;
	}
	
	
	
}

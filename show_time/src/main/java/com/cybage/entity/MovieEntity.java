package com.cybage.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    private String movieName;
    private String city;
    
    private String language;
   

	private String genre;
    private int duration;
    private String releaseDate;
    private double price;
    private String posterUrl;
    private String director;
    private String directorUrl;
    private String description;

    public MovieEntity() {
        super();
    }
    public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirectorUrl() {
        return directorUrl;
    }

    public void setDirectorUrl(String directorUrl) {
        this.directorUrl = directorUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public String toString() {
		return "MovieEntity [movieId=" + movieId + ", movieName=" + movieName + ", city=" + city + ", languages="
				+ language + ", genre=" + genre + ", duration=" + duration + ", releaseDate=" + releaseDate
				+ ", price=" + price + ", posterUrl=" + posterUrl + ", director=" + director + ", directorUrl="
				+ directorUrl + ", description=" + description + "]";
	}

    
}

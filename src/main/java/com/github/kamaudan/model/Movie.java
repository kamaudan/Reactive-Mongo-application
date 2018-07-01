package com.github.kamaudan.model;



import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie {

    private String id;
    private String name;
    private Long rating;

    public Movie(String id, String name, Long rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }




}

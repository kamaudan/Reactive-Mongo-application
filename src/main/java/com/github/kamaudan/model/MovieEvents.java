package com.github.kamaudan.model;



import java.util.Date;




public class MovieEvents {


    public MovieEvents(Movie movie, Date date, String user) {
        this.movie = movie;
        this.date = date;
        this.user = user;
    }

    private Movie movie;
    private Date date;
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



}


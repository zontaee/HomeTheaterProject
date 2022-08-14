package com.oracle.HomeTheater.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Movie {
    private int mo_number;
    private String mo_title;
    private String mo_director;
    private String mo_actor;
    private String mo_genre;
    private String mo_age;
    private String mo_playTime;
    private String mo_openDate;
    private int mo_recommendation;
    private String mo_fileName;
    private List<SeatandTime> seatandTime;

    public Movie() {
    }

    public Movie(String mo_title, String mo_director, String mo_actor, String mo_genre, String mo_age, String mo_playTime, String mo_openDate, int mo_recommendation, String mo_fileName) {

        this.mo_title = mo_title;
        this.mo_director = mo_director;
        this.mo_actor = mo_actor;
        this.mo_genre = mo_genre;
        this.mo_age = mo_age;
        this.mo_playTime = mo_playTime;
        this.mo_openDate = mo_openDate;
        this.mo_recommendation = mo_recommendation;
        this.mo_fileName = mo_fileName;
    }

    public Movie(int mo_number, String mo_title, String mo_director, String mo_actor, String mo_genre, String mo_age, String mo_playTime, String mo_openDate, int mo_recommendation, String mo_fileName) {
        this.mo_number = mo_number;
        this.mo_title = mo_title;
        this.mo_director = mo_director;
        this.mo_actor = mo_actor;
        this.mo_genre = mo_genre;
        this.mo_age = mo_age;
        this.mo_playTime = mo_playTime;
        this.mo_openDate = mo_openDate;
        this.mo_recommendation = mo_recommendation;
        this.mo_fileName = mo_fileName;
    }
}

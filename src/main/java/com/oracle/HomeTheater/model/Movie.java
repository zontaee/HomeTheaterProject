package com.oracle.HomeTheater.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Movie {
 private int  mo_number;
 private  String mo_title;
 private  String mo_director;
 private  String mo_actor;
 private  String mo_genre;
 private  String mo_age;
 private  String mo_playTime;
 private  String mo_openDate;
 private  int mo_recommendation;
 private  String mo_fileName;

 @Override
 public String toString() {
  return "Movie{" +
          "mo_number=" + mo_number +
          ", mo_title='" + mo_title + '\'' +
          ", mo_director='" + mo_director + '\'' +
          ", mo_actor='" + mo_actor + '\'' +
          ", mo_genre='" + mo_genre + '\'' +
          ", mo_age='" + mo_age + '\'' +
          ", mo_playTime='" + mo_playTime + '\'' +
          ", mo_openDate='" + mo_openDate + '\'' +
          ", mo_recommendation=" + mo_recommendation +
          ", mo_fileName='" + mo_fileName + '\'' +
          '}';
 }
}

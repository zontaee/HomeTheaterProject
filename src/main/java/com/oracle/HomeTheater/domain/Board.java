package com.oracle.HomeTheater.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOARD_No")
    private int boardNo;
    @Column(name = "BOARD_Category")
    private int boardCategory;
    @Column(name = "BOARD_Titleo")
    private String boardTitle;
    @Column(name = "BOARD_Content")
    private String boardContent;
    @Column(name = "BOARD_Date")
    private String boardDate;
    @Column(name = "BOARD_Hit")
    private int boardHit;
    @Column(name = "m_id")
    private String Memberid;
}

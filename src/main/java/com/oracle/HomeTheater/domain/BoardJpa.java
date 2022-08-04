package com.oracle.HomeTheater.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "BOARD")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@SequenceGenerator(
        name ="BOARD_SEQ_GENERATOR",
        sequenceName = "BOARD_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 1)
public class BoardJpa {
    @Id
    @Column(name = "BOARD_No")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
    private Long boardNo;
    @Column(name = "BOARD_Category")
    private int boardCategory;
    @Column(name = "BOARD_Title")
    private String boardTitle;
    @Column(name = "BOARD_Content")
    private String boardContent;
    @Column(name = "BOARD_Date")
    private String boardDate;
    @Column(name = "BOARD_Hit")
    private int boardHit;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "M_Id")
    private MemberJpa memberJpa;

    public void addMember(MemberJpa memberJpa) {
        this.memberJpa = memberJpa;
        memberJpa.getBbs().add(this);
    }

    public BoardJpa(Long boardNo, int boardCategory, String boardTitle, String boardContent, String boardDate, int boardHit) {
        this.boardNo = boardNo;
        this.boardCategory = boardCategory;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardDate = boardDate;
        this.boardHit = boardHit;
    }

    public BoardJpa(int boardCategory, String boardTitle, String boardContent, String boardDate, int boardHit) {
        this.boardCategory = boardCategory;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardDate = boardDate;
        this.boardHit = boardHit;

    }

    public BoardJpa(int boardCategory, String boardTitle, String boardContent, String boardDate, int boardHit, MemberJpa memberJpa) {
        this.boardCategory = boardCategory;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardDate = boardDate;
        this.boardHit = boardHit;
        this.memberJpa = memberJpa;
    }

    public BoardJpa(Long boardNo, int boardCategory, String boardTitle, String boardContent, String boardDate, int boardHit, MemberJpa memberJpa) {
        this.boardNo = boardNo;
        this.boardCategory = boardCategory;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardDate = boardDate;
        this.boardHit = boardHit;
        this.memberJpa = memberJpa;
    }
}

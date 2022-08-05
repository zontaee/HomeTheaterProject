package com.oracle.HomeTheater.model;

import com.oracle.HomeTheater.domain.MemberJpa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class Board {
    private Long board_no;
    private int board_category;
    private String board_title;
    private String board_content;
    private String board_date;
    private int board_hit;
    private String m_id;


    // 조회용
    private String search;
    private String keyword;
    private String pageNum;
    private int start;
    private int end;

    public Board(Long board_no, int board_category, String board_title, String board_content, String board_date, int board_hit) {
        this.board_category = board_category;
        this.board_title = board_title;
        this.board_content = board_content;
        this.board_date = board_date;
        this.board_hit = board_hit;
        this.board_no = board_no;
    }

    public Board(int board_category, String board_title, String board_content, String board_date, int board_hit) {
        this.board_category = board_category;
        this.board_title = board_title;
        this.board_content = board_content;
        this.board_date = board_date;
        this.board_hit = board_hit;
    }

    public Board(Long board_no, int board_category, String board_title, String board_content, String board_date, int board_hit, String m_id) {
        this.board_no = board_no;
        this.board_category = board_category;
        this.board_title = board_title;
        this.board_content = board_content;
        this.board_date = board_date;
        this.board_hit = board_hit;
        this.m_id = m_id;
    }

    public Board(int board_category, String board_title, String board_content, String board_date, int board_hit, String m_id) {
        this.board_category = board_category;
        this.board_title = board_title;
        this.board_content = board_content;
        this.board_date = board_date;
        this.board_hit = board_hit;
        this.m_id = m_id;
    }
}

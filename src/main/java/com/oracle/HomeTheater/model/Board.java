package com.oracle.HomeTheater.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Board {
    private int board_no;			private int board_category;
    private String board_title;	private String board_content;
    private String board_date;	private int board_hit;
    private String m_id;

    // 조회용
    private String search;   	private String keyword;
    private String pageNum;
    private int start; 		 	private int end;

    public Board(int board_category, String board_title, String board_content, String board_date, int board_hit) {
        this.board_category = board_category;
        this.board_title = board_title;
        this.board_content = board_content;
        this.board_date = board_date;
        this.board_hit = board_hit;
    }
}

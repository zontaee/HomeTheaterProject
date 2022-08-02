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

    public int getBoard_no() {
        return board_no;
    }

    public int getBoard_category() {
        return board_category;
    }

    public String getBoard_title() {
        return board_title;
    }

    public String getBoard_content() {
        return board_content;
    }

    public String getBoard_date() {
        return board_date;
    }

    public int getBoard_hit() {
        return board_hit;
    }

    public String getM_id() {
        return m_id;
    }

    public String getSearch() {
        return search;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getPageNum() {
        return pageNum;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

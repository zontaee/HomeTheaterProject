package com.oracle.HomeTheater.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Bbs {
    private int bbs_no;
    private int bbs_category;
    private String bbs_title;
    private String bbs_content;
    private String bbs_date;
    private int bbs_hit;
    private String m_id;
}

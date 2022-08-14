package com.oracle.HomeTheater.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChoiceMovie {
	private String m_id;
	private String mo_number;
	private String m_selected;

	public ChoiceMovie() {
	}

	public ChoiceMovie(String m_id, String mo_number, String m_selected) {
		this.m_id = m_id;
		this.mo_number = mo_number;
		this.m_selected = m_selected;
	}
}

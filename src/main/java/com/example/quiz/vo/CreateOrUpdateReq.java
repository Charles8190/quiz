package com.example.quiz.vo;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateOrUpdateReq {

	private int id;

	private String name;

	private String description;

	@JsonProperty("start_date")
	private LocalDate startDate;

	@JsonProperty("end_date")
	private LocalDate endDate;

	@JsonProperty("question_list")
	private List<Question> questionList;

	@JsonProperty("is_published")
	private boolean published;

	public CreateOrUpdateReq() {
		super();
	}

	public CreateOrUpdateReq(String name, String description, LocalDate startDate, LocalDate endDate,
			List<Question> questionList, boolean published) {
		super();
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.questionList = questionList;
		this.published = published;
	}
	
	public CreateOrUpdateReq(int id, String name, String description, LocalDate startDate, LocalDate endDate,
			List<Question> questionList, boolean published) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.questionList = questionList;
		this.published = published;
	}

	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	@JsonProperty("start_date")
	public LocalDate getStartDate() {
		return startDate;
	}

	@JsonProperty("end_date")
	public LocalDate getEndDate() {
		return endDate;
	}

	@JsonProperty("question_list")
	public List<Question> getQuestionList() {
		return questionList;
	}

	public boolean isPublished() {
		return published;
	}

}

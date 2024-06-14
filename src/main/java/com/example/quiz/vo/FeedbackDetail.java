package com.example.quiz.vo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class FeedbackDetail {

	private String quizName;

	private String description;

	private LocalDate startDate;

	private LocalDate endDate;

	private String userName;

	private String phone;

	private String email;

	private int age;
	
	private List<Fillin> fillinList;

	//			題號			問題		  
	private Map<Integer, Map<String, String>> quAnsMap;

	public FeedbackDetail() {
		super();
	}

	public FeedbackDetail(String quizName, String description, LocalDate startDate, LocalDate endDate, String userName,
			String phone, String email, int age, Map<Integer, Map<String, String>> quAnsMap) {
		super();
		this.quizName = quizName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.quAnsMap = quAnsMap;
	}

	
	public FeedbackDetail(String quizName, String description, LocalDate startDate, LocalDate endDate, String userName,
			String phone, String email, int age, List<Fillin> fillinList) {
		super();
		this.quizName = quizName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.fillinList = fillinList;
	}

	public String getQuizName() {
		return quizName;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public String getUserName() {
		return userName;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public Map<Integer, Map<String, String>> getQuAnsMap() {
		return quAnsMap;
	}

	public List<Fillin> getFillinList() {
		return fillinList;
	}

}

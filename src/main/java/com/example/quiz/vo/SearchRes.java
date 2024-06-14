package com.example.quiz.vo;

import java.util.List;

import com.example.quiz.entity.Quiz;

public class SearchRes extends BasicRes {

	private List<Quiz> quizList; // 只有一個屬性就是quizList 整個quiz已經與資料庫綁定了

	public SearchRes() {
		super();
	}

	public SearchRes(int statusCode, String message, List<Quiz> quizList) {
		super(statusCode, message);
		this.quizList = quizList;
	}

	public List<Quiz> getQuizList() {
		return quizList;
	}

	public void setQuizList(List<Quiz> quizList) {
		this.quizList = quizList;
	}

}

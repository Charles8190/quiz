package com.example.quiz.vo;

public class Statistics {
	
	private int qid;
	
	private String qTitle;
	
	private boolean necessarry;
	
	private String option;
	
	private int count;

	public Statistics() {
		super();
	}

	public Statistics(int qid, String qTitle, boolean necessarry, String option, int count) {
		super();
		this.qid = qid;
		this.qTitle = qTitle;
		this.necessarry = necessarry;
		this.option = option;
		this.count = count;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public boolean isNecessarry() {
		return necessarry;
	}

	public void setNecessarry(boolean necessarry) {
		this.necessarry = necessarry;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

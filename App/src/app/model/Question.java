package app.model;

import java.util.ArrayList;

public class Question {
	private ArrayList<String> question;
	private ArrayList<String> ans1;
	private ArrayList<String> ans2;
	private ArrayList<String> ans3;
	private ArrayList<String> ans4;
	private ArrayList<Integer> sei;
	private ArrayList<String> kaisetu;
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getQuestion(int value) {
		return question.get(value);
	}
	public void setQuestion(ArrayList<String> question) {
		this.question = question;
	}
	public String getAns1(int value) {
		return ans1.get(value);
	}
	public void setAns1(ArrayList<String> ans1) {
		this.ans1 = ans1;
	}
	public String getAns2(int value) {
		return ans2.get(value);
	}
	public void setAns2(ArrayList<String> ans2) {
		this.ans2 = ans2;
	}
	public String getAns3(int value) {
		return ans3.get(value);
	}
	public void setAns3(ArrayList<String> ans3) {
		this.ans3 = ans3;
	}
	public String getAns4(int value) {
		return ans4.get(value);
	}
	public void setAns4(ArrayList<String> ans4) {
		this.ans4 = ans4;
	}
	public Integer getSei(int value) {
		return sei.get(value);
	}
	public void setSei(ArrayList<Integer> sei) {
		this.sei = sei;
	}
	public String getKaisetu(int value) {
		return kaisetu.get(value);
	}
	public void setKaisetu(ArrayList<String> kaisetu) {
		this.kaisetu = kaisetu;
	}


}

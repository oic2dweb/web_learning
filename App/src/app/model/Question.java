package app.model;


public class Question {
	private String question;
	private String ronten;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private Integer uans = 0;
	private Integer sei;
	private String kaisetu;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getRonten() {
		return ronten;
	}
	public void setRonten(String ronten) {
		this.ronten = ronten;
	}
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	public String getAns3() {
		return ans3;
	}
	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}
	public String getAns4() {
		return ans4;
	}
	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}
	public Integer getUans() {
		return uans;
	}
	public void setUans(Integer uans) {
		this.uans = uans;
	}
	public Integer getSei() {
		return sei;
	}
	public void setSei(Integer sei) {
		this.sei = sei;
	}
	public String getKaisetu() {
		return kaisetu;
	}
	public void setKaisetu(String kaisetu) {
		this.kaisetu = kaisetu;
	}


}

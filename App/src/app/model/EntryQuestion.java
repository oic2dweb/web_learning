package app.model;

public class EntryQuestion {
	private int yearid;
	private String ronten;
	private int subid;
	private String question;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private String sei;
	private String kaisetu;
	private int no;
	private int catid;
	private int mainid;
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public int getMainid() {
		return mainid;
	}
	public void setMainid(int mainid) {
		this.mainid = mainid;
	}
	public int getYearid() {
		return yearid;
	}
	public void setYearid(int yearid) {
		this.yearid = yearid;
	}
	public String getRonten() {
		return ronten;
	}
	public void setRonten(String ronten) {
		this.ronten = ronten;
	}
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
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
	public String getSei() {
		return sei;
	}
	public void setSei(String sei) {
		this.sei = sei;
	}
	public String getKaisetu() {
		return kaisetu;
	}
	public void setKaisetu(String kaisetu) {
		this.kaisetu = kaisetu;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
}

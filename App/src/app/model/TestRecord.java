package app.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestRecord {

	private Long id;
	private Date date;
	private String dateString;
	private Integer totalCount;
	private Integer correctCount;
	private Integer percentage;
	private User user;
	private int score;
	private int user_id;

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
		String dateString = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒")//
			.format(date);
		setDateString(dateString);
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getCorrectCount() {
		return correctCount;
	}
	public void setCorrectCount(Integer correctCount) {
		this.correctCount = correctCount;
	}
	public Integer getPercentage() {
		return percentage;
	}
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString(){
		return "id: " + id + "\n"
			 + "date:" + getDate().toString() + "\n"
			 + "dateString:" + getDateString() + "\n"
			 + "totalCount:" + getTotalCount() + "\n"
			 + "correctCount:" + getCorrectCount() + "\n"
			 + "percentage:" + getPercentage()+ "\n";
	}

}

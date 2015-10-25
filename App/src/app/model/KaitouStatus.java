package app.model;

public class KaitouStatus {

	private Long question_id;
	private Long uesr_id;
	private int result;
	private String time;
	private int revision;

	public Long getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}
	public Long getUesr_id() {
		return uesr_id;
	}
	public void setUesr_id(Long uesr_id) {
		this.uesr_id = uesr_id;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getReview() {
		return review;
	}
	public void setReview(int review) {
		this.review = review;
	}
	public int getRevision() {
		return revision;
	}
	public void setRevision(int revision) {
		this.revision = revision;
	}
	private int review;

}

package app.model;

public class Year {
	private int year_id;
	private String year_name;
	private int type_id;
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	private int flg;

	public int getYear_id() {
		return year_id;
	}
	public void setYear_id(int year_id) {
		this.year_id = year_id;
	}
	public String getYear_name() {
		return year_name;
	}
	public void setYear_name(String year_name) {
		this.year_name = year_name;
	}
	public int getFlg() {
		return flg;
	}
	public void setFlg(int flg) {
		this.flg = flg;
	}
}

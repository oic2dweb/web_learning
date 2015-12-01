package app.model;

public class User {

	private Long id;
	private String name;
	private String kana;
	private String student_id;
	private String password;
	private String email;
	private int class_id;

	/**
	 * idを取得します。
	 * @return id
	 */
	public Long getId() {
	    return id;
	}
	/**
	 * idを設定します。
	 * @param id id
	 */
	public void setId(Long id) {
	    this.id = id;
	}
	/**
	 * nameを取得します。
	 * @return name
	 */
	public String getName() {
	    return name;
	}
	/**
	 * nameを設定します。
	 * @param name name
	 */
	public void setName(String name) {
	    this.name = name;
	}
	/**
	 * kanaを取得します。
	 * @return kana
	 */
	public String getKana() {
	    return kana;
	}
	/**
	 * kanaを設定します。
	 * @param kana kana
	 */
	public void setKana(String kana) {
	    this.kana = kana;
	}
	/**
	 * student_idを取得します。
	 * @return student_id
	 */
	public String getStudentId() {
	    return student_id;
	}
	/**
	 * student_idを設定します。
	 * @param student_id student_id
	 */
	public void setStudentId(String student_id) {
	    this.student_id = student_id;
	}
	/**
	 * passwordを取得します。
	 * @return password
	 */
	public String getPassword() {
	    return password;
	}
	/**
	 * passwordを設定します。
	 * @param password password
	 */
	public void setPassword(String password) {
	    this.password = password;
	}
	/**
	 * emailを取得します。
	 * @return email
	 */
	public String getEmail() {
	    return email;
	}
	/**
	 * emailを設定します。
	 * @param email email
	 */
	public void setEmail(String email) {
	    this.email = email;
	}
	/**
	 * class_idを取得します。
	 * @return class_id
	 */
	public int getClassId() {
	    return class_id;
	}
	/**
	 * class_idを設定します。
	 * @param class_id class_id
	 */
	public void setClassId(int class_id) {
	    this.class_id = class_id;
	}

	@Override
	public String toString(){
		return this.name + " " + this.id + " " + this.student_id;
	}
}

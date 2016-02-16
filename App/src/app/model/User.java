package app.model;

public class User {

	private Long id;
	private String name;
	private String kana;
	private String student_id;
	private String password;
	private String email;
	private int class_id;
	private int secret_id;
	private String secret_text;
	private String url;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
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
	public String getStudent_id() {
	    return student_id;
	}
	/**
	 * student_idを設定します。
	 * @param student_id student_id
	 */
	public void setStudent_id(String student_id) {
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
	/**
	 * secret_idを取得します。
	 * @return secret_id
	 */
	public int getSecret_id() {
	    return secret_id;
	}
	/**
	 * secret_idを設定します。
	 * @param secret_id secret_id
	 */
	public void setSecret_id(int secret_id) {
	    this.secret_id = secret_id;
	}
	/**
	 * secret_textを取得します。
	 * @return secret_text
	 */
	public String getSecret_text() {
	    return secret_text;
	}
	/**
	 * secret_textを設定します。
	 * @param secret_text secret_text
	 */
	public void setSecret_text(String secret_text) {
	    this.secret_text = secret_text;
	}
}

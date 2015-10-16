package app.model;

public class User {
	
	private Long id;
	private String name;
	private String kana;
	private String username;
	private String password;
	private String email;
	private String authority;
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
	 * usernameを取得します。
	 * @return username
	 */
	public String getUsername() {
	    return username;
	}
	/**
	 * usernameを設定します。
	 * @param username username
	 */
	public void setUsername(String username) {
	    this.username = username;
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
	 * authorityを取得します。
	 * @return authority
	 */
	public String getAuthority() {
	    return authority;
	}
	/**
	 * authorityを設定します。
	 * @param authority authority
	 */
	public void setAuthority(String authority) {
	    this.authority = authority;
	}
	

	
}

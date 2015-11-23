package app.model;

public class UserTemp {

	private int id;
	private int user_id;
	private String attribute;
	private String value;
	private String url;
	/**
	 * idを取得します。
	 * @return id
	 */
	public int getId() {
	    return id;
	}
	/**
	 * idを設定します。
	 * @param id id
	 */
	public void setId(int id) {
	    this.id = id;
	}
	/**
	 * user_idを取得します。
	 * @return user_id
	 */
	public int getUser_id() {
	    return user_id;
	}
	/**
	 * user_idを設定します。
	 * @param user_id user_id
	 */
	public void setUser_id(int user_id) {
	    this.user_id = user_id;
	}
	/**
	 * attributeを取得します。
	 * @return attribute
	 */
	public String getAttribute() {
	    return attribute;
	}
	/**
	 * attributeを設定します。
	 * @param attribute attribute
	 */
	public void setAttribute(String attribute) {
	    this.attribute = attribute;
	}
	/**
	 * valueを取得します。
	 * @return value
	 */
	public String getValue() {
	    return value;
	}
	/**
	 * valueを設定します。
	 * @param value value
	 */
	public void setValue(String value) {
	    this.value = value;
	}
	/**
	 * urlを取得します。
	 * @return url
	 */
	public String getUrl() {
	    return url;
	}
	/**
	 * urlを設定します。
	 * @param url url
	 */
	public void setUrl(String url) {
	    this.url = url;
	}

}
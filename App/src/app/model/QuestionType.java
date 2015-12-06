package app.model;

public class QuestionType {
	private int id;
	private String typeName;
	private int quantity;
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
	 * typeNameを取得します。
	 * @return typeName
	 */
	public String getTypeName() {
	    return typeName;
	}
	/**
	 * typeNameを設定します。
	 * @param typeName typeName
	 */
	public void setTypeName(String typeName) {
	    this.typeName = typeName;
	}
	/**
	 * quantityを取得します。
	 * @return quantity
	 */
	public int getQuantity() {
	    return quantity;
	}
	/**
	 * quantityを設定します。
	 * @param quantity quantity
	 */
	public void setQuantity(int quantity) {
	    this.quantity = quantity;
	}
}

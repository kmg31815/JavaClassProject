package com.web.model;

/**
 * 商品種類
 */
public class ProductType {

	/**
	 * 種類ID
	 */
	private int typeId;

	/**
	 * 種類名稱
	 */
	private String typeName;

	public ProductType() {

	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "ProductType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

}

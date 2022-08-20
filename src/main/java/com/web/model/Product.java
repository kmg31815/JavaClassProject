package com.web.model;

/**
 * 商品
 */
public class Product {

	/**
	 * 商品ID
	 */
	private int productId;

	/**
	 * 商品名稱
	 */
	private String productName;

	/**
	 * 商品圖片 (存什麼 URL? 靜態檔案位置?)
	 */
	private String productImage;

	/**
	 * 商品敘述 (介紹)
	 */
	private String productDesc;

	/**
	 * 商品價格
	 */
	private int productPrice;

	/**
	 * 商品種類ID (用來對應 ProductType)
	 */
	private int typeId;

	public Product() {

	}

	public Product(String productName, String productImage, String productDesc, int productPrice, int typeId) {
		this.productName = productName;
		this.productImage = productImage;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.typeId = typeId;
	}

	public Product(int productId, String productName, String productImage, String productDesc, int productPrice,
			int typeId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.typeId = typeId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productImage=" + productImage
				+ ", productDesc=" + productDesc + ", productPrice=" + productPrice + ", typeId=" + typeId + "]";
	}

}

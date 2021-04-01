package ro.ase.acs.builder;

import java.util.Date;

public class Product {
	private String name;
	private float price;
	private long barCode;
	private int quantity;
	private Date expireDate;
	private float discount;
	private boolean isVeganFriendly;
	private boolean isVegetarianFriendly;
	private boolean isGlutenFree;
	Product(String name, float price, long barCode, int quantity, Date expireDate, float discount,
			boolean isVeganFriendly, boolean isVegetarianFriendly, boolean isGlutenFree) {
		super();
		this.name = name;
		this.price = price;
		this.barCode = barCode;
		this.quantity = quantity;
		this.expireDate = expireDate;
		this.discount = discount;
		this.isVeganFriendly = isVeganFriendly;
		this.isVegetarianFriendly = isVegetarianFriendly;
		this.isGlutenFree = isGlutenFree;
	}
	
	Product(String name, float price) {
		this.name=name;
		this.price=price;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public long getBarCode() {
		return barCode;
	}
	public void setBarCode(long barCode) {
		this.barCode = barCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public boolean isVeganFriendly() {
		return isVeganFriendly;
	}
	public void setVeganFriendly(boolean isVeganFriendly) {
		this.isVeganFriendly = isVeganFriendly;
	}
	public boolean isVegetarianFriendly() {
		return isVegetarianFriendly;
	}
	public void setVegetarianFriendly(boolean isVegetarianFriendly) {
		this.isVegetarianFriendly = isVegetarianFriendly;
	}
	public boolean isGlutenFree() {
		return isGlutenFree;
	}
	public void setGlutenFree(boolean isGlutenFree) {
		this.isGlutenFree = isGlutenFree;
	}
	
	
	public static class ProductBuilderV2 {
		private Product product;
		
		public ProductBuilderV2() {
			this.product = new Product(null,0);
		}
		
		public ProductBuilderV2 addName(String name) {
			this.product.name=name;
			return this;
		}
		
		public ProductBuilderV2 addPrice(float price) {
			this.product.price=price;
			return this;
		}
		
		public ProductBuilderV2 addQuantity(int quantity) {
			this.product.quantity=quantity;
			return this;
		}
		
	
		public ProductBuilderV2 addBarCode(long barCode) {
			this.product.barCode=barCode;
			return this;
		}
		
		public ProductBuilderV2 addDiscount(int discount) {
			this.product.discount=discount;
			return this;
		}
		
		public ProductBuilderV2 addDate(Date expireDate) {
			this.product.expireDate=expireDate;
			return this;
		}
		
		public ProductBuilderV2 addIsVeganFriendly(boolean isVeganFriendly) {
			this.product.isVeganFriendly=isVeganFriendly;
			return this;
		}
		
		
		public ProductBuilderV2 addIsVegetarianFriendly(boolean isVegetarianFriendly) {
			this.product.isVegetarianFriendly=isVegetarianFriendly;
			return this;
		}
		
		public ProductBuilderV2 addIsGlutenFree(boolean isGlutenFree) {
			this.product.isGlutenFree=isGlutenFree;
			return this;
		}
		
		public Product build() {
			return this.product;
		}
		
	
	}
	
	
	

}

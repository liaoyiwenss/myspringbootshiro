package net.wanho.pojo.vo;

import net.wanho.pojo.Product;

import java.io.Serializable;

public class ShoppingCartItem implements Serializable {

	private    Product   product;
    private     int    quantity;
    private     float     cost;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public ShoppingCartItem(Product product, Integer quantity, float cost) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.cost = cost;
	}
	
	
	
	
}

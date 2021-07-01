package jp.co.aforce.beans;

public class Items implements java.io.Serializable {
	
	private int item_id ;
	private String itemname;
	private int price;
	
	public int getItem_id() {
		return item_id;
	}
	
	public String getItemname() {
		return itemname;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}


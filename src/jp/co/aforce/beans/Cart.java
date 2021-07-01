package jp.co.aforce.beans;

public class Cart implements java.io.Serializable {
	
	private  Items items;
	private int count;
	private int total;
	
	public Items getItems() {
		return items;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getTotal() {
		return total;
	}
	
	
	public void setItems(Items items) {
		this.items = items;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
}

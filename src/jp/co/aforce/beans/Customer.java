package jp.co.aforce.beans;

public class Customer implements java.io.Serializable {

	private int main_id;
	private String username;
	private String password;
	
	public int getMain_id() {
		return main_id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setMain_id(int main_id) {
		this.main_id = main_id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}

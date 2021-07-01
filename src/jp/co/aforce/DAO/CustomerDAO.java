package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Customer;

public class CustomerDAO extends DAO {
	public Customer search(String username , String password )
	throws Exception{
		Customer customer = null;
		
		Connection con = getConnection();
		
		PreparedStatement st;
		st = con.prepareStatement("select * from users where username=? and password=?");
		st.setString(1 , username);
		st.setString(2 , password);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()){	
			customer = new Customer();
			customer.setMain_id(rs.getInt("main_id"));
			customer.setUsername(rs.getString("username"));
			customer.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		return customer;
	}
	
}

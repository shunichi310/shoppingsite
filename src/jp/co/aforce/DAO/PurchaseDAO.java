package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import jp.co.aforce.beans.Cart;
import jp.co.aforce.beans.Items;

public class PurchaseDAO extends DAO {
	public boolean insert(List<Cart> cart , String name , String address)
	throws Exception{
		Connection con = getConnection();
		con.setAutoCommit(false);
		
		for (Cart c : cart) {
			PreparedStatement st = con.prepareStatement(
				"insert into purchase values(null,?,?,?,?,?,?)");
			Items i = c.getItems();
			st.setInt(1, i.getItem_id());
			st.setString(2, i.getItemname());
			st.setInt(3, i.getPrice());
			st.setInt(4, c.getCount());
			st.setString(5, name);
			st.setString(6, address);
			int line = st.executeUpdate();//処理済みのSQL文（検索系SQL以外のSQL文）を実行し，「更新行数」を返却。
			st.close();
			
			if(line != 1) {
				con.rollback();
				con.setAutoCommit(true);
				con.close();
				
				return false;
			}
		}
		
		con.commit();
		con.setAutoCommit(true);
		con.close();
		return true;
		
		
	}

}

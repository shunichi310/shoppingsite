package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.Items;

public class ShowItemsDAO extends DAO {
	public List<Items> show() throws Exception{
		List<Items> items = new ArrayList<>();
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("select * from items");
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) { //リストの理解不十分
			Items i = new Items();//BeanのItemsのインスタンス化
			i.setItem_id(rs.getInt("item_id"));
			i.setItemname(rs.getString("itemname"));
			i.setPrice(rs.getInt("price"));
			items.add(i);//リストの「items」にiに格納されたデータをぶち込む
		}
		
		st.close();
		con.close();
		return items;//リストの「items」をメソッドの呼び出し元に返す
	}
}

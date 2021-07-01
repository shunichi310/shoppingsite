package jp.co.aforce.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Cart;
import jp.co.aforce.beans.Items;

public class CartAddAction extends SuperAction {
	
	@Override
	public String execute(HttpServletRequest request , HttpServletResponse response)throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("id"));
		//int price = Integer.parseInt(request.getParameter("price"));//＊追加
		//System.out.println(id);
		
		List<Cart> cart=(List<Cart>)session.getAttribute("cart");
			//データ型名→Cart→参照型→オブジェクトの生成（インスタンス化）が必要。
		if(cart == null) {
			cart=new ArrayList<Cart>();
			session.setAttribute("cart", cart);//セッションの値に「cart」を入れる。場所変
		}
		
		for (Cart c : cart) {//cはリスト「cart」から取り出したデータを入れる変数。
			if(c.getItems().getItem_id()==id) {
				c.setCount(c.getCount()+1);
				//c.setTotal(c.getTotal()+c.getItems().getPrice());//＊追加
				
				return "cart.jsp";
			}
		}
		
		List<Items> items = (List<Items>)session.getAttribute("items");
		//System.out.println(items);
		for(Items i : items) {
			if(i.getItem_id()==id) {
				Cart c = new Cart();
				c.setItems(i);
				c.setCount(1);
				//c.setTotal(i.getPrice());
				cart.add(c);
			}
		}
		return "cart.jsp";
		
	}

	
}

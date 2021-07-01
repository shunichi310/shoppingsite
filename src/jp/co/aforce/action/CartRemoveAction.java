package jp.co.aforce.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Cart;

public class CartRemoveAction extends SuperAction  {
	public String execute(HttpServletRequest request , HttpServletResponse response)
	throws Exception{
		
		HttpSession session = request.getSession();
		
		int item_id = Integer.parseInt(request.getParameter("id"));
		
		List<Cart> cart = (List<Cart>)session.getAttribute("cart");
		
		for(Cart c : cart) { //「c」はcartビーンズのインスタンス
			if(c.getItems().getItem_id() == item_id){
				cart.remove(c);//remove:List型の要素を削除するためのメソッド。指定した要素を1つだけ削除する。
				break;
			}
		}
		
		return "cart.jsp";
		
	}

}

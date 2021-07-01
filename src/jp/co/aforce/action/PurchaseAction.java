package jp.co.aforce.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.DAO.PurchaseDAO;
import jp.co.aforce.beans.Cart;

public class PurchaseAction extends SuperAction{
	
	public String execute(HttpServletRequest request ,  HttpServletResponse response)
	throws Exception{
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		if(name.isEmpty() || address.isEmpty()) {
			return "purchase-error-empty.jsp";
		}
		
		//カートの中身が無いのに購入ボタンを押してしまったとき
		List<Cart> art = (List<Cart>)session.getAttribute("cart");
		if(art==null || art.size()==0) {                          
		return "purchase-error-emptycart.jsp";
		}
		
		
		PurchaseDAO dao = new PurchaseDAO();
		List<Cart> cart = (List<Cart>)session.getAttribute("cart");
		if(cart == null || !dao.insert(cart, name, address)) {
			return "purchase-error-insert.jsp";
		}
		
		session.removeAttribute("cart");
		return "purchasesuccess.jsp";
		
	}

}

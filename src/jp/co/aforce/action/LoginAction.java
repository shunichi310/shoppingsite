package jp.co.aforce.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.DAO.CustomerDAO;
import jp.co.aforce.DAO.ShowItemsDAO;
import jp.co.aforce.beans.Customer;
import jp.co.aforce.beans.Items;

public class LoginAction extends SuperAction{
	public String execute(HttpServletRequest request , HttpServletResponse response)
	throws Exception{
		
		request.setCharacterEncoding("UTF-8");//requestにサーバーに送るデータの文字コードを設定
		response.setContentType("text/html; charset=UTF-8");//ウェブブラウザに送るデータの文字コードを設定
		HttpSession session = request.getSession();//セッション開始、セッションIDがクッキーに保存される
		
		String username = request.getParameter("username");//リクエストパラメータの「名前」から「値」を取得
		String password = request.getParameter("password");
		
		//if(username == "satoshunichi" & password == "shunichisato") {
			
		//}
		
		CustomerDAO dao = new CustomerDAO();
		Customer customer = dao.search(username , password);//CustomerDAOクラスのsearchメソッド呼び出し、結果はcustomerに
		
		if(customer != null) {
			
			ShowItemsDAO dao_items = new ShowItemsDAO();
			List<Items> items = dao_items.show();//ShowItemsDAOクラスのshowメソッドを呼び出し＆結果を「items」に
			//System.out.println(items);
			
			request.setAttribute("items" , items);
			session.setAttribute("items" , items);
			session.setAttribute("customer", customer);
			return "showitems.jsp";	//returnに続けて記述している内容を「戻り値」として呼び出し元に返却
		}
		return "login-error.jsp";
	}
}

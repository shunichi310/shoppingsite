package jp.co.aforce.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends SuperAction {
	public String execute(HttpServletRequest request , HttpServletResponse response)
	throws Exception{
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("customer")!=null) {
			session.removeAttribute("customer");
			return "logout.jsp";
		}
		
		return "logout-error.jsp";
		
	}

}

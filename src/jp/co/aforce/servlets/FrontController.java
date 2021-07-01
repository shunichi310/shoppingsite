package jp.co.aforce.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.action.SuperAction;

@WebServlet(urlPatterns = {"*.action"})
public class FrontController extends HttpServlet {
	
	public void doPost(HttpServletRequest request , HttpServletResponse response)
	throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//System.out.println(request);
		try {
			String path = request.getServletPath().substring(1); 
			//System.out.println(path);
			String name ="jp.co.aforce.action." +path.replace(".a" , "A").replace('/' , '.');
			SuperAction action = (SuperAction)Class.forName(name).getDeclaredConstructor().newInstance();
			String url = "views/"+action.execute(request , response); 
			//System.out.println(url);
			request.getRequestDispatcher(url).forward(request, response);
					//フォワード先のURL
		}
		catch(Exception e) {
			e.printStackTrace(out);
		}
	}
		
	public void doGet(HttpServletRequest request , HttpServletResponse response)//ゲットリクエストを受け取って、doPostメソッドで処理する。
	throws ServletException , IOException{
		doPost(request , response);
	}
	
}

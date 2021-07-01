package jp.co.aforce.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class SuperAction {
	public abstract String execute(
		HttpServletRequest request , HttpServletResponse response)
	throws Exception;
}

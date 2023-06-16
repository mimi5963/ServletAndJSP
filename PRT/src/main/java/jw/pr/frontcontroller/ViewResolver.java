package jw.pr.frontcontroller;

public class ViewResolver {
	
	private static String prefix="/WEB-INF/member/";
	private static String postfix=".jsp";
	
	public static String getPath(String viewname) {
		return prefix+viewname+postfix;
	}
}

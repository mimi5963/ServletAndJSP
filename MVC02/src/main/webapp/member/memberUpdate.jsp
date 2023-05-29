<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import ="kr.bit.model.*" %>

<% 
request.setCharacterEncoding("utf-8");
//파라미터 수집 4개
int num = Integer.parseInt(request.getParameter("num"));
int age = Integer.parseInt(request.getParameter("age"));
String email = request.getParameter("email");
String phone = request.getParameter("phone");

MemberVO modify = new MemberVO();
modify.setNum(num);
modify.setAge(age);
modify.setEmail(email);
modify.setPhone(phone);

MemberDAO dao = new MemberDAO();
int cnt = dao.MemberUpdate(modify);

if(cnt>0) { //업데이트 성공 
	response.sendRedirect("memberList.jsp"); //리스트로 돌아가기
	 //DB 서버 실행되있어야함
}else {//업데이트 실패
	throw new ServletException("not update");
}


%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>
<% 
	request.setCharacterEncoding("utf-8");
	//파라메터 정보 수집해서 VO객체에 집어넣고, DAO로 넘기자.
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	
	MemberVO vo =new MemberVO(id,pass,name,age,email,phone);
	
	MemberDAO dao = new MemberDAO();
	int cnt = dao.memberInsert(vo);
	if(cnt>0){
		response.sendRedirect("memberList.jsp");
	}else{
		
		throw new ServletException("not insert");
	}


%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
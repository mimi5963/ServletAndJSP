<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="kr.bit.model.*" %>
<% 
	  
    MemberVO vo = (MemberVO)request.getAttribute("vo");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
컨트롤러에서 받은 값은:
<div>
	<label>이름</label>
	 <%=vo.getName() %>
</div>
<div>
<label>나이</label>
	 <%=vo.getAge() %>
</div>
<div>
<label>이메일</label>
	 <%=vo.getEmail() %>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="kr.bit.model.*" %>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

MemberVO vo = new MemberVO();
vo.setAge(10);
vo.setEmail("1234");
vo.setName("나길동");
request.setAttribute("vo",vo);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<td>나이</td>
<td>이메일</td>
<td>이름</td>
</tr>
<tr>
<td>${vo.age}</td>
<td>${vo.email}</td>
<td>${vo.name}</td>
</tr>

</table>
</body>
</html>
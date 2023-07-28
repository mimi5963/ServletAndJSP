<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="kr.bit.model.*" %>
<%@ page import ="java.util.*" %>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

MemberVO vo = new MemberVO();
vo.setAge(10);
vo.setEmail("aaa@aass");
vo.setName("김펭귄");
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
<td>${vo.num}</td>
<td>${vo.age}</td>
<td>${vo.email}</td>
<td>${vo.name}</td> 
</tr>

<tr>
<td>${vo.getNum}</td>
<td>${vo.getAge()}</td>
<td>${vo.getEmail()}</td>
<td>${vo.getName()}</td> 
</tr>

</table>
</body>
</html>
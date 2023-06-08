<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="kr.bit.model.*" %>
<%@ page import ="java.util.*" %>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

MemberVO vo = new MemberVO();
vo.setAge(10);
vo.setEmail("1234");
vo.setName("나길동");
request.setAttribute("vo",vo);

List<MemberVO> list = new ArrayList<>();
list.add(vo);
list.add(vo);
list.add(vo);
list.add(vo);
list.add(vo);

request.setAttribute("list",list);

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

<c:forEach var ="vo" items="${list}">
<tr>
<td>${vo.num}</td>
<td>${vo.age}</td>
<td>${vo.email}</td>
<td>${vo.name}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
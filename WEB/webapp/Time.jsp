<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   java.util.Date d = new java.util.Date();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
뭘 보러 오셨나요 (동적인페이지)<br>
 지금 시간이 몇시일까요? <%=d.toString() %>>
</body>
</html>
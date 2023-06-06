<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="kr.bit.model.*" %>
<%@ page import ="java.util.ArrayList" %>
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
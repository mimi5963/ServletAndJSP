<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="kw.pr.model.*" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="kr">
  <head>
  <script type="text/javascript">
  function deletefunc(num){
	  location.href="${ctx}/memberDelete.do?num="+num;
  }
 
  </script>
  
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>회원정보</title>
  </head>
  <body>
    <table border="2">
      <thead>
        <th>번호</th>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>나이</th>
        <th>이메일</th>
        <th>전화번호</th>
        <th>삭제<th>
      </thead>
	<c:forEach var="vo" items="${list}">
		<tr>
		<td>${vo.num}</td>
		<td><a href="${ctx}/memberContent.do?num=${vo.num}">${vo.id}</a></td>
		<td>${vo.pass}</td>
		<td>${vo.name}</td>
		<td>${vo.age}</td>
		<td>${vo.email}</td>
		<td>${vo.phone}</td>
		<td><input type="button" value="삭제" onclick="deletefunc(${vo.num})"></td>
		</tr>
	</c:forEach>
	<tr>
	<td colspan='8' align='right'>
	<input type="button" value="회원가입" onclick="location.href='${ctx}/memberRegister.do'">
    </td>
    </tr>
    </table>
    
     
  </body>
</html>

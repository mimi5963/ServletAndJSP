<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import ="kr.bit.model.*" %> 
 <%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
 
	//MemberVO mem_inf = (MemberVO)request.getAttribute("mem_inf");
 	
 %>
 <c:set var ="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${ctx}/memberUpdate.do" method="post">
		
		<input type="hidden" name="num" value="${mem_inf.num}" />
		<table>
		<tr>
		</tr>
		<c:if test="${mem_inf !=null}">
			
			<tr>
			<td colspan='2'>${mem_inf.name}회원의 상세보기</td>
			</tr>
			
			<tr>
			<td>번호</td>
			<td>${mem_inf.num}</td>
			</tr>
			
			<tr>
			<td>아이디</td>
			<td>${mem_inf.id}</td>
			</tr>
			
			<tr>
			<td>비밀번호</td>
			<td>${mem_inf.pass}</td>
			</tr>
			
			<tr>
			<td>이름</td>
			<td>${mem_inf.name}</td>
			</tr>
			
			<tr>
			<td>나이</td>
			<td><input type="text" name="age" value="${mem_inf.age}"></td>
			</tr>
			
			<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="${mem_inf.email}"></td>
			</tr>
			
			<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone" value="${mem_inf.phone}"></td>
			</tr>
			
		</c:if>
		
		<tr>
		<td colspan='2' align='center'>
		<input type= 'submit' value='수정'/>
		<input type= 'reset' value='취소'/>
		<input type="button" value="돌아가기" onclick="location.href='${ctx}/memberList.do'"/>
		</td>
		<tr>
		</table>
		</form>

</body>
</html>
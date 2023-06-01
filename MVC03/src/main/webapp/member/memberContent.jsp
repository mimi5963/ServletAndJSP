<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import ="kr.bit.model.*" %> 
 <%
    
 
	
	MemberVO mem_inf = (MemberVO)request.getAttribute("mem_inf");
 	

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="memberUpdate.do" method="post">
		
		<input type="hidden" name="num" value="<%=mem_inf.getNum()%>" />
		<table>
		<tr>
		</tr>
		<% if(mem_inf != null) { %>
			
			<tr>
			<td colspan='2'><%= mem_inf.getName()%>회원의 상세보기</td>
			</tr>
			
			<tr>
			<td>번호</td>
			<td><%=mem_inf.getNum()%></td>
			</tr>
			
			<tr>
			<td>아이디</td>
			<td><%=mem_inf.getId()%></td>
			</tr>
			
			<tr>
			<td>비밀번호</td>
			<td><%=mem_inf.getPass()%></td>
			</tr>
			
			<tr>
			<td>이름</td>
			<td><%=mem_inf.getName()%></td>
			</tr>
			
			<tr>
			<td>나이</td>
			<td><input type="text" name="age" value="<%=mem_inf.getAge() %>"></td>
			</tr>
			
			<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="<%=mem_inf.getEmail()%>"></td>
			</tr>
			
			<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone" value="<%=mem_inf.getPhone()%>"></td>
			</tr>
			
		<% }else { %>
			<tr>
			<td> 일치하는 회원이 없습니다. </td>
			</tr>
		<% } %>
		<tr>
		<td colspan='2' align='center'>
		<input type= 'submit' value='수정'/>
		<input type= 'reset' value='취소'/>
		<input type="button" value="돌아가기" onclick="location.href='/MVC03/memberList.do'"/>
		</td>
		<tr>
		</table>
		</form>

</body>
</html>
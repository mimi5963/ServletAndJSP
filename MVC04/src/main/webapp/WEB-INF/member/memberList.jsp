<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "kr.bit.model.*" %>
 <%@ page import = "java.util.ArrayList" %>   
 <%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <% 
 	//ArrayList<MemberVO> memberlist = (ArrayList<MemberVO>)request.getAttribute("mlist");
 
 %>   
  <c:set var ="ctx" value="${pageContext.request.contextPath}"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type ="text/javascript">
	function deleteFn(num){
		location.href ="${ctx}/memberDelete.do?num="+num;
	}

</script>
</head>
<body>
<table border ='1'>
		<thead>
		<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>삭제</th>
		</tr>
		</thead>
		<tbody>
	<c:forEach var="m" items="${mlist}">
		    <tr>
		    <td>${m.num}</td>
		    <td><a href="${ctx}/memberContent.do?num=${m.num}">${m.id}</a></td>
		    <td>${m.pass}</td>
		    <td>${m.name}</td>
		    <td>${m.age}</td>
		    <td>${m.email}</td>
		    <td>${m.phone}</td>
		    <td><input type="button" value="삭제" onclick="deleteFn(${m.num})"</td>
		    </tr>
		</c:forEach>
		</tbody>
		<tr>
		<td colspan='8' align='right'>
		<input type ="button" value="회원가입" onclick="location.href ='${ctx}/memberRegister.do'">
		</td>	
		</tr>
		</table>
		
</body>
</html>
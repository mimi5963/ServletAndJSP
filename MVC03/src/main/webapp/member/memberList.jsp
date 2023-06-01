<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "kr.bit.model.*" %>
 <%@ page import = "java.util.ArrayList" %>   
 
 <% 
 	ArrayList<MemberVO> memberlist = (ArrayList<MemberVO>)request.getAttribute("mlist");
 
 %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type ="text/javascript">
	function deleteFn(num){
		location.href ="memberDelete.do?num="+num;
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
		<% for(MemberVO m : memberlist) { %>
		    <tr>
		    <td><%=m.getNum()%></td>
		    <td><a href="memberContent.do?num=<%=m.getNum()%>"><%=m.getId() %></a></td>
		    <td><%=m.getPass() %></td>
		    <td><%=m.getName() %></td>
		    <td><%=m.getAge() %></td>
		    <td><%=m.getEmail() %></td>
		    <td><%=m.getPhone() %></td>
		    <td><input type="button" value="삭제" onclick="deleteFn(<%=m.getNum() %>)"</td>
		    </tr>
		<% }%>
		</tbody>
		<tr>
		<td colspan='8' align='right'>
		<input type ="button" value="회원가입" onclick="location.href ='member/memberRegister.html'">
		</td>	
		</tr>
		</table>
		
</body>
</html>
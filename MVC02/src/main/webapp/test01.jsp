<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import = "kr.bit.model.*" %>
   <%@include file = "test02.jsp" %>
   <%-- 주석 --%>
   
   <%! 
   public int hap(int s, int e){
	   int sum=0;
	   for(int i=s; i<=e ;i++) sum+=i;
	   return sum;
   }
   
   %> 
   
    <% int sum =0;
    	
    for(int i=1; i<=10 ;i++) sum+=i;
   	
 	int mysum = hap(1,10);
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>
<%= mysum %>
</td>
</tr>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="kw.pr.model.*" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="kr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>회원상세정보</title>
  </head>
  <body>
    <form action="${ctx}/memberUpdate.do" method="post">
      <input type="hidden" value="${member.num}" name="num">
      <table border="2">
        <c:if test="${member !=null}">
        <tr>
          <td>번호:</td>
          <td>${member.num}</td>
        </tr>
        <tr>
          <td>아이디:</td>
          <td>${member.id}</td>
        </tr>
        <tr>
          <td>비밀번호:</td>
          <td>${member.pass}</td>
        </tr>
        <tr>
          <td>이름:</td>
          <td>${member.name}</td>
        </tr>
        <tr>
          <td>나이:</td>
          <td><input type="text" value="${member.age}" name="age"/></td>
        </tr>
        <tr>
          <td>이메일:</td>
          <td><input type="text" value="${member.email}" name="email"/></td>
        </tr>
        <tr>
          <td>전화번호:</td>
          <td><input type="text" value="${member.phone}" name="phone"/></td>
        </tr>
        </c:if>
      </table>
      <input type="submit" value="수정하기" />
      <input type="reset" value="취소하기" />
      <input type="button" value="돌아가기" onclick="location.href='${ctx}/memberList.do'" />
    </form>
  </body>
</html>

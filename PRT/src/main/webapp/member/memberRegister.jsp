<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>회원가입</title>
  </head>
  <body>
    <form action="/PRT/memberInsert.do" method="post">
    <table border="2">
      <tr>
       <td>id:<input type="text" name="id"></td> 
      </tr>
      <tr>
      <td>pass:<input type="text" name="pass"></td> 
      </tr>
      <tr>
      <td>name:<input type="text" name="name"></td> 
      </tr>
      <tr>
      <td>age:<input type="text" name="age"></td> 
      </tr>
      <tr>
      <td>email:<input type="text" name="email"></td> 
      </tr>
      <tr>
      <td>phone:<input type="text" name="phone"></td> 
      </tr>
    </table>
      <input type="submit" value="회원가입"/>
      <input type="reset" value="취소"/>
      <input type="button" value="돌아가기" onclick="location.href='/PRT/memberList.do'"/>
  </form>
  </body>
</html>

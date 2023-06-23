<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>    
<%
  // MemberVO vo=(MemberVO)request.getAttribute("vo");
%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>
<script type="text/javascript">
   function update(){
	  //document.form1.action="<c:url value='/memberUpdate.do'/>"; 
	  //document.form1.submit();
	  
	   if($('#file').val() !=''){ //파일첨부 o
   			
  		 var formData = new FormData();
  	 		formData.append("file",$("input[name=file]")[0].files[0]);
  	 		
  	 		$.ajax({
  	 			
  	 			url : "<c:url value='/fileAdd.do'/>",
  	 			type : "post",
  	 			data : formData,
  	 			processData : false, //form데이터 넘길때는 (text같은거말고) 여기에 false해야한대
  	 			contentType : false, //return 값? 파일 업로드 후 return 받을 값이래 
  	 			success : function(data){ //업로드된 실제파일 이름 전달받기 db에 파일이름 저장할 것
  	 				
  	 				//alert(data);
  	 				
  	 				$("#filename").val(data); //id filename 속성 만들고 파일 첨부로 이름 초기화 한 뒤 submit할떄 같이 넘어가게 하기
  	 				document.form1.action="<c:url value='/memberUpdate.do'/>?mode=fupdate"; 
  	 		    	document.form1.submit(); //text데이터 저장 - 서버에 
  	 				//파일이름 포함 submit
  	 			},
  	 			error: function(){alert("error");}
  	 			
  	 			
  	 		});
  	 		
  	 		
  	 }else { //파일첨부 x
  		        document.form1.action="<c:url value='/memberUpdate.do'/>?mode=update"; 
		    	document.form1.submit(); //파일이름 없이 insert됨! 
  		 
  	 }
	    
   }
   
   function frmreset(){
	  document.form1.reset();
   }
   
   
   
   
   function getFile(filename){
		
	   location.href="<c:url value='/fileGet.do'/>?filename="+filename;
   }

   
   function delFile(num,filename){
	   alert("hi");
	   location.href="<c:url value='/fileDel.do'/>?num="+num+"&filename="+filename;
   }
   

  
   
   
</script>
</head>
<body>
<div class="container">
  <h2>상세화면</h2>
  <div class="panel panel-default">
    <div class="panel-heading">
     <c:if test="${sessionScope.userId!=null && sessionScope.userId!='' && sessionScope.userId==vo.id}">
       <label>
       <img src="<c:out value='file_repo/${vo.filename}'/> " width="60px" height="60px" />
       ${sessionScope.userName}님이 로그인 하셨습니다.
       </label>
     </c:if>
     <c:if test="${sessionScope.userId==null || sessionScope.userId==''}">
      <label>안녕하세요</label>
     </c:if>   
    </div>
    <div class="panel-body">
    <form id="form1" name="form1" class="form-horizontal" method="post">
      <input type="hidden" name="num" value="${vo.num}"/>
      <input type="hidden" name="filename" value="" id="filename"/>
      <div class="form-group">
         <label class="control-label col-sm-2">번호:</label>
         <div class="col-sm-10">
           <c:out value="${vo.num}"/>
         </div>
      </div>   
      <div class="form-group">
         <label class="control-label col-sm-2">아이디:</label>
         <div class="col-sm-10">
           <c:out value="${vo.id}"/>
         </div>
      </div> 
       <div class="form-group">
         <label class="control-label col-sm-2">비밀번호:</label>
         <div class="col-sm-10">
           <c:out value="${vo.pass}"/>
         </div>
      </div>  
       <div class="form-group">
         <label class="control-label col-sm-2">이름:</label>
         <div class="col-sm-10">
           <c:out value="${vo.name}"/>
         </div>
      </div> 
       <div class="form-group">
         <label class="control-label col-sm-2">나이:</label>
         <div class="col-sm-10">
           <input type="text" class="form-control" id="age" name="age" value="${vo.age}" style="width: 10%">
         </div> 
      </div> 
       <div class="form-group">
         <label class="control-label col-sm-2">이메일:</label>
         <div class="col-sm-10">
           <input type="text" class="form-control" id="email" name="email" value="${vo.email}" style="width: 30%">
         </div>
      </div> 
       <div class="form-group">
         <label class="control-label col-sm-2">전화번호:</label>
         <div class="col-sm-10">
           <input type="text" class="form-control" id="phone" name="phone" value="${vo.phone}" style="width: 30%">
         </div>
      </div> 
     
     <div class="form-group">
         <label class="control-label col-sm-2">첨부파일:</label>
         <div class="col-sm-10">
           <input type="file" id="file" name="file">
           <c:if test="${vo.filename !=null && vo.filename !='' }">
           <a href="javascript:getFile('${vo.filename}')"><c:out value="${vo.filename}"/></a>
           </c:if>
         	
         	<c:if test="${sessionScope.userId != null && sessionScope.userId == vo.id && vo.filename != null && vo.filename != ''}">
         		<a href="javascript:delFile('${vo.num}','${vo.filename}')"><span class="glyphicon glyphicon-remove">x</span></a>
         	</c:if>
         </div>
      </div> 
     </form>
    </div>
    <div class="panel-footer" style="text-align: center;"> 
       <c:if test="${!empty sessionScope.userId}">
         <c:if test="${sessionScope.userId==vo.id}">
          <input type="button" value="수정하기" class='btn btn-primary' onclick="update()"/>
         </c:if>
       
         <c:if test="${sessionScope.userId!=vo.id}">
          <input type="button" value="수정하기" class='btn btn-primary' onclick="update()" disabled="disabled"/>
         </c:if> 
       </c:if> 
       <input type="button" value="취소" class='btn btn-warning' onclick="frmreset()"/>
       <input type="button" value="리스트" onclick="location.href='${ctx}/memberList.do'" class='btn btn-success'/>
    </div>
  </div>
</div>
</body>
</html>
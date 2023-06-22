package kr.bit.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileAddController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String Upload_DIR="file_repo"; // 파일디렉토리 (서버 안에 업로드된 파일 저장)
		String uploadPath = request.getServletContext().getRealPath("")+File.separator+Upload_DIR; 
		//하드웨어 물리적인 경로의미 separator은 파일 구분자 운영체제에 맞는
		File currentDirPath=new File(uploadPath); //업로드 경로 File 객체로 만들기
		if(!currentDirPath.exists()) {
			currentDirPath.mkdir();
		}
		// 여기까지는 업로드된 파일을 저장할 서버 디렉토리 만든 것 (디렉토리만 만듦)
		
		//클라이언트가 파일 업로드시, 파일의 크기가 너무 크면 JVM이 메모리에 모두 저장하기 부담
		//그래서 임시 디렉토리에 저장함 ->그리고 이를 다시 새로운 디렉토리에 쓰는 2단계과정 거침 (실제 dir로가면서 임시 비워짐)
		//우리가 할 방법은 임시와 실제가 같은 것
		
		
		//파일을 업로드 할때 먼저 저장될 임시 저장경로 설정 (실제 이곳으로 업로드 파일 저장하라고 설정하는 부분)
		//위의 일을 해주는 것은 파일 업로드시 도움주는 API임 (외부에서받자) (commons-fileupload, commons-io)(mvnrepository)
		DiskFileItemFactory  factory = new DiskFileItemFactory();
		//파일을 여러개 저장할 수 있는 공간임 이런걸 종종 Factory라고함 
		//임시저장 메모리 공간
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		
	    String fileName = null;
	    
	    //request에 담긴 업로드될 파일 쉽게 factory위치에 저장하기 위한 객체
		ServletFileUpload upload = new ServletFileUpload(factory); //임시저장공간 지정
		
		//이제야 실제 파일 읽음 
		try {
		List<FileItem> items=upload.parseRequest(request);//request안에 업로드될 파일 정보 쉽게 얻게해줌 
		//request안에 여러개의 파일이 업로드된 경우.. 여러 파일의 정보를 담은 items list를 반환
		//request에 담긴 파일+파라미터 정보
		//배열로 fileitem[] ->fileitem[], fileitem[] 파일하나의 정보들이 들어있다.
		//근데 FileItem에 담길 수 있는 값이 꼭 업로드 파일 뿐아니라.. form파일(얘도 파일이네)에 객체 하나하나 (id,이름) 등등도 
		//하나의 fileitem으로 넘어온다.
		 for(int i=0;i<items.size();i++) {
			 FileItem fileitem = items.get(i);
			 //저장된 정보가 file인지 파라미터인지 구분할 필요 있음
			 //지금은 ajax로 file을 넘기지만, 그냥 request에 file이 담겨서 넘어올 수 도 있는 것
			 //따라서 검사해볼 필요가 있다.
			 if(fileitem.isFormField()) {//폼필드면
				 System.out.println(fileitem.getFieldName()+"="+fileitem.getString("utf-8"));
				 //파일이 아닌.. 필드 id같은거 출력해라
			 }else {//파일이면
				 if(fileitem.getSize()>0) {
					 //(factory 임시저장소를 이용해 upload(request에 파일읽기)객체 만들어졌고, upload로 items만들어짐 
					 //items안에 -> fileItem이므로 .getName()하면 하드웨어 full path(임시저장소) 파일명만 똑 
					 //uploadFile(실제 저장 dir) 임시저장소+"\\"+fileName으로 저장하겠다!
					 //fileitem객체를 uploadfile의 경로(이름)으로 실제 저장한다..
					 int idx = fileitem.getName().lastIndexOf("\\"); // 윈도우로 저장시 \\
					 if(idx==-1) {
						 idx = fileitem.getName().lastIndexOf("/");
					 }
					 fileName = fileitem.getName().substring(idx+1);
					 //ex c:\gogo\fam30.1\bin\sql.txt 가 realPath라면 앞에 \찾아서 그 뒤부터.. 파일명 찾기
					 File uploadFile = new File(currentDirPath+"\\"+fileName);
					 //currentDir에 \file.name 일케 저장
					 
					 //파일명 중복체크 후 이름 바꾸기
					 if(uploadFile.exists()) {
						 fileName=System.currentTimeMillis()+"_"+fileName;
						 uploadFile = new File(currentDirPath+"\\"+fileName);
					 }
					 fileitem.write(uploadFile); //임시경로 -> 새로운경로에 파일 쓰기
					 //file객체 이용해서 create한다음 내용 덮어쓰기까지
				 }
				 
			 }
		 }	
		
		}catch(Exception e) {e.printStackTrace();}
		
		// $.ajax()쪽으로 업로드된 최종 파일명 전송
		response.setContentType("text/html;charset=euc-kr");
		response.getWriter().print(fileName);
		return null;
	}

}

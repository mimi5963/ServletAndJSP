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

public class MemberfileAddController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //여기가 중하지 
		 
		System.out.println(request.getServletContext().getRealPath(""));
		
		//1.파일을 저장할 디렉또리 만들기
		String upload_dir = "file_repo";
		String uploadPath= request.getServletContext().getRealPath("")+File.separator+upload_dir;
		//File 객체얻기위한 절대경로
		File currentdir = new File(uploadPath);
		if(!currentdir.exists()) { currentdir.mkdir(); }
		
		//2. 임시저장용 디렉또리 만들기
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentdir);
		factory.setSizeThreshold(1024*1024);
		String fileName = null;
		
		//3. request에서 파일 데이터 꺼내오기
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			//request에 파라미터와 파일을 Fileitem객체 배열로 만들어서 리턴 
			List<FileItem> items = upload.parseRequest(request);
			
			//request로 넘어온 파일이 여러개일 수도 있고, 파일 아닌 파라미터 구별해야함
			for(int i=0; i<items.size();i++) {
				FileItem fitem = items.get(i);
				
				//파일이 아니면
				if(fitem.isFormField()) {
					
					System.out.println(fitem.getFieldName()+"="+fitem.getString("utf-8"));
				
				}else {
					//파일이면, 
					if(fitem.getSize()>0) {
						//파일 절대 경로에서 파일 이름만 가져오기
						int idx = fitem.getFieldName().lastIndexOf(File.separator);
						fileName = fitem.getFieldName().substring(idx+1);
                        
						//실제 저장 경로 및 파일명 설정
						File uploadFile = new File(currentdir+File.separator+fileName);
						
						//파일이름 중복확인
						if(uploadFile.exists()) {
							fileName = System.currentTimeMillis()+"_"+fileName;
						    uploadFile = new File(currentdir+File.separator+fileName);
						}
						fitem.write(uploadFile); //파일 쓰기
					}
					
				}
			}
			
			
			
		}catch(Exception e) {e.printStackTrace();}
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(fileName);
		
		return null;
	}

}

package kr.bit.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

public class FileDelController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String filename = request.getParameter("filename");
		int num = Integer.parseInt(request.getParameter("num"));
		filename = URLEncoder.encode(filename,"UTF-8");
		filename = filename.replace("+", " ");
		System.out.println(filename);
		//dir경로 + 삭제할 파일 연결 
		String Dir = "file_repo";
		String uploadDirPath= request.getServletContext().getRealPath("")+File.separator+Dir;
		File file = new File(uploadDirPath+File.separator+filename);
		
		if(file.exists()) {
			file.delete();
			System.out.println("디렉토리에서 파일 삭제");
		}
		//테이블에서 파일 null처리 update
		MemberDAO dao = new MemberDAO();
		dao.memberDeleteFile(num);
		
		String ctx = request.getContextPath();
		
		return "redirect:"+ctx+"/memberContent.do?num="+num;
	}

	
	
}

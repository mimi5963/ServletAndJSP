package kr.bit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileGetController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename = request.getParameter("filename");
		System.out.println(filename);
		//절대경로 가져오기
		String UPLOAD_DIR ="file_repo";
		String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
		
		//절대경로로 file찾아서 file객체 만들기 왜 두번하냐? 뭐 몰라 
		File f = new File(uploadPath+File.separator+filename);
		
		filename=URLEncoder.encode(filename,"UTF-8");
		//클라이언트로부터 넘어오는 파일이름에 한글이 있는경우 깨지지 않게하기 위함
		filename = filename.replace("+", " ");
		//크롬에서 파일명 공백을 +연결하는 경우아 있어서 처리한 것 
		
		
		//서버에서 클라이언트에게 다운로드 준비를 시키는 과정 (다운로드 창띄우기)
		//다운로드준비 클라이언트한테 뭐 몰라 일단 내 로컬로 다운받는다고?
		//일단 응답할때 알려줌 클라이언트한테 크기가 얼마인지 
		response.setContentLength((int)f.length());
		response.setContentType("application/x-msdownload;charset=utf-8");
		//다운로드 화면 
		response.setHeader("Content-Disposition", "attachment;filename="+filename+";");
		//attachment ->다운로드 파일 이름 보이게하기 
		//밑에 처럼 response에 대한 설정을 계속해줌 파일 내려보내기 위해 
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		//실제 다운로드 
		FileInputStream fis = new FileInputStream(f); //소스 and 스트림 
		OutputStream out = response.getOutputStream();//이런식으로 스트림 얻으면 보통 인/아웃 소스가 객체가됨
		byte[] buffer = new byte[1024];
		int size;
		while((size = fis.read(buffer))!=-1) {
			out.write(buffer,0,size); //다운로드 부분 (0%...100%)
		}
		fis.close();
		out.close();
		return null;
	}

	
}

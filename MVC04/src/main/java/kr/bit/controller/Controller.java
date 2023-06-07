package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//모든 pojo들이 가지고 있어야할 메서드 (마치 service) 
	// void타입이야하나? return은 String으로 바뀔 것
	//front컨트롤러가 해야할 일을 pojo가 대신해요
	public String requestHandelr(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
	
	
}

package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		description = "서블릿은 클래스입니다", 
		urlPatterns = { 
				"/NowServlet", 
				"/Now.do", 
				"/Now.action", 
				"/Now.star"
		}, 
		initParams = { 
				@WebInitParam(name = "id", value = "bit", description = "id초기값 설정"), 
				@WebInitParam(name = "jdbcDriver", value = "oracle.jdbc.OracleDriver", description = "오라클 드라이버 제공")
		})
public class NowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public NowServlet() {
        super();
       System.out.println("생성자 객체 생성시 한번 호출");
    }

	
	public void init(ServletConfig config) throws ServletException {
		//초기화 함수 (자동 호출 함수)
		//호출시점 :NowServlet 클래스 파일에 대한 [최초 요청시 한번 실행] 
		//재실행 (개발자 코드 수정 , 서버의 재시작)
		
		//it.co.kr 서버오픈 > WAS (서블릿 : NowServlet.java)
		//홍길동 첫 접속자 -> it.co.kr/NowServlet 서버요청
		//NowServlet 컴파일 > class(실행) -> 생성자 호출 -> init 자동 호출 -> doGET or doPOST 자동호출
		
		//김유신 접속자 -> it.co.kr/NowServlet 서버요청
		//class(실행) -> doGET or doPOST 자동호출
		
		//init : 클래스 내에 다름 함수가 사용하는 공통 자원의  load or 초기화
		
		//db연결 ..한번만 해놓고 .. init
		String drivername = config.getInitParameter("jdbcDriver");
		System.out.println("최초 요청 시 한번 실행 : 드라이버 로딩 :" + drivername);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGET() Call");
		
		//servlet -> UI -> JSP(개발) UI작업
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
			out.print("<head><title>Hello</title></head>");
				out.print("<body>");
					out.print("현재 날짜 : " + new Date() + "<br>");
				out.print("</body>");
		out.print("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPOST() Call");
	}

}

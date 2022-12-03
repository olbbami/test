package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 예제는 애노테이션(@WebServlet)을 이용하여 Servlet을 설정하여 처리하는 예제 
// 애노테이션(@WebServlet)은 Servlet버전 3.0이상에서 사용할 수 있다. 

/*
 * @WebServlet 애노테이션의 속성들 
 * 1. name : 서블릿의 이름을 설정한다. (기본값 : 빈문자열("") ) 
 * 2. urlPatters : 서블릿의 URL패턴의 목록을 설정한다. (기본값 : 빈 배열( {} ) )
 *    예) urlPatterns="/url1" 또는 urlPatterns={"/url1"} ==> 패턴이 1개일 경우 
 *    예) urlPatterns={"/url1", "/url2", ...}  ==> 패턴이 2개 이상일 경우 
 * 3. value : urlPatterns와 같다.    
 * 4. description : 주석(설명글)을 설정한다.  
 *  
 */

@WebServlet(
		urlPatterns = {"/servletTest02.do","/testservlet.do"},
		description = "애노테이션을 이용한 서블릿 설정"	
)

public class ServletTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "이순신";
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text.html; charset=utf-8");
		
		PrintWriter out = response.getWriter(); 
		
		// 처리한 내용을 출력한다. ==> 응답 결과를 웹브라우저로 보낸다. 
		
		// 방법2 : print() 또는 println()메서드 이용하기 
		out.println("<html><head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>첫번째 Servlet 연습</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 style='text-align:center;'>");
		out.println("<h2 style='text-align:center;'>");
		out.println(name + "씨 안녕하세요. 첫번째 Servlet프로그램입니다.<br>");
		out.println("Server at : " + request.getContextPath());
		out.println("</h2>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}

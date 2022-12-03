package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCountServlet
 */
@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		// Cookie의 key값은 count로 하기로 한다. 
		
		// count라는 쿠키가 있는지 검사 
		Cookie[] cookies = request.getCookies();
		
		int count = 0; // count값이 저장될 변수 선언 
		
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				String name = cookie.getName();   // 쿠키의 key값 구하기 
				if("count".equals(name)) {
					String value = cookie.getValue(); // 쿠키의 value값(현재의 count값) 구하기 
					count = Integer.parseInt(value); 
					break;
				}
				
			}
		}
		
		count++;  // count값 증가하기 
		
		// 증가된 count가 저장될 Cookie객체 생성 
		Cookie countCookie = new Cookie("count", String.valueOf(count));
		
		response.addCookie(countCookie);  // 쿠키 추가 
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		out.println("<html><head><meta charset='utf-8'><title>쿠키 카운트</title></head>");
		out.println("<body>");
		out.println("<h3>어서오세요. 당신은 "+count +"번째 방문입니다.</h3>");
		
		out.println("<a href='"+request.getContextPath()+"/cookieCountServlet.do'>카운트 증가하기</a>");
		out.println("<a href='"+request.getContextPath()+"/basic/cookie/cookieTest02.jsp'>시작문서로 가기</a>");
		
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

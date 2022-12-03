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
 * Servlet implementation class CookieCountDelServlet
 */
@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				String name = cookie.getName();
				if("count".equals(name)) {
					// 쿠키 삭제하기... 
					cookie.setMaxAge(0);  // 유지시간을 0으로 세팅 
					response.addCookie(cookie);   // addCookie하지 않고 유지시간을 0으로 세팅만 하고 끝나면 적용되지 않음(쿠키 삭제가)
					break; 
				}
			}
			
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		out.println("<html><head><meta charset='utf-8'><title>쿠키 카운트</title></head>");
		out.println("<body>");
		out.println("<h3>count가 초기화 되었습니다.</h3><br><br>");
		
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

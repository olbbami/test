package kr.or.ddit.basic.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieLoginServlet
 */
@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// id, password, checkbox값 구하기 
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass"); 
		
		String chkid = request.getParameter("chkid");
		
		// 우선 Cookie객체 생성 
		Cookie loginCookie = new Cookie("USERID",userid);
		
//		System.out.println(loginCookie.getMaxAge());
		// Checkbox는 check된 것만 전송된다. 
		if(chkid != null) {   // 체크박스가 체크 되었을 때..
			// 쿠키 저장하기 
			response.addCookie(loginCookie);
		}else {  // 체크박스의 체크가 해제되었을 때 
			// 쿠키 삭제하기 
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
			
		}
		
		if("test".equals(userid) && "1234".equals(pass)) {  // 로그인 성공
			// cookieMain.jsp 페이지로 이동 
			response.sendRedirect(request.getContextPath()+ "/basic/cookie/cookieMain.jsp");
		}else {  // 로그인 실패 
			// cookieLogin.jsp 페이지로 이동 
			response.sendRedirect(request.getContextPath()+ "/basic/cookie/cookieLogin.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

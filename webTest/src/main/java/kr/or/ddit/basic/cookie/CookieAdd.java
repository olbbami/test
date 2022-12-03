package kr.or.ddit.basic.cookie;

import java.io.IOException; 
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieAdd
 */
@WebServlet("/cookieAdd.do")
public class CookieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		// Cookie 저장하는 방법 
		// 1. Cookie객체를 생성한다. ==> '쿠키의 key값'와 '쿠키의 value값'을 문자열로 지정해서 생성한다. 
		//    형식) Cookie cookie변수 = new Cookie("쿠키의 key값","쿠키의 value값"); 
		//       ==> 쿠키 value값이 한글일 경우에는 URLEncoder.encode()메서드로 인코딩 후 저장한다. 
		
		Cookie nameCookie = new Cookie("name", URLEncoder.encode("홍길동", "utf-8"));
		Cookie ageCookie = new Cookie("age", "26"); 
		Cookie korCookie = new Cookie("kor", String.valueOf(100));
		Cookie genderCookie = new Cookie("gender", "Male"); 
		// 2. 쿠키 속성 설정 
		// 쿠키변수.setPath("적용경로");   ==> 지정한 경로와 그 하위 경로에서 사용 가능하다.
		//                             ==> 생략하면 쿠키를 저장한 문서의 경로가 설정된다.
		// 쿠키변수.setDomain("적용도메인명"); ==> 예) ".ddit.or.kr" ==> www.ddit.or.kr, mail.ddit.or.kr....
		// 쿠키변수.setMaxAge(유지시간); ==> 단위(초), (-1:브라우저가 종료될 때까지 유지(기본값), 0:즉시 삭제된다.)
		// 쿠키변수.setSecure(보안여부); ==> true : 적용, false : 미적용(기본값) 
		
		// 3. Response객체를 이용해서 쿠키를 웹브라우저로 보내면 웹브라우저가 이 쿠키를 받아서 저장한다.
		//  형식) response객체.addCookie(1번에서 만든 cookie객체) 
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		response.addCookie(korCookie);
		response.addCookie(genderCookie);
		
		out.println("<html><head><meta charset='utf-8'><title>Cookie저장연습</title></head>");
		out.println("<body>");
		out.println("<h3>Cookie 데이터가 저장되었습니다.</h3><br><br>");
		
		out.println("<a href='"+request.getContextPath() + "/basic/cookie/cookieTest.jsp'> 시작 문서로 가기</a>");
		out.println("</body></html>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

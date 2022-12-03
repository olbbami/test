package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionAdd
 */
@WebServlet("/sessionAdd.do")
public class SessionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session정보 저장하기 
		
		// 1. 현재의 Session정보 가져오기 또는 새로운 Session객체 생성하기 
		// 형식) request객체.getSession(); 또는 request객체.getSession(true); 
		//	   ==> 현재 Session이 존재하면 현재 Session정보를 반환하고 존재하지 않으면 새로운 Session객체를 생성한다. 
		// 형식) request객체.getSession(false); 
		// 	   ==> 현재 Session이 존재하면 현재 Session정보를 반환하고 존재하지 않으면 새로운 Session객체를 생성하지
		//         않고 null을 반환한다. 
		HttpSession session = request.getSession();
		System.out.println(session);
		System.out.println(session.getId());
		// Session에 데이터 저장하기 
		// 형식) session객체변수.setAttribute("key값",session값); 
		//		==> 'key값'은 문자열, 'session값'은 모든 종류의 데이터 
		session.setAttribute("testSession", "연습용 세션입니다.");
		session.setAttribute("userName", "홍길동");
		session.setAttribute("age", 30);
		
		TestMember member = new TestMember("ddit","대덕");
		session.setAttribute("testobj", member);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>Session연습</title></head>");
		out.println("<body>");
		out.println("<h2>Session데이터가 저장되었습니다.</h2>");
		out.println("<a href='"+request.getContextPath() + "/basic/session/sessionTest.jsp'>시작문서로 가기</a>");
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

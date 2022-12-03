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
 * Servlet implementation class SessionDelete
 */
@WebServlet("/sessionDelete.do")
public class SessionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session정보 삭제하기 
		
		// 1. Session객체 생성하거나 현재 Session정보 가져오기 
		HttpSession session = request.getSession(); 
		
		// 2. Session삭제하기 
		//   1) Session값 삭제하기 ==> Session자체는 삭제되지 않고 개별적인 Session값만 삭제된다. 
		//     형식) session객체변수.removeAttribute("key값");
		session.removeAttribute("testSession");
		
		//   2) Session자체를 삭제하기 ==> Session의 모든 정보가 삭제된다. 
		//	     형식) session객체변수.invalidate();

		session.invalidate();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		out.println("<html><head><meta charset='utf-8'><title>Session연습</title></head>");
		out.println("<body>");
		out.println("<h2>Session삭제하기</h2>");
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

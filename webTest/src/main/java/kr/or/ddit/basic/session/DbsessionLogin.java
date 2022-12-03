package kr.or.ddit.basic.session;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class DbsessionLogin
 */
@WebServlet("/dbsessionLogin.do")
public class DbsessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 전송되어 온 파라미터를 읽는다.. (회원ID, 패스워드)
		String userId = request.getParameter("userid");
		String pass = request.getParameter("userpass");
		
		// 읽어온 정보를 VO객체에 저장 
		MemberVO memvo = new MemberVO();
		memvo.setMem_id(userId);
		memvo.setMem_pass(pass);
		
		// Dao객체 생성 (Service객체가 없어서 Dao객체를 직접 생성...)
		MemberDao dao = MemberDao.getInstance();
		
		System.out.println(dao);
		
		
		// 세션 객체 생성 
		HttpSession session = request.getSession(); 
		
		// DB에서 회원ID와 pass가 일치하는 회원정보 검색 
		MemberVO loginMemVo = dao.getMember(memvo);
		
		// 로그인 성공 여부 판단 
		if(loginMemVo!=null) { // 
			session.setAttribute("loginMember", loginMemVo);
			session.setAttribute("chk", "success");
		}else {
			session.setAttribute("chk", "fail");
		}
		
		response.sendRedirect(request.getContextPath()+"/basic/session/db_sessionLogin.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

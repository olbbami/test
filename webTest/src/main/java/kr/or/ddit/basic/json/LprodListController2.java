package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.vo.LprodVO;

/**
 * Servlet implementation class LprodListController
 */
@WebServlet("/lprodListController2.do")
public class LprodListController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		LprodDao lprodDao = LprodDao.getInstance();  // Dao객체 생성 
		
		Gson gson = new Gson();  // Gson객체 생성
		
		List<LprodVO> lprodList = lprodDao.getAllLprod(); // DB에서 자료 꺼내오기 
		
		request.setAttribute("LprodList", lprodList); // 자료를 Request객체에 셋팅한다. 
		
		// forward방식으로 View로 이동한다        
		request.getRequestDispatcher("/basic/json/lprodList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

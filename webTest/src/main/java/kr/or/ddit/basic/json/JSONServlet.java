package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.basic.session.TestMember;

/**
 * Servlet implementation class JSONServlet
 */
@WebServlet("/JSONController.do")
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 파라미터 받기 
		String choice = request.getParameter("choice");
		
		Gson gson = new Gson();   // Gson객체 생성 ==> JSON으로 변환하는 객체 
		String jsonData = null;
		
		switch(choice) {
		case "str":
			String temp = "안녕하세요";   // 응답으로 보낼 문자열 데이터
			jsonData = gson.toJson(temp);    // toJson(데이터); ==> '데이터'를 JSON구조의 문자열로 변환한다. 
			break;
		case "array":
			int[] arr = {100, 200, 300, 400, 500};
			jsonData = gson.toJson(arr);
			break;
		case "obj":
			TestMember mem = new TestMember("a001", "홍길동");
			jsonData = gson.toJson(mem);
			break;
		case "list":
			ArrayList<TestMember> list = new ArrayList<TestMember>();
			
			list.add(new TestMember("a001", "홍길동"));
			list.add(new TestMember("b001", "이순신"));
			list.add(new TestMember("c001", "일지매"));
			
			jsonData = gson.toJson(list);
			break;
		case "map":
			HashMap<String, String> testMap = new HashMap<String, String>();
			testMap.put("name", "이몽룡");
			testMap.put("tel", "010-1234-5678");
			testMap.put("addr", "대전");
			
			jsonData = gson.toJson(testMap);
			break; 
			
		}  // switch문 끝...
		
		System.out.println("choice => " + choice);
		System.out.println(jsonData);
		
		// 만들어진 JSON문자열을 응답 데이터로 보내기 
		response.setContentType("application/json; charset=utf-8");  // json으로 데이터를 전송시 이와 같이 코드를 작성해줘야함 application/json (응답을 json으로 하겠다는 설정)
		PrintWriter out = response.getWriter(); 
		
		out.write(jsonData);
		
		response.flushBuffer();   // 버퍼에 남은 것들을 다 비움 
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

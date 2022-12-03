package kr.or.ddit.basic.fileupload.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.http11.filters.BufferedInputFilter;

import kr.or.ddit.basic.fileupload.service.FileInfoServiceImpl;
import kr.or.ddit.basic.fileupload.service.IFileinfoService;
import kr.or.ddit.vo.FileVO;

/**
 * Servlet implementation class FileDownLoadController
 */
@WebServlet("/fileDownload.do")
public class FileDownLoadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파라미터로 넘어온 파일번호를 구한다. 
		int fileNo = Integer.parseInt(request.getParameter("fileno"));
		
		// 파일번호를 이용하여 해당 파일 정보를 DB에서 가져온다.  
		IFileinfoService service = FileInfoServiceImpl.getInstance();
		
		FileVO vo = service.getFileinfo(fileNo);
		
		System.out.println(vo);
		System.out.println(vo.getFile_no());
		// Upload된 파일이 저장될 폴더 설정 
		String uploadPath = "d:/d_other/uploadFiles"; 
		
		// 저장될 폴더가 없으면 새로 만든다. 
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		response.setCharacterEncoding("utf-8");
		
		// 다운 받을 파일의 file객체 생성 ==> 실제 저장된 파일명을 지정한다. 
		File downFile = new File(uploadPath, vo.getSave_file_name());
		
		if(downFile.exists()) {  // 파일이 있을 때...
			// ContentType 설정 
//			response.setContentType("text/html; charset=utf-8");
//			response.setContentType("application/json; charset=utf-8");
			response.setContentType("application/octet-stream; charset=utf-8");
			
			// Response객체에 content-disposition헤더 정보를 설정한다. 
			String headerKey = "content-disposition";
			
			// 다운 로드할 파일명을 지정한다.
			// ==> 이곳에 지정하는 파일명은 클라이언트에 저장될 파일명을 지정하는 곳으로 파일정보 중 원래의 파일명으로 지정한다. 
			String headerValue = "attachment; " + getEncodedFilename(request, vo.getOrigin_file_name());
			
			System.out.println(vo.getOrigin_file_name());
			
			response.setHeader(headerKey, headerValue);
			
			//------------------------------
			// 실제 저장된 파일 내용을 읽어서 스트림으로 전송 
			
			// 파일 입력용 스트림 객체 생성 
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(downFile));
			
			// 클라이언트로 출력할 출력용 스트림 객체 생성 (Response객체 이용)
			BufferedOutputStream bout = new BufferedOutputStream(response.getOutputStream());
			
			// 두 스트림을 이용하여 입출력 작업 수행 
			byte[] buffer = new byte[1024];
			int len = 0;
			
			while( (len = bin.read(buffer))>0 ) {
				bout.write(buffer, 0, len);
			}
			bout.flush();
			
		}else {
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<h3>" + vo.getOrigin_file_name() + "파일이 존재하지 않습니다. </h3>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// 다운로드 파일명이 한글일 때 한글이 깨지는 것을 방지하는 메서드 
	private String getEncodedFilename(HttpServletRequest request, String fileName) {
		String encodedFilename = "";
		String userAgent = request.getHeader("User-Agent");
		
		try {
			// MSIE 10 버전 이하의 웹브라우저 
			if(userAgent.contains("MSIE") || userAgent.contains("Trident")) {
				encodedFilename = "filename=\"" + 
				URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "\\ ") + "\"";
			}else {
				encodedFilename = "filename*=UTF-8''"+
				URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "%20");
				
			}
			
			return encodedFilename;
			
		} catch (UnsupportedEncodingException e) {
			// TODO: handle exception
			throw new RuntimeException("지원하지 않는 인코딩 방식입니다...");
		}
	}

}

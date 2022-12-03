package kr.or.ddit.basic.fileupload.dao;

import java.util.List;

import org.apache.tomcat.jni.FileInfo;

import kr.or.ddit.vo.FileVO;

public interface IFileInfoDao {
	/**
	 * FileVO객체에 저장된 자료를 DB에 insert하는 메소드 
	 * 
	 * @param filevo DB에 insert할 자료가 저장된 FileVO객체
	 * @return 작업성공 : 1, 작업실패 : 0 
	 */
	public int insertFileinfo(FileVO vo);
	
	/**
	 * FILEINFO테이블의 전체 데이터를 가져오는 메서드 
	 * @return 파일 정보가 저장된 List객체 
	 */
	public List<FileVO> getAllFileinfo();

	/**
	 * 파일 번호를 인수값으로 받아서 해당 파일 정보를 반환하는 메서드 
	 * 
	 * @param fileNo 검색할 파일 번호 
	 * @return 검색된 파일 정보가 저장된 FileVO객체 
	 */
	public FileVO getFileinfo(int fileNo);
}

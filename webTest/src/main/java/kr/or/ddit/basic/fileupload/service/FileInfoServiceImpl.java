package kr.or.ddit.basic.fileupload.service;

import java.util.List;

import org.apache.tomcat.jni.FileInfo;

import kr.or.ddit.basic.fileupload.dao.FileinfoDaoImpl;
import kr.or.ddit.basic.fileupload.dao.IFileInfoDao;
import kr.or.ddit.vo.FileVO;

public class FileInfoServiceImpl implements IFileinfoService {
	private IFileInfoDao dao;
	
	private static FileInfoServiceImpl service;
	
	private FileInfoServiceImpl() {
		dao = FileinfoDaoImpl.getInstance();
	}
	
	public static FileInfoServiceImpl getInstance() {
		if(service ==null) service = new FileInfoServiceImpl();
		return service;
	}
	

	@Override
	public List<FileVO> getAllFileinfo() {
		// TODO Auto-generated method stub
		return dao.getAllFileinfo();
	}

	@Override
	public FileVO getFileinfo(int fileNo) {
		// TODO Auto-generated method stub
		return dao.getFileinfo(fileNo);
	}
	@Override
	public int insertFileinfo(FileVO fvo) {
		// TODO Auto-generated method stub
		return dao.insertFileinfo(fvo);
	}

}

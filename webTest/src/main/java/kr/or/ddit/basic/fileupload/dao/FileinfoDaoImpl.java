package kr.or.ddit.basic.fileupload.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.vo.FileVO;

public class FileinfoDaoImpl implements IFileInfoDao{
	private SqlMapClient smc;
	
	private static FileinfoDaoImpl dao;
	
	private FileinfoDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static FileinfoDaoImpl getInstance() {
		if(dao == null) dao = new FileinfoDaoImpl();
		
		return dao; 
		
	}
	@Override
	public int insertFileinfo(FileVO vo) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("fileinfo.insertFileInfo",vo);
			
			if(obj == null) {
				cnt = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<FileVO> getAllFileinfo() {
		List<FileVO> filelist = null;
		
		try {
			filelist = smc.queryForList("fileinfo.getAllFileinfo");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return filelist;
				
	}

	@Override
	public FileVO getFileinfo(int fileNo) {
		FileVO filevo = null;
		
		try {
			filevo = (FileVO)smc.queryForObject("fileinfo.getFileinfo", fileNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filevo;
	}

}

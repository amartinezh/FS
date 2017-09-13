package service.fs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.fs.Conpgmu;
import repository.fs.pgmuDao;
import service.fs.pgmuService;

@Service
public class pgmuServiceImpl implements pgmuService {
	
	@Autowired
	private pgmuDao Dao;
	
	public List<Conpgmu> list(String cia, String m, String y){
		return Dao.list(cia, m, y);
	}
}

package service.fs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.fs.Conpgau;
import repository.fs.pgauDao;
import service.fs.pgauService;

@Service
public class pgauServiceImpl implements pgauService {
	
	@Autowired
	private pgauDao Dao;
	
	public List<Conpgau> list(String cia, String m, String y){
		return Dao.list(cia, m, y);
	}
}

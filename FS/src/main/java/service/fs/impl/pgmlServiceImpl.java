package service.fs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.fs.Conpgml;
import repository.fs.pgmlDao;
import service.fs.pgmlService;

@Service
public class pgmlServiceImpl implements pgmlService {
	
	@Autowired
	private pgmlDao Dao;
	
	public List<Conpgml> list(String cia, String m, String y){
		return Dao.list(cia, m, y);
	}
}

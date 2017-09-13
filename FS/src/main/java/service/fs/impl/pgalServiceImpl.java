package service.fs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.fs.Conpgal;
import repository.fs.pgalDao;
import service.fs.pgalService;

@Service
public class pgalServiceImpl implements pgalService {
	
	@Autowired
	private pgalDao Dao;
	
	public List<Conpgal> list(String cia, String m, String y){
		return Dao.list(cia, m, y);
	}
}

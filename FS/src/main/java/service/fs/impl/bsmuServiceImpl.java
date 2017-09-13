package service.fs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.fs.Conbsmu;
import repository.fs.bsmuDao;
import service.fs.bsmuService;

@Service
public class bsmuServiceImpl implements bsmuService {
	
	@Autowired
	private bsmuDao Dao;
	
	public List<Conbsmu> list(String cia, String m, String y){
		return Dao.list(cia, m, y);
	}
}

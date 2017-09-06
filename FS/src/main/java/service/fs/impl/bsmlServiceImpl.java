package service.fs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.fs.Conbsml;
import repository.fs.bsmlDao;
import service.fs.bsmlService;

@Service
public class bsmlServiceImpl implements bsmlService {
	
	@Autowired
	private bsmlDao Dao;
	
	public List<Conbsml> list(String cia){
		return Dao.list(cia);
	}
}

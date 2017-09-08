package repository.fs.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.fs.Conbsml;
import repository.fs.bsmlDao;
import service.fs.bsmlService;

@Repository
public class bsmlDaoImpl implements bsmlDao {

	@PersistenceContext
	private EntityManager em = null;

	@Autowired
	private bsmlService Service;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	// list //////////////////////////////////////////////////////////////////////////////////
	// list //////////////////////////////////////////////////////////////////////////////////
	// list //////////////////////////////////////////////////////////////////////////////////

	public List<Conbsml> list(String cia) {
		//return em.createQuery("SELECT C FROM Conbsml as C WHERE C.ccia = '"+cia+"'").getResultList();
		return em.createQuery("SELECT C FROM Conbsml as C").getResultList();
	}
	
	// //////////////////////////////////////////////////////////////////////////////////

		
		
}

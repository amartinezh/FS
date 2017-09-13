package repository.fs.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.fs.Conbsmu;
import repository.fs.bsmuDao;
import service.fs.bsmlService;

@Repository
public class bsmuDaoImpl implements bsmuDao {

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

	public List<Conbsmu> list(String cia, String m, String y) {
		return em.createQuery("SELECT C FROM Conbsmu as C WHERE C.ccia = '"+cia+"' AND C.cpers = '"+m+"'" +" AND C.cyear = '"+y+"'" ).getResultList();
		//return em.createQuery("SELECT C FROM Conbsml as C").getResultList();
	}
	
	// //////////////////////////////////////////////////////////////////////////////////

		
		
}

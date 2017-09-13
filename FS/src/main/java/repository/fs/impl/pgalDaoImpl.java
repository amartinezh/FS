package repository.fs.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.fs.Conpgal;
import repository.fs.pgalDao;
import service.fs.pgalService;

@Repository
public class pgalDaoImpl implements pgalDao {

	@PersistenceContext
	private EntityManager em = null;

	@Autowired
	private pgalService Service;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	// list //////////////////////////////////////////////////////////////////////////////////
	// list //////////////////////////////////////////////////////////////////////////////////
	// list //////////////////////////////////////////////////////////////////////////////////

	public List<Conpgal> list(String cia, String m, String y) {
		return em.createQuery("SELECT C FROM Conpgal as C WHERE C.ccia = '"+cia+"' AND C.cpers = '"+m+"'" +" AND C.cyear = '"+y+"'" ).getResultList();
		//return em.createQuery("SELECT C FROM Conbsml as C").getResultList();
	}
	
	// //////////////////////////////////////////////////////////////////////////////////

		
		
}

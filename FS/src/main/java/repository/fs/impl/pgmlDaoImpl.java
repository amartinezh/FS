package repository.fs.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.fs.Conpgml;
import repository.fs.pgmlDao;
import service.fs.pgmlService;

@Repository
public class pgmlDaoImpl implements pgmlDao {

	@PersistenceContext
	private EntityManager em = null;

	@Autowired
	private pgmlService Service;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	// list //////////////////////////////////////////////////////////////////////////////////
	// list //////////////////////////////////////////////////////////////////////////////////
	// list //////////////////////////////////////////////////////////////////////////////////

	public List<Conpgml> list(String cia, String m, String y) {
		return em.createQuery("SELECT C FROM Conpgml as C WHERE C.ccia = '"+cia+"' AND C.cpers = '"+m+"'" +" AND C.cyear = '"+y+"'" ).getResultList();
		//return em.createQuery("SELECT C FROM Conbsml as C").getResultList();
	}
	
	// //////////////////////////////////////////////////////////////////////////////////

		
		
}

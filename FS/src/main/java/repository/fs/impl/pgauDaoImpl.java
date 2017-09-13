package repository.fs.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.fs.Conpgau;
import repository.fs.pgauDao;
import service.fs.pgauService;

@Repository
public class pgauDaoImpl implements pgauDao {

	@PersistenceContext
	private EntityManager em = null;

	@Autowired
	private pgauService Service;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	// list //////////////////////////////////////////////////////////////////////////////////
	// list //////////////////////////////////////////////////////////////////////////////////
	// list //////////////////////////////////////////////////////////////////////////////////

	public List<Conpgau> list(String cia, String m, String y) {
		return em.createQuery("SELECT C FROM Conpgau as C WHERE C.ccia = '"+cia+"' AND C.cpers = '"+m+"'" +" AND C.cyear = '"+y+"'" ).getResultList();
		//return em.createQuery("SELECT C FROM Conbsml as C").getResultList();
	}
	
	// //////////////////////////////////////////////////////////////////////////////////

		
		
}

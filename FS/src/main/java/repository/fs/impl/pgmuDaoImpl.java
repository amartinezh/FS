package repository.fs.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.fs.Conpgmu;
import repository.fs.pgmuDao;
import service.fs.pgmuService;

@Repository
public class pgmuDaoImpl implements pgmuDao {

	@PersistenceContext
	private EntityManager em = null;

	@Autowired
	private pgmuService Service;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	// list //////////////////////////////////////////////////////////////////////////////////
	// list //////////////////////////////////////////////////////////////////////////////////
	// list //////////////////////////////////////////////////////////////////////////////////

	public List<Conpgmu> list(String cia, String m, String y) {
		return em.createQuery("SELECT C FROM Conpgmu as C WHERE C.ccia = '"+cia+"' AND C.cpers = '"+m+"'" +" AND C.cyear = '"+y+"'" ).getResultList();
		//return em.createQuery("SELECT C FROM Conbsml as C").getResultList();
	}
	
	// //////////////////////////////////////////////////////////////////////////////////

		
		
}

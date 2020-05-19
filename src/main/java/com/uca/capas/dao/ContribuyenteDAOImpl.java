package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Contribuyente;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager eManager;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.contribuyente");
		Query query = eManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Contribuyente> res = query.getResultList();	
		return res;
	}

	@Override
	public Contribuyente findOne(Integer code) throws DataAccessException {
		Contribuyente contribuyente = eManager.find(Contribuyente.class, code);
		return contribuyente;
	}

	@Override
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		eManager.persist(contribuyente);
	}

	@Override
	@Transactional
	public void save(Contribuyente contribuyente) throws DataAccessException {
		try {
			if(contribuyente.getCodigoContribuyente() == null) {
				eManager.persist(contribuyente);
			}else {
				eManager.merge(contribuyente);
				eManager.flush();
			}
		}catch(Throwable e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer codigoContribuyente) throws DataAccessException {
		Contribuyente contribuyente = eManager.find(Contribuyente.class, codigoContribuyente);
		eManager.remove(contribuyente);
	}

	
}

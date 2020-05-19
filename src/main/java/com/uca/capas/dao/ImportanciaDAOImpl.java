package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.uca.capas.domain.Importancia;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO {

	@PersistenceContext(unitName = "capas")
	private EntityManager eManager;
	
	@Override
	public List<Importancia> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.importancia");
		Query query = eManager.createNativeQuery(sb.toString(), Importancia.class);
		List<Importancia> res = query.getResultList();	
		return res;
	}

	@Override
	public Importancia findOne(Integer code) throws DataAccessException {
		Importancia importancia = eManager.find(Importancia.class, code);
		return importancia;
	}
}

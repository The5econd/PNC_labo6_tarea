package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	ContribuyenteDAO contribuyenteDAO;
	@Autowired
	ImportanciaDAO importanciaDAO;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		return contribuyenteDAO.findAll();
	}
	
	@Override
	public Contribuyente findOne(Integer code) throws DataAccessException {
		return contribuyenteDAO.findOne(code);
	}

	@Override
	@Transactional
	public void save(Contribuyente contribuyente) throws DataAccessException {
		contribuyenteDAO.save(contribuyente);
	}

	@Override
	@Transactional
	public void delete(Integer codigoContribuyente) throws DataAccessException {
		contribuyenteDAO.delete(codigoContribuyente);
	}

	
	
	
	@Override
	public Importancia findOneImportancia(Integer code) throws DataAccessException {
		return importanciaDAO.findOne(code);
	}

	@Override
	public List<Importancia> findAllImportancia() throws DataAccessException {
		return importanciaDAO.findAll();
	}

}

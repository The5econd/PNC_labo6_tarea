package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;

public interface TodoService {

	public List<Contribuyente> findAll() throws DataAccessException;
	
	public Contribuyente findOne(Integer code) throws DataAccessException;
	
	public void save(Contribuyente contribuyente) throws DataAccessException;
	
	public void delete(Integer codigoContribuyente) throws DataAccessException;
	
	public List<Importancia> findAllImportancia()throws DataAccessException;
	
	public Importancia findOneImportancia(Integer code)throws DataAccessException;
}

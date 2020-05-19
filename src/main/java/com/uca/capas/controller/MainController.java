package com.uca.capas.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.TodoService;

@Controller
public class MainController {

	@Autowired
	private TodoService contribuyenteService;
	
	@RequestMapping("/index")
	public ModelAndView initMain(){
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancias = null;
		try{
			importancias = contribuyenteService.findAllImportancia();
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("contribuyente", new Contribuyente());
		mav.addObject("importancias", importancias);
		mav.setViewName("index");
		return mav;
	}
	
	@PostMapping("/save")
	public ModelAndView guardar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) throws ParseException{
		ModelAndView mav = new ModelAndView();
		DateTime dt = new DateTime();
		String day = String.valueOf(dt.getDayOfYear());
		String month = String.valueOf(dt.getMonthOfYear());
		String year = String.valueOf(dt.getYear());
		
		String fechaString = day + "/" + month + "/" + year;
		if(result.hasErrors()) {
			mav.setViewName("index");
			List<Importancia> importancias = null;
			try{
				importancias = contribuyenteService.findAllImportancia();
			}catch(Exception e){
				e.printStackTrace();
			}
			mav.addObject("importancias", importancias);
		}else {
			DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
			Date date = format.parse(fechaString);
			contribuyente.setFecha(date);
			contribuyenteService.save(contribuyente);
			mav.addObject("contribuyente", contribuyente.getNombre());
			mav.setViewName("guardado");
		}
		return mav;
	}
	
	@RequestMapping("/listadoContribuyentes")
	public ModelAndView listado(){
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		try{
			contribuyentes = contribuyenteService.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("contribuyente_list");
		return mav;
	}
}

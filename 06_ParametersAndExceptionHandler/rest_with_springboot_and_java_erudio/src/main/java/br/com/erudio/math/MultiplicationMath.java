package br.com.erudio.math;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.controllers.ClassController;
import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController

public class MultiplicationMath {

	private final AtomicLong counter = new AtomicLong();	
	
	
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	

	
	public Double multiplication(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo) 
	throws Exception{
		
		
		
			if(ClassController.isNumeric(numberOne) && ClassController.isNumeric(numberTwo)) {

		
		return ClassController.convertToDouble(numberOne) * ClassController.convertToDouble(numberTwo);
			} 
			throw new UnsupportedMathOperationException("Coloque um valor numérico por favor!");
			
		


	}
	
	
	
}

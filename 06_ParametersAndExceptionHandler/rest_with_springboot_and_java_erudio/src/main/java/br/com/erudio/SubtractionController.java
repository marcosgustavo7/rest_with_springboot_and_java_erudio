package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController

public class SubtractionController {

	private final AtomicLong counter = new AtomicLong();
	
	ClassController classController = new ClassController();
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	

	public Double subtraction(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo) 
	throws Exception{
		
		
		
		if(ClassController.isNumeric(numberOne) && ClassController.isNumeric(numberTwo)) {

	
	return ClassController.convertToDouble(numberOne) - ClassController.convertToDouble(numberTwo);
		} 
		throw new UnsupportedMathOperationException("Coloque um valor numérico por favor!");
	
	}
}
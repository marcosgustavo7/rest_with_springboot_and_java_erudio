package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController

public class AverageController {

	Double averageNumber = 0.00;
	
	private final AtomicLong counter = new AtomicLong();
	
	ClassController classController = new ClassController();
	
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	
	public Double average(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo) 
	throws Exception{
		
		
		
		if(ClassController.isNumeric(numberOne) && ClassController.isNumeric(numberTwo)) {

			averageNumber = (classController.convertToDouble(numberOne) + classController.convertToDouble(numberTwo))/2;
			return averageNumber;
		} 
		throw new UnsupportedMathOperationException("Coloque um valor numérico por favor!");
		
	


}
	
		
		
	}

	


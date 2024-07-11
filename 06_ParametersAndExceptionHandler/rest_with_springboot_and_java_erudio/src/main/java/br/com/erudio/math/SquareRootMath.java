package br.com.erudio.math;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.controllers.ClassController;
import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController

public class SquareRootMath {

	private final AtomicLong counter = new AtomicLong();
	
	Double squareRoot = 0.00;
	
	
	
	@RequestMapping(value = "/squareRoot/{numberOne}",
			method = RequestMethod.GET)
	

	public Double squareRoot(
			@PathVariable(value = "numberOne")String numberOne)
	throws Exception{
		
		
		if(ClassController.isNumeric(numberOne))
		{
			return Math.sqrt(ClassController.convertToDouble(numberOne));
		}throw new UnsupportedMathOperationException("Coloque um valor numérico por favor!");
	}
	}

	


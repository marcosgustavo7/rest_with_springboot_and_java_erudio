package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController

public class SquareRootController {

	private final AtomicLong counter = new AtomicLong();
	
	Double squareRoot = 0.00;
	
	ClassController classController = new ClassController();
	
	@RequestMapping(value = "/squareRoot/{numberOne}",
			method = RequestMethod.GET)
	

	public Double squareRoot(
			@PathVariable(value = "numberOne")String numberOne)
	throws Exception{
		
		
		if(classController.isNumeric(numberOne))
		{ 
		
		for(Double i = 0.00; i < classController.convertToDouble(numberOne)+1; i++) {
		
			if(i * i == classController.convertToDouble(numberOne)) return i;
		}
		return 0D;
		}throw new UnsupportedMathOperationException("Coloque um valor numérico por favor!");
	}
	}

	


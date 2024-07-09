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
	
	@RequestMapping(value = "/squareRoot/{numberOne}",
			method = RequestMethod.GET)
	

	public Double squareRoot(
			@PathVariable(value = "numberOne")String numberOne)
	throws Exception{
		
		
		if(!isNumeric(numberOne))
		{ throw new UnsupportedMathOperationException("Coloque um valor numérico por favor!");
		}
		
		for(Double i = 0.00; i < convertToDouble(numberOne)+1; i++) {
		
			if(i * i == convertToDouble(numberOne)) return i;
		}
		return 0D;
	}

	private Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",",".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",","."); 
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");

	}
	
}

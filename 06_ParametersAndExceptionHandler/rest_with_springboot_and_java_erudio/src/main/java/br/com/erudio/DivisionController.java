package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController

public class DivisionController {

	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	

	public Double division(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo) 
	throws Exception{
		
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo))
		{ throw new UnsupportedMathOperationException("Coloque um valor numérico por favor!");
		
		}
		
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
		
		
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

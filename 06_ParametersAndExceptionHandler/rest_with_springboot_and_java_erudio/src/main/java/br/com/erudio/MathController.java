package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{NumberOne}/{NumberTwo}", method=RequestMethod.GET)
	
	public Double sum(
			@PathVariable(value = "NumberOne") String numberOne, 
			@PathVariable(value = "NumberTwo") String numberTwo 
			) {
		
		return 1D;
		
	}
	
}

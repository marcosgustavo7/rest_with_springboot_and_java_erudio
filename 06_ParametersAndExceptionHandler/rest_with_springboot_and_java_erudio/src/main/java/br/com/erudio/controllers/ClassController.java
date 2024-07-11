package br.com.erudio.controllers;

public class ClassController {

	public static Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",",".");
		 return Double.parseDouble(number);
		
	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",","."); 
		if(number.matches("[-+]?[0-9]*\\.?[0-9]+")) return true;
		return false;

	}
}

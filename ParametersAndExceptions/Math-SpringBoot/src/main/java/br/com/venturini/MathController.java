package br.com.venturini;

// import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.venturini.exceptions.UnsuportedMathOperationException;

@RestController
public class MathController {
	
	// private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	// specifies the route in the url 
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception{
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
			}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String strNumber) {
		// se valor for nulo
		if (strNumber == null) return 0D;
		
		// converte moeda brasileira para internacional (virgula pra ponto)
		String number = strNumber.replaceAll(",", ".");
		
		// faz a conversao para double
		if (isNumeric(number)) return Double.parseDouble(number);
		
		// retorna nulo caso nao de certo
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;				
		String number = strNumber.replaceAll(",", ".");
		
		// regex
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	};
}
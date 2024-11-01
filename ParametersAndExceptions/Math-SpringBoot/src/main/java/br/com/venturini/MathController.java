package br.com.venturini;

import java.math.BigDecimal;

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
			) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
			}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	// specifies the route in the url 
	public Double subtract(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
			}
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	// specifies the route in the url 
	public Double divide(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			// para quando enviar valores nao-numericos
			throw new UnsuportedMathOperationException("Please set a numeric value!");
			}
		else if (numberOne.equals("0") || numberTwo.equals("0")) {
			// para divisoes com zero
			throw new UnsuportedMathOperationException("Can not divide by zero!");
		}
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	// specifies the route in the url
	public Double multiply(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			// para quando enviar valores nao-numericos
			throw new UnsuportedMathOperationException("Please set a numeric value!");
			}
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/powerOf/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	// specifies the route in the url
	public Double powerOf(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			// para quando enviar valores nao-numericos
			throw new UnsuportedMathOperationException("Please set a numeric value!");
			}
		else if (isNegative(numberTwo)) {
			// caso a potencia seja negativa
			throw new UnsuportedMathOperationException("Potency can not be a negative value!");
		}
		else if (numberOne.equals("0")) {
			// caso o expoente seja zero
			// zero elevado a qualquer valor positivo da zero
			return 0D;
		}
		else if (numberTwo.equals("0")) {
			// caso a potencia tem valor zero o resultado e 1
			return 1D;
		}
		return Math.pow(convertToDouble(numberOne), convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	// specifies the route in the url
	public Double average(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			// para quando enviar valores nao-numericos
			throw new UnsuportedMathOperationException("Please set a numeric value!");
			}
		else if (numberOne.equals("0") || numberTwo.equals("0")) {
			// caso um dos valores seja zero, retorna apenas a soma
			return convertToDouble(numberOne) + convertToDouble(numberTwo);
		}
		return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
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
	
	private boolean isNegative(String strNumber) {
	    if (strNumber == null) return false;				
	    String number = strNumber.replaceAll(",", ".");

	    try {
	        BigDecimal bigDecimalNumber = new BigDecimal(number);
	        return bigDecimalNumber.compareTo(BigDecimal.ZERO) < 0;
	    } catch (NumberFormatException e) {
	        // caso a conversao para bigdecimal falhe (número invalido)
	        return false;
	    }
	}
	
	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;				
		String number = strNumber.replaceAll(",", ".");
		
		// regex
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	};
}
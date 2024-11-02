package br.com.venturini.service;

import org.springframework.stereotype.Service;

import br.com.venturini.exceptions.UnsuportedMathOperationException;
import br.com.venturini.util.MathUtil;

@Service
public class MathService {
	
	public Double sum(String numberOne, String numberTwo) throws UnsuportedMathOperationException {
        MathUtil.validateNumericInput(numberOne, numberTwo);
        return MathUtil.convertToDouble(numberOne) + MathUtil.convertToDouble(numberTwo);
    }
	
	public Double subtract(String numberOne, String numberTwo) throws UnsuportedMathOperationException {
        MathUtil.validateNumericInput(numberOne, numberTwo);
        return MathUtil.convertToDouble(numberOne) - MathUtil.convertToDouble(numberTwo);
    }

    public Double divide(String numberOne, String numberTwo) throws UnsuportedMathOperationException {
        MathUtil.validateNumericInput(numberOne, numberTwo);
        Double denominator = MathUtil.convertToDouble(numberTwo);
        if (denominator == 0) throw new UnsuportedMathOperationException("Cannot divide by zero!");
        return MathUtil.convertToDouble(numberOne) / denominator;
    }

    public Double multiply(String numberOne, String numberTwo) throws UnsuportedMathOperationException {
        MathUtil.validateNumericInput(numberOne, numberTwo);
        return MathUtil.convertToDouble(numberOne) * MathUtil.convertToDouble(numberTwo);
    }

    public Double powerOf(String numberOne, String numberTwo) throws UnsuportedMathOperationException {
        MathUtil.validateNumericInput(numberOne, numberTwo);
        if (MathUtil.isNegative(numberTwo)) throw new UnsuportedMathOperationException("Exponent cannot be negative!");
        return Math.pow(MathUtil.convertToDouble(numberOne), MathUtil.convertToDouble(numberTwo));
    }

    public Double average(String numberOne, String numberTwo) throws UnsuportedMathOperationException {
        MathUtil.validateNumericInput(numberOne, numberTwo);
        return (MathUtil.convertToDouble(numberOne) + MathUtil.convertToDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number) throws UnsuportedMathOperationException {
        MathUtil.validateNumericInput(number);
        if (MathUtil.isNegative(number)) throw new UnsuportedMathOperationException("No square root for negative numbers!");
        return Math.sqrt(MathUtil.convertToDouble(number));
    }
}

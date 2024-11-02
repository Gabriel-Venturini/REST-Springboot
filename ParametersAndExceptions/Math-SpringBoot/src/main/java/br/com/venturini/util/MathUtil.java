package br.com.venturini.util;

import java.math.BigDecimal;

import br.com.venturini.exceptions.UnsuportedMathOperationException;

public class MathUtil {

	public static void validateNumericInput(String... numbers) throws UnsuportedMathOperationException {
        for (String number : numbers) {
            if (!isNumeric(number)) {
                throw new UnsuportedMathOperationException("Please provide a numeric value.");
            }
        }
    }

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replace(",", ".");
        return isNumeric(number) ? Double.parseDouble(number) : 0D;
    }

    public static boolean isNegative(String strNumber) {
        if (strNumber == null) return false;
        try {
            BigDecimal bigDecimal = new BigDecimal(strNumber.replace(",", "."));
            return bigDecimal.compareTo(BigDecimal.ZERO) < 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        return strNumber.replace(",", ".").matches("[-+]?[0-9]*\\.?[0-9]+");
    }
    
}

package br.com.venturini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.venturini.service.MathService;

// nota: só eu e deus sabemos o trabalho que foi refatorar isso, mas valeu a pena

@RestController
@RequestMapping("/math")
public class MathController {
	
	@Autowired
    private MathService mathService;

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        return mathService.sum(numberOne, numberTwo);
    }

    @GetMapping("/subtract/{numberOne}/{numberTwo}")
    public Double subtract(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        return mathService.subtract(numberOne, numberTwo);
    }

    @GetMapping("/divide/{numberOne}/{numberTwo}")
    public Double divide(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        return mathService.divide(numberOne, numberTwo);
    }

    @GetMapping("/multiply/{numberOne}/{numberTwo}")
    public Double multiply(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        return mathService.multiply(numberOne, numberTwo);
    }

    @GetMapping("/powerOf/{numberOne}/{numberTwo}")
    public Double powerOf(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        return mathService.powerOf(numberOne, numberTwo);
    }

    @GetMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        return mathService.average(numberOne, numberTwo);
    }

    @GetMapping("/squareroot/{number}")
    public Double squareRoot(@PathVariable String number) throws Exception {
        return mathService.squareRoot(number);
    }
    
}
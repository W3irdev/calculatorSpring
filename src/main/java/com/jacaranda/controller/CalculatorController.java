package com.jacaranda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.model.Calculator;
import com.jacaranda.model.WattCalculator;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CalculatorController {

	
	@GetMapping("/calculator")
	public String calculator(Model model) {
		Calculator calculator = new Calculator();
		WattCalculator watCalc = new WattCalculator();
		model.addAttribute("calc", calculator);
		model.addAttribute("calcWatt", watCalc);
		
		return "calculator";
	}

	@GetMapping("/resolver")
	public String resolver(Model model, @ModelAttribute("calc") Calculator calculatorUser){
		Calculator calculator = new Calculator();
		WattCalculator watCalc = new WattCalculator();
		String result = null;
		model.addAttribute("calc", calculator);
		model.addAttribute("calcWatt", watCalc);
		try {
			result = "Operacion anterior: "+ calculatorUser.getNum1()+ calculator.getOperator() + calculatorUser.getNum2()
			+ " = " + calculatorUser.getResult();		
		}catch (Exception e) {
			result = e.getMessage();
		}
		
		model.addAttribute("result", result);
		return "calculator";
	
	}
	
	@GetMapping("/resolverWatts")
	public String resolverWatts(Model model,@Validated @ModelAttribute("calcWatt") WattCalculator watCalculator,
			BindingResult br){
		WattCalculator watCalc = new WattCalculator();
		Calculator calculator = new Calculator();
		
			if(br.hasErrors()) {

					model.addAttribute("resultWatt", "No se puede calcular");
					model.addAttribute("calc", "No se puede calcular");
				return "calculator";
			}
		
			model.addAttribute("resultWatt", watCalculator.getWattios());
			model.addAttribute("calc", calculator);
		
		return "calculator";
	
	}
	

	
}

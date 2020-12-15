package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorFormulario {

	@RequestMapping(value="/formulario", method=RequestMethod.GET)
	public String formulario_get() {
		
		return "formulario";
	}
	
	@RequestMapping(value="/formulario", method=RequestMethod.POST)
	public String formulario_post(Model modelo,
			@RequestParam int edad,
			@RequestParam int estatura,
			@RequestParam int peso,
			@RequestParam int sexo) {
		
		modelo.addAttribute("edad_form", edad);
		modelo.addAttribute("estatura_form", estatura);
		modelo.addAttribute("peso_form", peso);
		modelo.addAttribute("sexo_form", sexo);
		modelo.addAttribute("porcentaje_form", 
				(1.2*(peso / (((double)estatura/100) * ((double)estatura/100)))) + (0.23*edad) - (10.8+sexo) - 5.4);
		
		return "datosFormulario";
	}
}

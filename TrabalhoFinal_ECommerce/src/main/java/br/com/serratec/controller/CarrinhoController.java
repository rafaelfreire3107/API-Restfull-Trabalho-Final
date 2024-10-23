package br.com.serratec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.service.CarrinhoService;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {

	@Autowired
	private CarrinhoService carrinhoService;

}

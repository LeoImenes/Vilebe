package com.vilebe.aluguelcarros.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vilebe.aluguelcarros.domains.Locacao;
import com.vilebe.aluguelcarros.process.LocacaoProcess;

@RestController
public class LocacaoController {
	
		@GetMapping(path = "api/locadora/locaco")
		public ArrayList<Locacao> locacaos(){
			LocacaoProcess.abrir();
			return LocacaoProcess.locacoes;
			}
}

package com.vilebe.aluguelcarros.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vilebe.aluguelcarros.dao.LocacaoDAO;
import com.vilebe.aluguelcarros.domains.Cliente;
import com.vilebe.aluguelcarros.domains.Locacao;
import com.vilebe.aluguelcarros.domains.Sede;
import com.vilebe.aluguelcarros.domains.Veiculo;
import com.vilebe.aluguelcarros.process.LocacaoProcess;
import com.vilebe.aluguelcarros.process.SedeProcess;
import com.vilebe.aluguelcarros.process.VeiculoProcess;


@RestController
public class LocacaoController {
	JSONObject objJSON = new JSONObject();
	private static Locacao locacao;
	private static Cliente cliente;
	private static Sede sede;
	private static Veiculo veiculo;
	private static LocacaoDAO ld = new LocacaoDAO();


	
	@GetMapping(path = "/locadora/locacao")
	
	public ResponseEntity<ArrayList<Locacao>> abrir() throws SQLException {
		try {
			return new ResponseEntity<ArrayList<Locacao>>(ld.readAll(), HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping(path = "/locadora/locacao")
	public void criarLocacao(@RequestBody String body) throws JSONException {
		objJSON = new JSONObject(body);
		sede = new Sede(objJSON.getInt("idSede"));
		cliente = new Cliente(objJSON.getInt("idCliente")
				);
		veiculo = new Veiculo(objJSON.getInt("idVeiculo"));

		locacao = new Locacao(
				cliente, 
				veiculo,
				sede,
				objJSON.getString("DataRetirada"), 
				objJSON.getString("LocalRetirada"),
				objJSON.getString("DataDevolucao"),
				objJSON.getString("LocalDevolucao")

		);

		LocacaoProcess.criar(locacao);
	}
	@DeleteMapping(path = "/locadora/locacao")
	public void excluirVeiculo(@RequestBody String id) throws JSONException {
		objJSON = new JSONObject(id);
		LocacaoProcess.delLoc(objJSON.getString("idLoc"));
	}
}

package com.vilebe.aluguelcarros.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vilebe.aluguelcarros.domains.Cliente;
import com.vilebe.aluguelcarros.process.ClienteProcess;

@RestController
public class ClienteController {
	private JSONObject objJSON;
	private Cliente cliente;

	@GetMapping(path = "/api/locadora/cliente")
	public ArrayList<Cliente> abrirClientes() {
		ClienteProcess.abrir();
		return ClienteProcess.clientes;
	}

	@GetMapping(path = "/api/locadora/clientes")
	public Cliente abrirCliente(@RequestBody String json) throws JSONException {
		ClienteProcess.abrir();
		objJSON = new JSONObject(json);
		if (ClienteProcess.clientes.contains(new Cliente(objJSON.getInt("idCliente")))) {
			return ClienteProcess.clientes.get(ClienteProcess.clientes.indexOf(new Cliente(objJSON.getInt("idCliente"))));
		} else {
			return null;
		}
	}

	@PostMapping(path = "/api/locadora/cliente")
	public void criarCliente(@RequestBody String body) throws JSONException {
		objJSON = new JSONObject(body);
		cliente = new Cliente(objJSON.getString("nome"), objJSON.getString("cnh"), objJSON.getString("cpf"),
				objJSON.getString("endereco"), objJSON.getInt("idade"), objJSON.getString("cart"),
				objJSON.getString("observacoes"), objJSON.getString("email"),objJSON.getString("telefone")

		);
		ClienteProcess.addCliente(cliente);
	}

	@DeleteMapping(path = "/api/locadora/cliente")
	public void excluirCliente(@RequestBody String id) throws JSONException {
		objJSON = new JSONObject(id);
		ClienteProcess.delCliente(objJSON.getString("idCliente"));
	}

	@PutMapping(path = "/api/locadora/cliente")
	public void alterarCliente(@RequestBody String body) throws JSONException {
		objJSON = new JSONObject(body);
		String[] params = { "nome", "cnh", "cpf", "endereco", "idade", "cart", "observacoes", "email","telefone" };
		Map<String, String> args = new HashMap<String, String>();
		for (int i = 0; i < params.length; i++) {
			if (!objJSON.isNull(params[i])) {
				args.put(params[i], objJSON.get(params[i]).toString());
			}
		}
		cliente = new Cliente(args);
		ClienteProcess.updtCliente(objJSON.getString("idCliente"), cliente);
		
	}
}

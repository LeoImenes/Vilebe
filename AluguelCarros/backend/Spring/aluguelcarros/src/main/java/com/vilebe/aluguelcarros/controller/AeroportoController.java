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

import com.vilebe.aluguelcarros.domains.Aeroporto;
import com.vilebe.aluguelcarros.process.AeroportoProcess;

@RestController
public class AeroportoController {
	private JSONObject OBJjson;
	private Aeroporto aeroporto;
	
	@GetMapping(path = "/api/locadora/aero")
	public ArrayList<Aeroporto> abrirAero(){
		AeroportoProcess.abrir();
		return AeroportoProcess.aeroportos;
	}
	@GetMapping(path = "/api/locadora/aeros")
	public Aeroporto abrirAeroporto(@RequestBody String json) throws JSONException {
		AeroportoProcess.abrir();
		if(AeroportoProcess.aeroportos.contains(new Aeroporto(OBJjson.getInt("idAero")))) {
			return AeroportoProcess.aeroportos.get(AeroportoProcess.aeroportos.indexOf(new Aeroporto(OBJjson.getInt("idAero"))));
		}else
		return null;
	}
	@PostMapping(path="api/locadora/aero")
	public void criarAero(@RequestBody String body) throws JSONException {
		OBJjson = new JSONObject(body);
		aeroporto = new Aeroporto(OBJjson.getString("nome"),OBJjson.getString("estado"));
		System.out.println(OBJjson);
		AeroportoProcess.addAero(aeroporto);
	}
	@DeleteMapping(path="api/locadora/aero")
	public void delAero(@RequestBody String id) throws JSONException {
		OBJjson = new JSONObject(id);
		AeroportoProcess.delAero(OBJjson.getString("idAero"));
		
	}
	@PutMapping(path="api/locadora/aero")
	public void alterarAero(@RequestBody String body) throws JSONException {
		OBJjson = new JSONObject(body);
		String[] params = {"nome","estado"};
		Map<String, String> args = new HashMap<String, String>();
		for (int i=0; i<params.length;i++) {
			args.put(params[i],OBJjson.getString(params[i].toString()));
		}
		aeroporto = new Aeroporto(args);
		
	AeroportoProcess.updtAero(OBJjson.getString("idAero"), aeroporto);
	}
	
}

package com.vilebe.aluguelcarros.domains;

import java.util.Map;
import java.util.Objects;

public class Veiculo {
	private int idVeiculo;
	private String tipo;
	private String modelo;
	private String marca;
	private String placa;
	private String espf;
	private String datarevisao;
	private String kminit;

	public Veiculo() {

	}

	public Veiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public Veiculo(String idVeiculo) {
		this.idVeiculo = Integer.parseInt(idVeiculo);
	}

	public Veiculo(int idVeiculo, String tipo, String modelo, String marca, String placa, String espf,
			String datarevisao, String kminit) {

		this.idVeiculo = idVeiculo;
		this.tipo = tipo;
		this.modelo = modelo;
		this.marca = marca;
		this.placa = placa;
		this.espf = espf;
		this.datarevisao = datarevisao;
		this.kminit = kminit;
	}
	

	public Veiculo(String tipo, String modelo, String marca, String placa, String espf, String datarevisao,
			String kminit) {

		this.tipo = tipo;
		this.modelo = modelo;
		this.marca = marca;
		this.placa = placa;
		this.espf = espf;
		this.datarevisao = datarevisao;
		this.kminit = kminit;
	}

	public Veiculo(String idVeiculo, String tipo, String modelo, String marca, String placa, String espf,
			String datarevisao, String kminit) {

		this.idVeiculo = Integer.parseInt(idVeiculo);
		this.tipo = tipo;
		this.modelo = modelo;
		this.marca = marca;
		this.placa = placa;
		this.espf = espf;
		this.datarevisao = datarevisao;
		this.kminit = kminit;
	}

	public Veiculo(Map<String, String> args) {
		if (args.containsKey("tipo")) {
			this.tipo = (args.get("tipo"));
		}
		if (args.containsKey("modelo")) {
			this.modelo = (args.get("modelo"));
		}
		if (args.containsKey("kminit")) {
			this.kminit = args.get("kminit");
		}
		if (args.containsKey("datarevisao")) {
			this.datarevisao = args.get("datarevisao");
		}
		if (args.containsKey("marca")) {
			this.marca = args.get("marca");
		}
		if (args.containsKey("placa")) {
			this.placa = args.get("placa");
		}
		if (args.containsKey("espf")) {
			this.espf = args.get(espf);
		}
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getEspf() {
		return espf;
	}

	public void setEspf(String espf) {
		this.espf = espf;
	}

	public String getDatarevisao() {
		return datarevisao;
	}

	public void setDatarevisao(String datarevisao) {
		this.datarevisao = datarevisao;
	}

	public String getKminit() {
		return kminit;
	}

	public void setKminit(String kminit) {
		this.kminit = kminit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idVeiculo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return idVeiculo == other.idVeiculo;
	}

	@Override
	public String toString() {
		return  idVeiculo + "\t" + tipo + "\t" + modelo + "\t" + marca
				+ "\t" + placa +"\t" + espf + "\t" + datarevisao + "\t" + kminit + "\r\n";
	}
	

}

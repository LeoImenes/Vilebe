package com.vilebe.aluguelcarros.domains;

import java.util.Map;
import java.util.Objects;

public class Aeroporto {
	private int idAero;
	private String nome;
	private String estado;

	public Aeroporto(int idAero, String nome, String estado) {

		this.idAero = idAero;
		this.nome = nome;
		this.estado = estado;
	}

	public Aeroporto(String idAero, String nome, String estado) {

		this.idAero = Integer.parseInt(idAero);
		this.nome = nome;
		this.estado = estado;
	}

	public Aeroporto() {

	}

	public Aeroporto(int idAero) {

		this.idAero = idAero;
	}

	public Aeroporto(String idAero) {

		this.idAero = Integer.parseInt(idAero);
	}

	public Aeroporto(String nome, String estado) {

		this.nome = nome;
		this.estado = estado;
	}

	public Aeroporto(Map<String, String> args) {
		if (args.containsKey("nome")) {
			this.nome = args.get("nome");
		}
		if (args.containsKey("estado")) {
			this.estado = args.get("estado");
		}

	}

	public int getidAero() {
		return idAero;
	}

	public void setidAero(int idAero) {
		this.idAero = idAero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getestado() {
		return estado;
	}

	public void setestado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeroporto other = (Aeroporto) obj;
		return idAero == other.idAero;
	}

	@Override
	public String toString() {
		return idAero + "\t" + nome + "\t" + estado + "\r\n";
	}

}

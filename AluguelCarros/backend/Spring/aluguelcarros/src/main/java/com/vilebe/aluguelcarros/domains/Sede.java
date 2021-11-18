package com.vilebe.aluguelcarros.domains;

import java.util.Map;
import java.util.Objects;

public class Sede {
	private int idSede;
	private String Sedenome;
	private String estado;

	public Sede(int idSede, String Sedenome, String estado) {

		this.idSede = idSede;
		this.Sedenome = Sedenome;
		this.estado = estado;
	}

	public Sede(String idSede, String Sedenome, String estado) {

		this.idSede = Integer.parseInt(idSede);
		this.Sedenome = Sedenome;
		this.estado = estado;
	}

	public Sede() {

	}

	public Sede(int idSede) {

		this.idSede = idSede;
	}

	public Sede(String idSede) {

		this.idSede = Integer.parseInt(idSede);
	}

	public Sede(String Sedenome, String estado) {

		this.Sedenome = Sedenome;
		this.estado = estado;
	}

	public Sede(Map<String, String> args) {
		if (args.containsKey("Sedenome")) {
			this.Sedenome = args.get("Sedenome");
		}
		if (args.containsKey("estado")) {
			this.estado = args.get("estado");
		}

	}

	public int getidSede() {
		return idSede;
	}

	public void setidSede(int idSede) {
		this.idSede = idSede;
	}

	public String getNome() {
		return Sedenome;
	}

	public void setNome(String Sedenome) {
		this.Sedenome = Sedenome;
	}

	public String getestado() {
		return estado;
	}

	public void setestado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSede);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sede other = (Sede) obj;
		return idSede == other.idSede;
	}

	@Override
	public String toString() {
		return idSede + "\t" + Sedenome + "\t" + estado + "\r\n";
	}

}

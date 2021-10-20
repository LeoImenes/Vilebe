package com.vilebe.aluguelcarros.domains;

import java.util.Objects;

public class Veiculo {
	private int idVeiculo;
	private int idTipo;
	private int idCara;
	private String DataRevisao;
	private String KM_inicial;

	public Veiculo(int idVeiculo, int idTipo, int idCara, String dataRevisao, String kM_inicial) {

		this.idVeiculo = idVeiculo;
		this.idTipo = idTipo;
		this.idCara = idCara;
		DataRevisao = dataRevisao;
		KM_inicial = kM_inicial;
	}

	public Veiculo(String idVeiculo, int idTipo, int idCara, String dataRevisao, String kM_inicial) {

		this.idVeiculo = Integer.parseInt(idVeiculo);
		this.idTipo = idTipo;
		this.idCara = idCara;
		this.DataRevisao = dataRevisao;
		this.KM_inicial = kM_inicial;
	}
	
	public Veiculo(int idTipo, int idCara,String dataRevisao, String KM_inicial) {
		this.idTipo = idTipo;
		this.idCara = idCara;
		this.DataRevisao = dataRevisao;
		this.KM_inicial = KM_inicial;
	}

	public Veiculo() {
	}
	public Veiculo(String idVeiculo) {
		this.idVeiculo = Integer.parseInt(idVeiculo);
	}
	
	public Veiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public int getIdCara() {
		return idCara;
	}

	public void setIdCara(int idCara) {
		this.idCara = idCara;
	}

	public String getDataRevisao() {
		return DataRevisao;
	}

	public void setDataRevisao(String dataRevisao) {
		DataRevisao = dataRevisao;
	}

	public String getKM_inicial() {
		return KM_inicial;
	}

	public void setKM_inicial(String kM_inicial) {
		KM_inicial = kM_inicial;
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
		return  idVeiculo + "\t" + idTipo + "\t" + idCara + "\t"
				+ DataRevisao + "\t" + KM_inicial + "\r\n";
	}

	
}

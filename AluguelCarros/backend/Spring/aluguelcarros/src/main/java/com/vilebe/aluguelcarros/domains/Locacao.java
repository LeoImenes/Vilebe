package com.vilebe.aluguelcarros.domains;

import java.util.Date;
import java.util.Objects;

public class Locacao {
	private int idLoc;
	private Aeroporto idAero;
	private Cliente idCliente;
	private Veiculo idVeiculo;
	private Date DataDevolucao;
	private Date DataRetirada;
	private String LocalRetirada;
	private String LocalDevolucao;
	private String kmfin;

	public Locacao(int idLoc, Aeroporto idAero, Cliente idCliente, Veiculo idVeiculo, Date dataDevolucao,
			Date dataRetirada, String localRetirada, String localDevolucao, String kmfin) {
		
		this.idLoc = idLoc;
		this.idAero = idAero;
		this.idCliente = idCliente;
		this.idVeiculo = idVeiculo;
		DataDevolucao = dataDevolucao;
		DataRetirada = dataRetirada;
		LocalRetirada = localRetirada;
		LocalDevolucao = localDevolucao;
		this.kmfin = kmfin;
	}

	public Locacao(Aeroporto idAero, Cliente idCliente, Veiculo idVeiculo, Date dataDevolucao, Date dataRetirada,
			String localRetirada, String localDevolucao, String kmfin) {

		this.idAero = idAero;
		this.idCliente = idCliente;
		this.idVeiculo = idVeiculo;
		DataDevolucao = dataDevolucao;
		DataRetirada = dataRetirada;
		LocalRetirada = localRetirada;
		LocalDevolucao = localDevolucao;
		this.kmfin = kmfin;
	}

	public Locacao() {

	}

	public Locacao(String idLoc, Aeroporto idAero, Cliente idCliente, Veiculo idVeiculo, Date dataDevolucao,
			Date dataRetirada, String localRetirada, String localDevolucao, String kmfin) {
		
		this.idLoc = Integer.parseInt(idLoc);
		this.idAero = new Aeroporto();
		this.idCliente = new Cliente();
		this.idVeiculo = new Veiculo();
		DataDevolucao = dataDevolucao;
		DataRetirada = dataRetirada;
		LocalRetirada = localRetirada;
		LocalDevolucao = localDevolucao;
		this.kmfin = kmfin;
	}

	public Locacao(String idLoc) {
		this.idLoc = Integer.parseInt(idLoc);
	}

	public Locacao(int idLoc) {
		this.idLoc = idLoc;
	}

	public int getIdLoc() {
		return idLoc;
	}

	public void setIdLoc(int idLoc) {
		this.idLoc = idLoc;
	}

	public Aeroporto getIdAero() {
		return idAero;
	}

	public void setIdAero(Aeroporto idAero) {
		this.idAero = idAero;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public Veiculo getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Veiculo idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public Date getDataDevolucao() {
		return DataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		DataDevolucao = dataDevolucao;
	}

	public Date getDataRetirada() {
		return DataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		DataRetirada = dataRetirada;
	}

	public String getLocalRetirada() {
		return LocalRetirada;
	}

	public void setLocalRetirada(String localRetirada) {
		LocalRetirada = localRetirada;
	}

	public String getLocalDevolucao() {
		return LocalDevolucao;
	}

	public void setLocalDevolucao(String localDevolucao) {
		LocalDevolucao = localDevolucao;
	}

	public String getKmfin() {
		return kmfin;
	}

	public void setKmfin(String kmfin) {
		this.kmfin = kmfin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLoc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Locacao other = (Locacao) obj;
		return idLoc == other.idLoc;
	}

	@Override
	public String toString() {
		return idLoc + "\t" + idAero + "\t" + idCliente + "\t" + idVeiculo + "\t" + DataDevolucao + "\t" + DataRetirada
				+ "\t" + LocalRetirada + "\t" + LocalDevolucao + "\t" + kmfin + "\r\n";
	}

}

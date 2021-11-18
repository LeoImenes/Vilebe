package com.vilebe.aluguelcarros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vilebe.aluguelcarros.domains.Cliente;
import com.vilebe.aluguelcarros.domains.Locacao;

import com.vilebe.aluguelcarros.domains.Veiculo;

public class LocacaoDAO {

	private static Connection con;
	private static PreparedStatement ps;
	
	private static Locacao locacao;
	private static ArrayList<Locacao> locacaos;
	
	public ArrayList<Locacao> readAll() throws SQLException{
		locacaos = new ArrayList<>();
		
		String query = "select * from Locacao inner join Cliente on (Cliente.idCliente = Locacao.idCliente)"
		+"inner join Veiculo on (Veiculo.idVeiculo = Locacao.idVeiculo)";
		
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Cliente cli = new Cliente(
					rs.getInt("idCliente"),
					rs.getString("nome"),
					rs.getInt("idade"),
					rs.getString("cnh"),
					rs.getString("cpf"),
					rs.getString("telefone"));
			Veiculo vei = new Veiculo(
					rs.getInt("idVeiculo"), 
					rs.getString("tipo"), 
					rs.getString("modelo"),
					rs.getString("marca"),
					rs.getString("placa"), 
					rs.getString("espf"), 
					rs.getString("img"));
			locacao = new Locacao(
					rs.getInt("idLoc"),
					cli,
					vei,
					rs.getString("DataRetirada"),
					rs.getString("LocalRetirada"),
					rs.getString("DataDevolucao"),
					rs.getString("LocalDevolucao")
					
					);
			locacaos.add(locacao);
		}
		
		con.close();
		return locacaos;
		
	} 
	
	public void criar(Locacao loc) throws SQLException {
		String query = "insert into Locacao (idCliente, idVeiculo, DataRetirada, LocalRetirada, DataDevolucao, LocalDevolucao) values (?, ?, ?, ?,?,?);";
		
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.setInt(1, loc.getIdCliente().getIdCliente());
		ps.setInt(2, loc.getIdVeiculo().getIdVeiculo());
		ps.setString(3, loc.getDataRetirada());
		ps.setString(4, loc.getLocalRetirada());
		ps.setString(5, loc.getDataDevolucao());
		ps.setString(6, loc.getLocalDevolucao());
		ps.execute();
		
		con.close();
	}
}



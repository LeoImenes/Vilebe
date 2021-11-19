package com.vilebe.aluguelcarros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vilebe.aluguelcarros.domains.Cliente;
import com.vilebe.aluguelcarros.domains.Locacao;
import com.vilebe.aluguelcarros.domains.Sede;
import com.vilebe.aluguelcarros.domains.Veiculo;

public class LocacaoDAO {

	private static Connection con;
	private static PreparedStatement ps;
	
	private static Locacao locacao;
	private static ArrayList<Locacao> locacaos;
	
	public ArrayList<Locacao> readAll() throws SQLException{
		locacaos = new ArrayList<>();
		
		String query = "select * from Locacao inner join Cliente on (Cliente.idCliente = Locacao.idCliente)"
		+"inner join Veiculo on (Veiculo.idVeiculo = Locacao.idVeiculo)"
		+"inner join Sede on (Sede.idSede = Locacao.idSede)";
		
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
			Sede sed = new Sede(
					rs.getInt("idSede"), 
					rs.getString("Sedenome"),
					rs.getString("estado")
					);
			locacao = new Locacao(
					rs.getInt("idLoc"),
					cli,
					vei,
					sed,
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
		String query = "insert into Locacao (idCliente, idVeiculo,idSede, DataRetirada, LocalRetirada, DataDevolucao, LocalDevolucao) values (?,?, ?, ?, ?,?,?);";
		
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.setInt(1, loc.getIdCliente().getIdCliente());
		ps.setInt(2, loc.getIdVeiculo().getIdVeiculo());
		ps.setInt(3, loc.getIdSede().getidSede());
		ps.setString(4, loc.getDataRetirada());
		ps.setString(5, loc.getLocalRetirada());
		ps.setString(6, loc.getDataDevolucao());
		ps.setString(7, loc.getLocalDevolucao());
		ps.execute();
		
		con.close();
	}
	public void delLocSQL(String id) throws SQLException {
		String query = "delete from Locacao where idLoc = " + id;
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.execute();
		con.close();
	}
}



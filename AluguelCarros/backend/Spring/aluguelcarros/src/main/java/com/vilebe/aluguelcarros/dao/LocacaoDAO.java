package com.vilebe.aluguelcarros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vilebe.aluguelcarros.domains.Aeroporto;

import com.vilebe.aluguelcarros.domains.Locacao;
import com.vilebe.aluguelcarros.domains.Veiculo;

public class LocacaoDAO {

	private static Connection con;
	private static PreparedStatement ps;

	private static Locacao locacao;
	public static ArrayList<Locacao> locacoes;

	public ArrayList<Locacao> readAll() throws SQLException {
		locacoes = new ArrayList<>();

		String query = "select " 
		+ "l.idLoc," 
		+ "a.idAero," 
		+ "a.nome," 
		+ "a.estado," 
		+ "v.idVeiculo,"
		+"v.tipo,"
		+ "v.kminit,"
		+ "v.marca," 
		+ "v.modelo,"
		+ "v.placa,"
		+ "v.espf,"
		+ "v.datarevisao," 
		+ "DataRetirada," 
		+ "DataDevolucao,"
		+ "LocalRetirada," 
		+ "LocalDevolucao" 
		+ "from locacao l "
		+ "inner join veiculo as v on (v.idVeiculo = l.idVeiculo)"
		+ "inner join aeroporto as a on (a.idAero = l.idAero);";

		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Veiculo v = new Veiculo(
					rs.getInt(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getString(9),
					rs.getString(10),
					rs.getString(11),
					rs.getString(12)
					);
			Aeroporto a = new Aeroporto(
					rs.getInt(2),
					rs.getString(3),
					rs.getString(4)
					);
			locacoes.add(locacao);
		}
		con.close();
		return locacoes;
	}
}
package com.vilebe.aluguelcarros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.vilebe.aluguelcarros.domains.Aeroporto;


public class AeroportoDAO {
	private Connection con;
	private PreparedStatement ps;

	private Aeroporto aeroporto;
	private ArrayList<Aeroporto> aeroportos;

	public ArrayList<Aeroporto> readAll() throws SQLException {
		aeroportos = new ArrayList<>();
		String query = "select * from Aeroporto";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			aeroporto = new Aeroporto(rs.getInt("idAero"), rs.getString("nome"), rs.getString("estado"));
			aeroportos.add(aeroporto);
		}
		con.close();
		return aeroportos;

	}

	public void addaeroportosQL(Aeroporto Aeroporto) throws SQLException {
		String query = "insert into aeroporto (nome,estado) values (?,?)";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, aeroporto.getNome());
		ps.setString(2, aeroporto.getestado());
		ps.execute();
		con.close();
	}

	public void delaeroportosQL(String id) throws SQLException {
		String query = "delete from aeroporto where idAero = " + id;
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.execute();
		con.close();
	}

	public void updtaeroportosQL(String id, Aeroporto aeroporto) throws SQLException {
		String query = "update aeroporto set ";
		if (aeroporto.getNome() != null) {
			query += "tipo = '" + aeroporto.getNome() + "',";
		}
		if (aeroporto.getestado() != null) {
			query += "estado = '" + aeroporto.getestado() + "',";
		}
	
		if (query.endsWith(", ")) {
			query = query.substring(0, query.length() - 1);
			query = query.substring(0, query.length() - 1);
			query += " ";
		}

		query += " where idAero = " + id + ";";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.execute();
		con.close();
	}
}

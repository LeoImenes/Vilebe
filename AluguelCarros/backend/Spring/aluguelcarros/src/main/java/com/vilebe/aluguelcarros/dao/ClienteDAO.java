package com.vilebe.aluguelcarros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vilebe.aluguelcarros.domains.Cliente;



public class ClienteDAO {
	private Connection con;
	private PreparedStatement ps;
	
	private ArrayList<Cliente> clientes;
	private Cliente cliente;
	
	public ArrayList<Cliente> readAll() throws SQLException{
		clientes = new ArrayList<>();
		String query = "select * from cliente";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			cliente = new Cliente(
					rs.getInt("idCliente"),
					rs.getString("nome"),
					rs.getString("cnh"),
					rs.getString("cpf"),
					rs.getString("endereco"),
					rs.getInt("idade"),
					rs.getString("cart"),
					rs.getString("observacoes"),
					rs.getString("email"),
					rs.getString("telefone")
					);
					
					
			clientes.add(cliente);
		}
		con.close();
		return clientes;
	}
	
	public void AddClienteSQL(Cliente cliente) throws SQLException {
		String query = "insert into cliente(nome,cnh,cpf,endereco,idade,cart,observacoes,email,telefone) values (?, ?, ?, ?, ?, ?,?,?,?)";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, cliente.getNome());
		ps.setString(2, cliente.getCnh());
		ps.setString(3, cliente.getCpf());
		ps.setString(4, cliente.getEndereco());
		ps.setInt(5, cliente.getIdade());
		ps.setString(6, cliente.getCart());
		ps.setString(7, cliente.getObservacoes());
		ps.setString(8, cliente.getEmail());
		ps.setString(9, cliente.getTelefone());
		ps.execute();
		con.close();
	}
	
	public void DelClienteSQL(String id) throws SQLException {
		String query = "delete from cliente where idCliente =" + id;
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.execute();
		con.close();
	}
	
	public void UpdtClienteSQL(String id, Cliente cliente) throws SQLException{
		String query = "update cliente set "; 
		
		if(cliente.getNome() != null) {
			query += "nome = '" + cliente.getNome() + "', "; 
		}
		
		if(cliente.getCnh() != null) {
			query += "cnh = '" + cliente.getCnh() + "', ";
		}
		
		if(cliente.getCpf() != null) {
			query += "cpf = '" + cliente.getCpf() + "', ";
		}
		
		if(cliente.getEndereco() != null) {
			query += "endereco = '" + cliente.getEndereco() + "', ";
		}
		
		if(cliente.getIdade() != 0) {
			query += "idade = '" + cliente.getIdade() + "', ";
		}
		
		if(cliente.getObservacoes() != null) {
			query += "observacoes = '" + cliente.getObservacoes() + "' ";
		}
		if(cliente.getCart() != null) {
			query += "cart = ' " + cliente.getObservacoes() + "' ";
		}
		if(cliente.getEmail() != null) {
			query += "email = ' " + cliente.getEmail() + "' ";
		}
		if(cliente.getTelefone()!= null) {
			query += "telefone = ' " + cliente.getTelefone() + "' ";
		}
		
		if(query.endsWith(", ")) {
			query = query.substring(0, query.length()-1);
			query = query.substring(0, query.length()-1);
			query += " ";
		}
		
		query += "where idCliente = " + id + ";";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.execute();
		con.close();
	}
}


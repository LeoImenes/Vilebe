package com.vilebe.aluguelcarros.process;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vilebe.aluguelcarros.dao.ClienteDAO;
import com.vilebe.aluguelcarros.domains.Cliente;



public class ClienteProcess {
	public static ArrayList<Cliente> clientes = new ArrayList<>();
	public static ClienteDAO cd = new ClienteDAO();
	
	public static void abrir(){
		try {
			clientes = cd.readAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addCliente(Cliente cliente){
		try {
			cd.AddClienteSQL(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delCliente(String idCliente){
		try {
			cd.DelClienteSQL(idCliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updtCliente(String idCliente, Cliente cliente) {
		try {
			cd.UpdtClienteSQL(idCliente, cliente);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

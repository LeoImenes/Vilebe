package com.vilebe.aluguelcarros.process;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vilebe.aluguelcarros.dao.AeroportoDAO;
import com.vilebe.aluguelcarros.domains.Aeroporto;

public class AeroportoProcess {
	public static ArrayList<Aeroporto>aeroportos = new ArrayList<>();
	public static AeroportoDAO ad = new AeroportoDAO();
	
	public static void abrir() {
		try {
			aeroportos = ad.readAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addAero(Aeroporto aeroporto) {
		try {
			ad.addaeroportosQL(aeroporto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void delAero(String id) {
		try {
			ad.delaeroportosQL(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updtAero(String id, Aeroporto aeroporto ) {
		try {
			ad.updtaeroportosQL(id, aeroporto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

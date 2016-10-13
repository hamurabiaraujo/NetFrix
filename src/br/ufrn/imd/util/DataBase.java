package br.ufrn.imd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost/netfrix";
	private String user;
	private String password;
	private Connection connection;
	
	public DataBase(String user, String password) {
		try {
			Class.forName(this.driver);
			this.connection = DriverManager.getConnection(this.url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Não foi possível encontrar o driver do banco: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
		}
	}
}

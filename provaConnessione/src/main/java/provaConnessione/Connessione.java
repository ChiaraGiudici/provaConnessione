package provaConnessione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Connessione {
	public Connection getCon() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		DriverManager.registerDriver(new Driver());
		Connection conn = DriverManager.getConnection("jbdc:mysql://localhost/progetto?user=root&password=progetto");
		return conn;
	}
	
	public void prova(){
		try {
			System.out.println("Recupero dati dal db");
			String query = "SELECT * FROM prova";
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet ris = ps.executeQuery();
			System.out.println(ris.getString("name"));
			ris.close();
			con.close();
		}
		catch (SQLException ex){
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());			
			System.out.println("Connection Error: " + ex.getErrorCode());
		}
		catch (Exception ex) {
			System.out.println("error");
		}
	}
}

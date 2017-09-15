package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManejadorTabla {
	
	private String driver="com.mysql.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String user="java";
	private String password="java";
	private String db="javaDateTime";
	
	public void guardarSeparado(java.sql.Date fecha, java.sql.Time hora){
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(
			        "jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+password);
			
			
			PreparedStatement stmt=conn.prepareStatement(
					"insert into fecha_hora(fecha,hora) values (?,?)"
					); // el campo fecha es de tipo date y hora de timpo time
			stmt.setDate(1, fecha); //parámetro de entrada del método
			stmt.setTime(2, hora);  //parámetro de entrada del método
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void guardarJunto(java.util.Date fechaHora){
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(
			        "jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+password);
			
			
			PreparedStatement stmt=conn.prepareStatement(
					"insert into fechaHoraJuntos(fechaHora) values (?)"
					); // el campo fecha es de tipo date y hora de timpo time
			stmt.setTimestamp(1, new java.sql.Timestamp(fechaHora.getTime())); //parámetro de entrada del método
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}

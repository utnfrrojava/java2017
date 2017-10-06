package data;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.security.KeyStore.ProtectionParameter;
import java.sql.*;

import entity.*;
import util.AppDataException;

public class DataPersona {
	
	public ArrayList<Persona> getAll() throws Exception{
	
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from persona p inner join categoria c on p.categoriaId=c.id");
			if(rs!=null){
				while(rs.next()){
					Persona p=new Persona();
					p.setCategoria(new Categoria());
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					
					p.getCategoria().setId(rs.getInt("categoriaId"));
					p.getCategoria().setDescripcion(rs.getString("descripcion"));
					
					pers.add(p);
				}
			}
		} catch (SQLException e) {
			
			throw e;
		} catch (AppDataException ade){
			throw ade;
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return pers;
		
	}
	
	public Persona getByDni(Persona per) throws Exception{
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select p.id, nombre, apellido, dni, habilitado, categoriaId, descripcion from persona p inner join categoria c on p.categoriaId=c.id where dni=?");
			stmt.setString(1, per.getDni());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					p=new Persona();
					p.setCategoria(new Categoria());
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.getCategoria().setId(rs.getInt("categoriaId"));
					p.getCategoria().setDescripcion(rs.getString("descripcion"));
			}
			
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return p;
	}
	
	public void add(Persona p) throws Exception{
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into persona(dni, nombre, apellido, habilitado, categoriaId) values (?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setBoolean(4, p.isHabilitado());
			stmt.setInt(5, p.getCategoria().getId());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				p.setId(keyResultSet.getInt(1));
			}
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Persona getLogedUser(Persona per) throws Exception{
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select p.id, nombre, apellido, dni, habilitado, categoriaId, descripcion from persona p inner join categoria c on p.categoriaId=c.id where user=? and pass=?");
			stmt.setString(1, per.getUser());
			stmt.setString(2, per.getPass());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					p=new Persona();
					p.setCategoria(new Categoria());
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.getCategoria().setId(rs.getInt("categoriaId"));
					p.getCategoria().setDescripcion(rs.getString("descripcion"));
			}
			
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}

		return p;
	}

	public void remove(Persona p) throws Exception{
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
				.prepareStatement(
					"delete from persona where id=?"
				);
			stmt.setInt(1, p.getId());
			stmt.executeUpdate();
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void update(Persona p) throws Exception{
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"update persona set dni=?, nombre=?, apellido=?, habilitado=?, categoriaId=? where id=?"
					);
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setBoolean(4, p.isHabilitado());
			stmt.setInt(5, p.getCategoria().getId());
			stmt.setInt(6, p.getId());
			stmt.executeUpdate();
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Persona getByNombreApellido(Persona per) throws Exception{
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select p.id, nombre, apellido, dni, habilitado, categoriaId, descripcion from persona p inner join categoria c on p.categoriaId=c.id where nombre=? and apellido=?");
			stmt.setString(1, per.getNombre());
			stmt.setString(2, per.getApellido());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					p=new Persona();
					p.setCategoria(new Categoria());
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.getCategoria().setId(rs.getInt("categoriaId"));
					p.getCategoria().setDescripcion(rs.getString("descripcion"));
			}
			
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}

		return p;
	}

}

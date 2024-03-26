package br.com.toylab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.toylab.model.Toys;
import br.com.toylab.util.ConnectionFactory;

public class ToyDAO {
	// Database classes
	private Connection conn; // Open a connection from Data Base
	private PreparedStatement ps; //allows SQL scripts to be run from Java
	private ResultSet rs; //represents the tables

	
	// classe JavaBean
	private Toys toy;

	public ToyDAO() throws Exception {
		// call the class ConnectionFactory and establishes a connection
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// Create a new Toy
	public void create(Toys toy) throws Exception {
		if (toy == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO brinquedos (codigo_brinquedo, descricao, categoria, marca, imagem, valor, detalhes, nome, )"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, toy.getCode());
			ps.setString(2, toy.getName());
			ps.setString(3, toy.getImage());
			ps.setString(4, toy.getDescription());
			ps.setDouble(5, toy.getValue());
			ps.setString(6, toy.getDetails());
			ps.setObject(7, toy.getCategory());
			ps.setString(8, toy.getBrand());
			ps.executeUpdate();
			//ps.setDate(5, new java.sql.Date(aluno.getDataNascimento().getTime()));
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	//Update a Toy by code
	public void update(Toys toy) throws Exception {
		if (toy == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE brinquedos set descricao=?, set categoria=?, set marca=?, set imagem=?, set valor=?, set detalhes=?, set nome=? WHERE codigo_brinquedo=? ";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, toy.getCode());
			ps.setString(2, toy.getName());
			ps.setString(3, toy.getImage());
			ps.setString(4, toy.getDescription());
			ps.setDouble(5, toy.getValue());
			ps.setString(6, toy.getDetails());
			ps.setObject(7, toy.getCategory());
			ps.setString(8, toy.getBrand());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// Delete Toy By Code
	public void delete(Toys toy) throws Exception {
		if (toy == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE from brinquedos WHERE codigo_brinquedo=?)";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, toy.getCode());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// Find Toy by Code
	public Toys findByCode(Toys toy) throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM brinquedos WHERE codigo_brinquedo=?");
			ps.setInt(1, toy.getCode());
			rs = ps.executeQuery();
			while (rs.next()) {
				Integer code = rs.getInt("codigo_brinquedo");
				String name = rs.getString("nome");
				String image = rs.getString("imagem");
				Double value = rs.getDouble("valor");
				String description = rs.getString("descricao");
				String category = rs.getString("categoria");
				String details = rs.getString("detalhes");
				String brand = rs.getString("marca");
				
				toy = new Toys(code, name, image, description, value, details, category, brand);
			}
			return toy; 
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	//List All Toys
	public List<Toys> findAll() throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM brinquedos");
			ps.setInt(1, toy.getCode());
			List<Toys> toyList = new ArrayList<Toys>();
			
			while (rs.next()) {
				Integer code = rs.getInt("codigo_brinquedo");
				String name = rs.getString("nome");
				String image = rs.getString("imagem");
				Double value = rs.getDouble("valor");
				String description = rs.getString("descricao");
				String category = rs.getString("categoria");
				String details = rs.getString("detalhes");
				String brand = rs.getString("marca");
				
			   toyList.add(new Toys(code, name, image, description, value, details, category, brand));
			}
			return toyList; 
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

}
package br.com.toylab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.toylab.model.Toy;
import br.com.toylab.util.ConnectionFactory;

public class ToyDAO {
	// Database classes
	private Connection conn; // Open a connection from Data Base
	private PreparedStatement ps; //allows SQL scripts to be run from Java
	private ResultSet rs; //represents the tables

	
	// classe JavaBean
	private Toy toy;

	public ToyDAO() throws Exception {
		// call the class ConnectionFactory and establishes a connection
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// Create a new Toy
	public void create(Toy toy) throws Exception {
		if (toy == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO brinquedos (descricao, categoria, marca, imagem, valor, detalhes, nome)"
					+ "values ( ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, toy.getName());
			ps.setString(2, toy.getImage());
			ps.setString(3, toy.getDescription());
			ps.setDouble(4, toy.getValue());
			ps.setString(5, toy.getDetails());
			ps.setObject(6, toy.getCategory());
			ps.setString(7, toy.getBrand());
			ps.executeUpdate();
			//ps.setDate(5, new java.sql.Date(aluno.getDataNascimento().getTime()));
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	//Update a Toy by code
	public void update(Toy toy) throws Exception {
		if (toy == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE brinquedos set descricao=?, set categoria=?, set marca=?, set imagem=?, set valor=?, set detalhes=?, set nome=? WHERE codigo_brinquedo=? ";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, toy.getName());
			ps.setString(2, toy.getImage());
			ps.setString(3, toy.getDescription());
			ps.setDouble(4, toy.getValue());
			ps.setString(5, toy.getDetails());
			ps.setObject(6, toy.getCategory());
			ps.setString(7, toy.getBrand());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// Delete Toy By Code
	public void delete(Toy toy) throws Exception {
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
	public Toy findByCode(Toy toy) throws Exception {
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
				
				toy = new Toy(code, name, image, description, value, details, category, brand);
			}
			return toy; 
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	//List All Toys
	public List<Toy> findAll() throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM brinquedos");
			ps.setInt(1, toy.getCode());
			List<Toy> toyList = new ArrayList<Toy>();
			
			while (rs.next()) {
				Integer code = rs.getInt("codigo_brinquedo");
				String name = rs.getString("nome");
				String image = rs.getString("imagem");
				Double value = rs.getDouble("valor");
				String description = rs.getString("descricao");
				String category = rs.getString("categoria");
				String details = rs.getString("detalhes");
				String brand = rs.getString("marca");
				
			   toyList.add(new Toy(code, name, image, description, value, details, category, brand));
			}
			return toyList; 
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

}
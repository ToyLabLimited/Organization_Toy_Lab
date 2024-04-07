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
	// classes de banco de dados
	private Connection conn; // abre a conexao do banco de dados
	private PreparedStatement ps; // permite que scripts SQL sejam executados a partir do Java
	private ResultSet rs; // representa as tabelas
	// classe JavaBean
	private Toy toy;

	public ToyDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexao
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
	

	// metodo de salvar
	public void create(Toy toy) throws Exception {
		if (toy == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO brinquedos (descricao, categoria, marca, imagem, valor, detalhes, nome )" + "values ( ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, toy.getDescription());
			ps.setString(2, toy.getCategory());
			ps.setString(3, toy.getBrand());
			ps.setString(4, toy.getImage());
			ps.setDouble(5, toy.getValue());
			ps.setString(6, toy.getDetails());
			ps.setString(7, toy.getName());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public void update(Toy toy) throws Exception {
	    if (toy == null)
	        throw new Exception("O valor passado nao pode ser nulo");
	    try {
	        String SQL = "UPDATE brinquedos set descricao=?, categoria=?, marca=?, imagem=?, valor=?, detalhes=?, nome=? WHERE codigo_brinquedo=?";
	        ps = conn.prepareStatement(SQL);
	        ps.setString(1, toy.getDescription());
	        ps.setString(2, toy.getCategory());
	        ps.setString(3, toy.getBrand());
	        ps.setString(4, toy.getImage());
	        ps.setDouble(5, toy.getValue());
	        ps.setString(6, toy.getDetails());
	        ps.setString(7, toy.getName());
	        ps.setInt(8, toy.getCode());
	        ps.executeUpdate();
	    } catch (SQLException sqle) {
	        throw new Exception("Erro ao alterar dados " + sqle);
	    } finally {
	        ConnectionFactory.closeConnection(conn, ps);
	    }
	}
	
	public void delete(Toy toy) throws Exception {
		if (toy == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE FROM brinquedos WHERE codigo_brinquedo=?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, toy.getCode());
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}


	
	public List<Toy> findAll() throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM brinquedos");
			rs = ps.executeQuery();
			List<Toy> list = new ArrayList<Toy>();
			
			while (rs.next()) {
				int code = rs.getInt("codigo_brinquedo");
				String description = rs.getString("descricao");
				String category = rs.getString("categoria");
				String brand = rs.getString("marca");
				String image = rs.getString("imagem");
				Double value = rs.getDouble("valor");
				String details = rs.getString("detalhes");
				String name = rs.getString("nome");
				
				list.add(new Toy(code, name,  image, description, value, details, category, brand));
			}
			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	

	
	public Toy findByCode(Toy toy) throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM brinquedos WHERE codigo_brinquedo=?");
			ps.setInt(1, toy.getCode());
			rs = ps.executeQuery();
			while (rs.next()) {
				int code = rs.getInt("codigo_brinquedo");
				String description = rs.getString("descricao");
				String category = rs.getString("categoria");
				String brand = rs.getString("marca");
				String image = rs.getString("imagem");
				Double value = rs.getDouble("valor");
				String details = rs.getString("detalhes");
				String name = rs.getString("nome");
				toy = new Toy(code, name,  image, description, value, details, category, brand);
			
			}
			return toy;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	public List<Toy> findAllByCategory(String toyCategory) throws Exception{
		try {
			ps = conn.prepareStatement("SELECT * FROM brinquedos WHERE categoria = ?");
			ps.setString(1, toyCategory);
			rs = ps.executeQuery();
			List<Toy> list = new ArrayList<Toy>();
			while (rs.next()) {
				int code = rs.getInt("codigo_brinquedo");
				String description = rs.getString("descricao");
				String category = rs.getString("categoria");
				String brand = rs.getString("marca");
				String image = rs.getString("imagem");
				Double value = rs.getDouble("valor");
				String details = rs.getString("detalhes");
				String name = rs.getString("nome");
				list.add(new Toy(code, name,  image, description, value, details, category, brand));
			
			}
			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	
	}
}





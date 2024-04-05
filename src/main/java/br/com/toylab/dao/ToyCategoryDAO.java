package br.com.toylab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.toylab.model.Category;
import br.com.toylab.model.Toy;
import br.com.toylab.util.ConnectionFactory;

public class ToyCategoryDAO {
	private Connection conn; 
	private PreparedStatement ps; 
	private ResultSet rs; 
	Toy toy;

	public ToyCategoryDAO(Integer toycode, Integer categoryCode) throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			throw new SQLException("SQL error: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception("Unexpected error: " + e.getMessage());
		}
	}

	
	public Boolean toyCategoryInsert(Toy toy, Category category) throws Exception {
		if (toy == null && category == null)
			throw new Exception("The value don't can be null");
		try {
			String SQL = "INSERT INTO toy_category (toy_code_fk, category_code_fk) VALUES (?, ?)";
			ps = conn.prepareStatement(SQL);
			
			ps.setInt(1, toy.getCode());
			ps.setInt(2, category.getId());
			
			if (ps.executeUpdate() > 0) 
				return true;
			return false;
		} catch (SQLException e) {
			throw new SQLException("SQL error: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception("Unexpected error: " + e.getMessage());
		}
	}
	
	public Boolean toyCategoryDelete(Toy toy) throws Exception {
		if (toy == null)
			throw new Exception("The value don't can be null");
		try {		
			String SQL = "DELETE FROM toy_category WHERE toy_code_fk = ?";
			ps = conn.prepareStatement(SQL);
			
			ps.setInt(1, toy.getCode());
			
			if (ps.executeUpdate() > 0) 
				return true;
			return false;
		} catch (SQLException e) {
			throw new SQLException("SQL error: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception("Unexpected error: " + e.getMessage());
		}
	}
	
	public Boolean toyCategoryDelete(Category category) throws Exception {
		if (category == null)
			throw new Exception("The value don't can be null");
		try {
			
			String SQL = "DELETE FROM toy_category WHERE category_code_fk = ?";
			ps = conn.prepareStatement(SQL);
			
			ps.setInt(1, category.getId());
			
			if (ps.executeUpdate() > 0) 
				return true;
			return false;
		} catch (SQLException e) {
			throw new SQLException("SQL error: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception("Unexpected error: " + e.getMessage());
		}
	}
	

	
	public List<Toy> ToysByCategory(String categoryName) throws SQLException, Exception {
	    String query = "SELECT t.code, t.name, t.image, t.description, t.value, t.details, t.category, t.brand " +
	                   "FROM toy_table AS t " +
	                   "INNER JOIN toy_category AS tc ON tc.toy_fk_code = t.code " +
	                   "INNER JOIN category_table AS c ON tc.category_fk_code = c.category_code " +
	                   "WHERE c.category_name = ?";
	    
	    List<Toy> toys = new ArrayList<>();
	    
	    try (PreparedStatement ps = conn.prepareStatement(query)) {
	        ps.setString(1, categoryName);
	        
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Integer toyCode = rs.getInt("code");
	                String toyName = rs.getString("name");
	                String toyImage = rs.getString("image");
	                String toyDescription = rs.getString("description");
	                Double toyValue = rs.getDouble("value");
	                String toyDetails = rs.getString("details");
	                String toyCategory = rs.getString("category");
	                String toyBrand = rs.getString("brand");
	                
	                Toy toy = new Toy(toyCode, toyName, toyImage, toyDescription, toyValue, toyDetails, toyCategory, toyBrand);
	                toys.add(toy);
	            }
	        }
	    } catch (SQLException e) {
	        throw new SQLException("SQL error: " + e.getMessage());
	    } catch (Exception e) {
	        throw new Exception("Unexpected error: " + e.getMessage());
	    }
	    
	    return toys;
	}
	

	
}
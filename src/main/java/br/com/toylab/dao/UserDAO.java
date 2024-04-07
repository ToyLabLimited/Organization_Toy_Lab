package br.com.toylab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.toylab.model.Toy;
import br.com.toylab.model.User;
import br.com.toylab.util.ConnectionFactory;

public class UserDAO {

	private Connection conn; // abre a conexao do banco de dados
	private PreparedStatement ps; // permite que scripts SQL sejam executados a partir do Java
	private ResultSet rs; // representa as tabelas
	
	private User user;
	
	public UserDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexao
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
	
	public User Login(User user) throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM usuario WHERE email=? AND senha=?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			while (rs.next()) {
				int code = rs.getInt("id");
				String name = rs.getString("nome");
				String email = rs.getString("email");
				String password = rs.getString("senha");
				user = new User(code, name,  email, password, null);
			
			}
			return user;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
}

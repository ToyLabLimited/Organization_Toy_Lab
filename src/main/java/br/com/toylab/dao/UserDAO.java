package br.com.toylab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.toylab.DTO.UserDTO;
import br.com.toylab.model.Toy;
import br.com.toylab.util.ConnectionFactory;


public class UserDAO {
	// classes de banco de dados
	private Connection conn; // abre a conexao do banco de dados
	private PreparedStatement ps; // permite que scripts SQL sejam executados a partir do Java
	private ResultSet rs; // representa as tabelas
	// classe JavaBean
	private Toy toy;

	public UserDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexao
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
	
	
	public boolean authentication(UserDTO dto) throws Exception {
	    boolean authenticated = false;
	    try {
	        String SQL = "SELECT * FROM usuario WHERE email=? AND senha=?";
	        ps = conn.prepareStatement(SQL);
	        ps.setString(1, dto.getEmail());
	        ps.setString(2, dto.getPassword());
	        rs = ps.executeQuery();
	        authenticated = rs.next(); // Se houver próximo registro, a autenticação é bem-sucedida
	    } catch (SQLException sqle) {
	        throw new Exception("Erro ao autenticar usuário", sqle);
	    } finally {
	        ConnectionFactory.closeConnection(conn, ps, rs);
	    }
	    return authenticated;
	}
}



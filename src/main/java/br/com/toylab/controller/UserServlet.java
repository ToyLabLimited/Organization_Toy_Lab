package br.com.toylab.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.toylab.DTO.UserDTO;
import br.com.toylab.dao.UserDAO;



@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// metodo para conversao de String para data
	private Date strToDate(String data) throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataF = formato.parse(data);
		return dataF;
	}
	

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		UserDTO dto = new UserDTO();		
		
		String cmd = request.getParameter("cmd");
		
		try {
			if (cmd.equals("logar")){
				String emailUser = request.getParameter("email");
				String passwordUser = request.getParameter("password");
				dto.setEmail(emailUser);
				dto.setPassword(passwordUser);
				
			}
		} catch (Exception e) {
			// System.out.println("Erro na data");
			System.out.println(e.getMessage());
		}
		
		try {
		    UserDAO dao = new UserDAO();
		    boolean authenticated = dao.authentication(dto);
		    RequestDispatcher rd = null;

		    if (authenticated) {
		        HttpSession session = request.getSession(true);
		        rd = request.getRequestDispatcher("/index.html");
		        rd.forward(request, response); // Encaminhar para a página de sucesso
		    } else {
		        throw new Exception("Usuário ou senha inválidos");
		    }
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

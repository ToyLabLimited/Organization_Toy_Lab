package br.com.toylab.controller;



import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.toylab.dao.UserDAO;
import br.com.toylab.model.User;



@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			UserDAO userDAO = new UserDAO();
			RequestDispatcher rd = null;
			String cmd = request.getParameter("cmd");
			
			switch(cmd) {
			
			case"login":
				user.setEmail(request.getParameter("email"));
				user.setPassword(request.getParameter("senha"));
				User adm = userDAO.Login(user);
				if(adm.getId() != null) {
					rd = request.getRequestDispatcher("ToyServlet?cmd=listarAdm");
				}else {
					rd = request.getRequestDispatcher("index.html");
				}
			break;
			
			}
			rd.forward(request, response);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}

package br.com.toylab.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.toylab.dao.ToyDAO;
import br.com.toylab.model.Toys;

@WebServlet("/ServletToy")
public class ServletToy  extends HttpServlet {

		private static final long serialVersionUID = 1L;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}
		protected void processRequest(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Toys Toy = new Toys();
			ToyDAO dao;
			String cmd = request.getParameter("cmd");
			try {
				if (cmd.equals("incluir") || cmd.equals("atualizar")) {
					Toy.setName(request.getParameter("name"));
					Toy.setImage(request.getParameter("image"));
					Toy.setDescription(request.getParameter("description"));
					Toy.setValue(Double.parseDouble(request.getParameter("value")));
					Toy.setDetails(request.getParameter("details"));
					Toy.setCategory(request.getParameter("category"));
					Toy.setBrand(request.getParameter("brand"));

				} else {
					Toy.setCode(Integer.parseInt(request.getParameter("code")));
				}
			} catch (Exception e) {
				// System.out.println("Erro na data");
				System.out.println(e.getMessage());
			}
			try {
				dao = new ToyDAO();
				// Dispatcher - direciona para uma nova página
				RequestDispatcher rd = null;
				if (cmd.equalsIgnoreCase("incluir")) {
					dao.create(Toy);
					rd = request.getRequestDispatcher("ServletToy?cmd=listar");
				} else if (cmd.equalsIgnoreCase("listar")) {
					List<Toys> ToysList = dao.findAll();
					// sessão
					request.setAttribute("ToysList", ToysList);
					rd = request.getRequestDispatcher("jsp/mostrarToys.jsp");
				} else if (cmd.equalsIgnoreCase("atu")) {
					Toy = dao.findByCode(Toy);
					HttpSession session = request.getSession(true);
					session.setAttribute("Toy", Toy);
					rd = request.getRequestDispatcher("jsp/atualizarToy.jsp");
				} else if (cmd.equalsIgnoreCase("atualizar")) {
					dao.update(Toy);
					rd = request.getRequestDispatcher("ServletToy?cmd=listar");
				} else if (cmd.equalsIgnoreCase("exc")) {
					Toy = dao.findByCode(Toy);
					HttpSession session = request.getSession(true);
					session.setAttribute("Toy", Toy);
					rd = request.getRequestDispatcher("jsp/excluirToy.jsp");
				} else if (cmd.equalsIgnoreCase("excluir")) {
					dao.delete(Toy);
					rd = request.getRequestDispatcher("ServletToy?cmd=listar");
				}

				// executa a ação de direcionar para a página JSP
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
}

package br.com.toylab.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.toylab.dao.ToyDAO;
import br.com.toylab.model.Toy;



@WebServlet("/ToyServlet")
public class ToyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// metodo para conversao de String para data
	private Date strToDate(String data) throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataF = formato.parse(data);
		return dataF;
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Toy toy = new Toy();
		String cmd = request.getParameter("cmd");
		try {
			if (cmd.equals("incluir") || cmd.equals("atualizar")) {
				toy.setDescription(request.getParameter("descricao"));
				toy.setCategory(request.getParameter("categoria"));
				toy.setBrand(request.getParameter("marca"));
				toy.setImage(request.getParameter("imagem"));
				toy.setValue(Double.parseDouble(request.getParameter("valor")));
				toy.setDetails(request.getParameter("detalhes"));
				toy.setName(request.getParameter("nome"));
			} else {
				toy.setCode(Integer.parseInt(request.getParameter("codigo_brinquedo")));
			}
		} catch (Exception e) {
			// System.out.println("Erro na data");
			System.out.println(e.getMessage());
		}
		try {
			ToyDAO dao = new ToyDAO();
			// Dispatcher - direciona para uma nova página
			RequestDispatcher rd = null;
			if (cmd.equalsIgnoreCase("incluir")) {
				dao.create(toy);
				rd = request.getRequestDispatcher("ToyServlet?cmd=listar");
			} else if (cmd.equalsIgnoreCase("listar")) {
				List<Toy> toyList = dao.findAll();
				request.setAttribute("toyList", toyList);
				rd = request.getRequestDispatcher("jsp/mostrarBrinquedos.jsp");		
			}  else if (cmd.equalsIgnoreCase("atu")) {
				toy = dao.findByCode(toy);
				HttpSession session = request.getSession(true);
				session.setAttribute("toy", toy);
				rd = request.getRequestDispatcher("jsp/atualizarBrinquedo.jsp");
			} else if (cmd.equalsIgnoreCase("atualizar")) {
				dao.update(toy);
				rd = request.getRequestDispatcher("ToyServlet?cmd=listar");
			} else if (cmd.equalsIgnoreCase("con")) {
				toy = dao.findByCode(toy);
				HttpSession session = request.getSession(true);
				session.setAttribute("toy", toy);
				rd = request.getRequestDispatcher("jsp/consultarBrinquedo.jsp");	
			} else if (cmd.equalsIgnoreCase("exc")) {
				toy = dao.findByCode(toy);
				HttpSession session = request.getSession(true);
				session.setAttribute("toy", toy);
				rd = request.getRequestDispatcher("jsp/excluirBrinquedo.jsp");
			} else if (cmd.equalsIgnoreCase("excluir")) {
				dao.delete(toy);
				rd = request.getRequestDispatcher("ToyServlet?cmd=listar");
			}
			rd.forward(request, response);
		} catch (Exception e) {
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

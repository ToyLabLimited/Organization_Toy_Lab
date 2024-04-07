package br.com.toylab.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
import javax.servlet.http.Part;

import br.com.toylab.dao.ToyDAO;
import br.com.toylab.model.Toy;



@WebServlet("/ToyServlet")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
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
		String toyCategory = request.getParameter("category");

		    try {
		        // Verificar se cmd é nulo ou vazio
		        if (cmd == null || cmd.isEmpty()) {
		            // Se cmd for nulo, tentar listar os brinquedos por categoria
		            if (toyCategory != null && !toyCategory.isEmpty()) {
		            	toy.setCategory(request.getParameter("categoria"));
		                ToyDAO dao = new ToyDAO();
		                List<Toy> toyList = dao.findAllByCategory(toyCategory);
		                request.setAttribute("toyList", toyList );
		                RequestDispatcher rd = request.getRequestDispatcher("jsp/mostrarBrinquedos.jsp");
		                rd.forward(request, response);
		            }
		            
		            return;
		        }else {
		        	
		        	try {
		    			if (cmd.equals("incluir") || cmd.equals("atualizar")) {
		    				toy.setDescription(request.getParameter("descricao"));
		    				toy.setCategory(request.getParameter("categoria"));
		    				toy.setBrand(request.getParameter("marca"));
		    				if(cmd.equals("incluir")) {
		    				String uploadPath =  "ToyImg";
		    				File dirUpload = new File(getServletContext().getRealPath("")+uploadPath);
		    				if (!dirUpload.exists()) { dirUpload.mkdir();}
		    				Part filePart = request.getPart("imagem");
		    				String fileName = filePart.getSubmittedFileName();
		    				filePart.write(getServletContext().getRealPath("")+uploadPath+File.separator+fileName);
		    				toy.setImage("./"+uploadPath+"/"+fileName);
		    				}else {
		    				toy.setImage(request.getParameter("imagem"));
		    				}
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
		    			} else if (cmd.equalsIgnoreCase("listarAdm")) {
		    				List<Toy> toyList = dao.findAll();
		    				request.setAttribute("toyList", toyList);
		    				rd = request.getRequestDispatcher("jsp/adminMostrarBrinquedos.jsp");		
		    			}  else if (cmd.equalsIgnoreCase("atu")) {
		    				toy = dao.findByCode(toy);
		    				HttpSession session = request.getSession(true);
		    				session.setAttribute("toy", toy);
		    				rd = request.getRequestDispatcher("jsp/atualizarBrinquedo.jsp");
		    			} else if (cmd.equalsIgnoreCase("atualizar")) {
		    				toy.setCode(Integer.parseInt(request.getParameter("codigo_brinquedo")));
		    				dao.update(toy);
		    				rd = request.getRequestDispatcher("ToyServlet?cmd=listarAdmin");
		    			} else if (cmd.equalsIgnoreCase("con")) {
		    				int toyCode = Integer.parseInt(request.getParameter("id"));
		    				toy.setCode(toyCode);
		    				toy = dao.findByCode(toy);
		    				HttpSession session = request.getSession(true);
		    				session.setAttribute("toy", toy);
		    				rd = request.getRequestDispatcher("jsp/detail.jsp");	
		    			}  else if (cmd.equalsIgnoreCase("excluir")) {
		    				toy.setCode(Integer.parseInt(request.getParameter("codigo_brinquedo")));
		    				dao.delete(toy);
		    				rd = request.getRequestDispatcher("ToyServlet?cmd=listar");
		    			}
		    			rd.forward(request, response);
		    		} catch (Exception e) {
		    			System.out.println(e.getMessage());
		    		}
		        }
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

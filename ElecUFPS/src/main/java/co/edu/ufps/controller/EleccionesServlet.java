package co.edu.ufps.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.dao.EleccionDao;
import co.edu.ufps.dao.GenericDao;
import co.edu.ufps.entities.Eleccion;

@WebServlet("/EleccionesServlet")
public class EleccionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GenericDao eleccionD;

	public EleccionesServlet() {
		super();
		this.eleccionD = new EleccionDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		String action = request.getParameter("action");

		try {

			switch (action) {
			case "delete":
				delete(request, response);
				break;
			default:
				list(request, response);
				break;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	
	private void delete(HttpServletRequest request,HttpServletResponse response ) throws ServletException, SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		
		Eleccion elec=(Eleccion) eleccionD.find(id);
		
		eleccionD.delete(elec);
		response.sendRedirect("elecciones");
	}
	
	private void list(HttpServletRequest request,HttpServletResponse response ) 	throws ServletException, SQLException, IOException{
		List<Eleccion> listE = eleccionD.list();
		request.setAttribute( "listadoElecciones",listE);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EleccionesServlet/index.jsp");
		dispatcher.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

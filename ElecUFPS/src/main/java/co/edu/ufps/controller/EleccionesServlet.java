package co.edu.ufps.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.dao.EleccionDao;
import co.edu.ufps.dao.GenericDao;
import co.edu.ufps.entities.Candidato;
import co.edu.ufps.entities.Eleccion;

@WebServlet("/EleccionesServlet")
public class EleccionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GenericDao eleccionD;
	private SimpleDateFormat sdfTime;
	private SimpleDateFormat sdf;

	public EleccionesServlet() {
		super();
		this.eleccionD = new EleccionDao();
		sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		String action = request.getParameter("action");
		
		System.out.println(action);

		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insert(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				update(request, response);
				break;
			default:
				list(request, response);
				break;
			}
		} catch (SQLException | ParseException ex) {
			throw new ServletException(ex);
		} 
	}

	private void showNewForm(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException{
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("eleccion/indexE.jsp");
		dispatcher.forward(request,response);
	}

	private void insert(HttpServletRequest request,HttpServletResponse response ) throws ServletException, SQLException, IOException, ParseException{
		
		String nombre = request.getParameter("nombre");
		
		Date dateI = sdf.parse(request.getParameter("fechainicio"));
		Date dateF = sdf.parse(request.getParameter("fechafin"));
		
		String strI = sdfTime.format(dateI);
		String strF = sdfTime.format(dateF);
		
		Timestamp fechainicio = Timestamp.valueOf(strI);
		Timestamp fechafin = Timestamp.valueOf(strF);
		
		String cargo=request.getParameter("cargo");
		
		Eleccion e = new Eleccion();
		e.setNombre(nombre);
		e.setFechainicio(fechainicio);
		e.setFechafin(fechafin);
		e.setCargo(cargo);
		
		this.eleccionD.insert(e);
		this.list(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Eleccion eleccion = (Eleccion) eleccionD.find(id);
		
		request.setAttribute("eleccion",eleccion);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("eleccion/indexE.jsp");
		dispatcher.forward(request,response);		
	}

	private void update(HttpServletRequest request,HttpServletResponse response ) throws ServletException, SQLException, IOException, ParseException{
		
		int id = Integer.parseInt(request.getParameter("id")); 		
		String nombre = request.getParameter("nombre");
		
		Date dateI = sdf.parse(request.getParameter("fechainicio"));
		Date dateF = sdf.parse(request.getParameter("fechafin"));
		
		String strI = sdfTime.format(dateI);
		String strF = sdfTime.format(dateF);
		
		Timestamp fechainicio = Timestamp.valueOf(strI);
		Timestamp fechafin = Timestamp.valueOf(strF);
		
		String cargo=request.getParameter("cargo");
		
		Eleccion eleccion = new Eleccion(nombre, fechainicio, fechafin, cargo);
		eleccion.setId(id);
		
		this.eleccionD.update(eleccion);
		this.list(request, response);
	}
	
	private void delete(HttpServletRequest request,HttpServletResponse response ) throws ServletException, SQLException, IOException{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Eleccion elec=(Eleccion) eleccionD.find(id);
		
		eleccionD.delete(elec);
		this.list(request, response);
	}
	
	private void list(HttpServletRequest request,HttpServletResponse response ) 	throws ServletException, SQLException, IOException{
		
		List<Eleccion> listE = eleccionD.list();
		request.setAttribute( "listadoElecciones",listE);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("eleccion/listE.jsp");
		dispatcher.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

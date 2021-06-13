package co.edu.ufps.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.dao.EleccionDao;
import co.edu.ufps.dao.EstamentoDao;
import co.edu.ufps.dao.GenericDao;
import co.edu.ufps.dao.TipoDao;
import co.edu.ufps.dao.VotanteDao;
import co.edu.ufps.entities.Eleccion;
import co.edu.ufps.entities.Estamento;
import co.edu.ufps.entities.Tipodocumento;
import co.edu.ufps.entities.Votante;

@WebServlet("/VotanteServlet")
public class VotanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GenericDao newvotante;
	private GenericDao newTipo;
	private GenericDao newEleccion;
	private GenericDao newEstamento;
	
    public VotanteServlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
		this.newvotante = new VotanteDao();
		this.newTipo = new TipoDao();
		this.newEleccion = new EleccionDao();
		this.newEstamento = new EstamentoDao();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Estamento> estamentoList = newEstamento.list();
		request.setAttribute("estamentoList", estamentoList);
		
		List<Tipodocumento> tipoList= newTipo.list();
		request.setAttribute("tipoList", tipoList);
		
		List<Eleccion> elecionList = newEleccion.list();
		request.setAttribute("elecionList", elecionList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("votante/indexV.jsp");
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		
		int idE = Integer.parseInt(request.getParameter("eleccion"));
		int idT = Integer.parseInt(request.getParameter("tipodocumento"));
		
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		
		Tipodocumento tipodocumento = (Tipodocumento) newTipo.find(idT);
		Eleccion eleccion = (Eleccion) newEleccion.find(idE);
		
		Votante votante = new Votante(nombre, email, documento, tipodocumento, eleccion);

		newvotante.insert(votante);
		this.list(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)	throws SQLException, ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Votante votante =  (Votante) newvotante.find(id);

		List<Estamento> estamento = newEstamento.list();
		request.setAttribute("estamento", estamento);
		
		List<Tipodocumento> tipodocumento= newTipo.list();
		request.setAttribute("tipodocumento", tipodocumento);
		
		List<Eleccion> eleccion = newEleccion.list();
		request.setAttribute("eleccion", eleccion);
		
		request.setAttribute("Votante", votante);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("votante/indexV.jsp");		
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		
		int idE = Integer.parseInt(request.getParameter("eleccion"));
		Eleccion eleccion = (Eleccion) newEleccion.find(idE);
		
		int idT = Integer.parseInt(request.getParameter("tipodocumento"));
		Tipodocumento tipodocumento = (Tipodocumento) newTipo.find(idT);
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String documento = request.getParameter("documento");
		
		Votante votante = new Votante(nombre, email, documento, tipodocumento, eleccion);
		votante.setId(id);
		
		newvotante.update(votante);
		this.list(request, response);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Votante votante = (Votante) newvotante.find(id);
		
		newvotante.delete(votante);
		this.list(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		
		List<Votante> listaVotante = newvotante.list();
		
		request.setAttribute("listaVotante", listaVotante);
		RequestDispatcher dispatcher = request.getRequestDispatcher("votante/listV.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

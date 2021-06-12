package co.edu.ufps.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.dao.CandidatoDao;
import co.edu.ufps.dao.EleccionDao;
import co.edu.ufps.dao.GenericDao;
import co.edu.ufps.dao.VotanteDao;

@WebServlet("/CandidatoServlet")
public class CandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private GenericDao newEleccion;
	private GenericDao newCandidato;
    
    public CandidatoServlet() {
        super();     
    }

    public void init(ServletConfig config) throws ServletException {
		this.newEleccion = new EleccionDao();
		this.newCandidato = new CandidatoDao();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}

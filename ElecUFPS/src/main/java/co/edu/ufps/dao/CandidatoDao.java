package co.edu.ufps.dao;

import co.edu.ufps.entities.Candidato;
import co.edu.ufps.util.Conexion;

public class CandidatoDao extends Conexion<Candidato> implements GenericDao<Candidato> {

	private static final long serialVersionUID = 1L;
	
	public CandidatoDao() {
		super(Candidato.class);
	}
}

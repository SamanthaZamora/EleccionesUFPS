package co.edu.ufps.dao;

import co.edu.ufps.entities.Votante;
import co.edu.ufps.util.Conexion;

public class VotanteDao extends Conexion<Votante> implements GenericDao<Votante> {

	private static final long serialVersionUID = 1L;

	public VotanteDao() {
		super(Votante.class);
	}

}
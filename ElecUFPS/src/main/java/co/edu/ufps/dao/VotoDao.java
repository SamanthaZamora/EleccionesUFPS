package co.edu.ufps.dao;

import co.edu.ufps.entities.Voto;
import co.edu.ufps.util.Conexion;

public class VotoDao extends Conexion<Voto> implements GenericDao<Voto> {

	private static final long serialVersionUID = 1L;

	public VotoDao() {
		super(Voto.class);
	}

}

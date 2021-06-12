package co.edu.ufps.dao;

import co.edu.ufps.entities.Tipodocumento;
import co.edu.ufps.util.Conexion;


public class TipoDao extends Conexion<Tipodocumento> implements GenericDao<Tipodocumento> {
	
	private static final long serialVersionUID = 1L;
	
	public TipoDao() {
		super(Tipodocumento.class);
	}
}

package co.edu.ufps.dao;

import co.edu.ufps.entities.Eleccion;
import co.edu.ufps.util.Conexion;

public class EleccionDao extends Conexion<Eleccion> implements GenericDao<Eleccion> {

	private static final long serialVersionUID = 1L;

	public EleccionDao() {
		super(Eleccion.class);
	}
}
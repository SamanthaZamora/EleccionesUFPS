package co.edu.ufps.dao;

import co.edu.ufps.entities.Estamento;
import co.edu.ufps.util.Conexion;

public class EstamentoDao extends Conexion<Estamento> implements GenericDao<Estamento> {

	private static final long serialVersionUID = 1L;

	public EstamentoDao() {
		super(Estamento.class);
	}

}

package co.edu.ufps.util;

import java.util.List;

import co.edu.ufps.dao.EstamentoDao;
import co.edu.ufps.entities.Estamento;

public class Test {
	
	public static void main(String[] args) {
		
		EstamentoDao eDao = new EstamentoDao();
		
		List<Estamento> listE = eDao.list();
		
		for(Estamento est : listE) {
			System.out.println(est.getDescripcion());
		}
	}
}

package co.edu.ufps.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@NamedQuery(name="Tipodocumento.findAll", query="SELECT t FROM Tipodocumento t")
public class Tipodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	@OneToMany(mappedBy="tipodocumentoBean")
	private List<Votante> votantes;

	//contructor 2
	public Tipodocumento(String descripcion, List<Votante> votantes) {
		super();
		this.descripcion = descripcion;
		this.votantes = votantes;
	}

	//métodos 
	public Votante addVotante(Votante votante) {
		getVotantes().add(votante);
		votante.setTipodocumentoBean(this);

		return votante;
	}

	public Votante removeVotante(Votante votante) {
		getVotantes().remove(votante);
		votante.setTipodocumentoBean(null);

		return votante;
	}
}
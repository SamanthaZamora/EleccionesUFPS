package co.edu.ufps.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@NamedQuery(name="Eleccion.findAll", query="SELECT e FROM Eleccion e")
public class Eleccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nombre;

	//@Temporal(TemporalType.DATE)
	private Timestamp fechafin;

	//@Temporal(TemporalType.DATE)
	private Timestamp fechainicio;

	private String cargo;

	@OneToMany(mappedBy="eleccionBean")
	private List<Candidato> candidatos;

	@OneToMany(mappedBy="eleccionBean")
	private List<Estamento> estamentos;

	@OneToMany(mappedBy="eleccionBean")
	private List<Votante> votantes;

	//contructor 2
	public Eleccion(String nombre, Timestamp  fechafin, Timestamp  fechainicio, String cargo) {
		super();
		this.nombre = nombre;
		this.fechafin = fechafin;
		this.fechainicio = fechainicio;
		this.cargo = cargo;
	}
	
	//métodos opción
	public Candidato addCandidato(Candidato candidato) {
		getCandidatos().add(candidato);
		candidato.setEleccionBean(this);

		return candidato;
	}

	public Candidato removeCandidato(Candidato candidato) {
		getCandidatos().remove(candidato);
		candidato.setEleccionBean(null);

		return candidato;
	}

	public Estamento addEstamento(Estamento estamento) {
		getEstamentos().add(estamento);
		estamento.setEleccionBean(this);

		return estamento;
	}

	public Estamento removeEstamento(Estamento estamento) {
		getEstamentos().remove(estamento);
		estamento.setEleccionBean(null);

		return estamento;
	}

	public Votante addVotante(Votante votante) {
		getVotantes().add(votante);
		votante.setEleccionBean(this);

		return votante;
	}

	public Votante removeVotante(Votante votante) {
		getVotantes().remove(votante);
		votante.setEleccionBean(null);

		return votante;
	}
}
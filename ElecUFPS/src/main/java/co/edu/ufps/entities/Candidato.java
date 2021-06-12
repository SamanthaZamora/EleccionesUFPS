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
@NamedQuery(name="Candidato.findAll", query="SELECT c FROM Candidato c")
public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String documento;
	
	private String nombre;

	private String apellido;

	private int numero;

	@ManyToOne
	@JoinColumn(name="eleccion")
	private Eleccion eleccionBean;

	@OneToMany(mappedBy="candidatoBean")
	private List<Voto> votos;

	//contructor repuesto
	public Candidato(String documento, String nombre, String apellido, int numero, Eleccion eleccionBean) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numero = numero;
		this.eleccionBean = eleccionBean;
	}

	//métodos voto
	public Voto addVoto(Voto voto) {
		getVotos().add(voto);
		voto.setCandidatoBean(this);

		return voto;
	}

	public Voto removeVoto(Voto voto) {
		getVotos().remove(voto);
		voto.setCandidatoBean(null);

		return voto;
	}

}
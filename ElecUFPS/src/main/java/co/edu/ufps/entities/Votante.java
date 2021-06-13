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
@NamedQuery(name="Votante.findAll", query="SELECT v FROM Votante v")
public class Votante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nombre;
	
	private String email;
	
	private String documento;

	@ManyToOne
	@JoinColumn(name="eleccion")
	private Eleccion eleccionBean;

	@ManyToOne
	@JoinColumn(name="tipodocumento")
	private Tipodocumento tipodocumentoBean;

	@OneToMany(mappedBy="votanteBean")
	private List<Voto> votos;

	//contructor 2
	public Votante(String nombre, String email, String documento, 
			Tipodocumento tipodocumentoBean, Eleccion eleccionBean) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.documento = documento;
		this.eleccionBean = eleccionBean;
		this.tipodocumentoBean = tipodocumentoBean;		
	}

	//métodos 
	public Voto addVoto(Voto voto) {
		getVotos().add(voto);
		voto.setVotanteBean(this);

		return voto;
	}

	public Voto removeVoto(Voto voto) {
		getVotos().remove(voto);
		voto.setVotanteBean(null);

		return voto;
	}
}
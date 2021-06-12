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
@NamedQuery(name="Estamento.findAll", query="SELECT e FROM Estamento e")
public class Estamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	@ManyToOne
	@JoinColumn(name="eleccion")
	private Eleccion eleccionBean;

	@OneToMany(mappedBy="estamentoBean")
	private List<Voto> votos;

	//contructor 2
	public Estamento(String descripcion, Eleccion eleccionBean) {
		super();
		this.descripcion = descripcion;
		this.eleccionBean = eleccionBean;
	}

	//métodos opción
	public Voto addVoto(Voto voto) {
		getVotos().add(voto);
		voto.setEstamentoBean(this);

		return voto;
	}

	public Voto removeVoto(Voto voto) {
		getVotos().remove(voto);
		voto.setEstamentoBean(null);

		return voto;
	}
}
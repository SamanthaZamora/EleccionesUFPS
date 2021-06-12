package co.edu.ufps.entities;

import java.io.Serializable;
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
@NamedQuery(name="Voto.findAll", query="SELECT v FROM Voto v")
public class Voto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fechacreacion;

	@Temporal(TemporalType.DATE)
	private Date fechavoto;

	private String uuid;
	
	private String enlace;

	@ManyToOne
	@JoinColumn(name="candidato")
	private Candidato candidatoBean;

	@ManyToOne
	@JoinColumn(name="estamento")
	private Estamento estamentoBean;

	@ManyToOne
	@JoinColumn(name="votante")
	private Votante votanteBean;

	//contrutor 2
	public Voto(Date fechacreacion, Date fechavoto, String uuid, String enlace, Candidato candidatoBean,
			Estamento estamentoBean, Votante votanteBean) {
		super();
		this.fechacreacion = fechacreacion;
		this.fechavoto = fechavoto;
		this.uuid = uuid;
		this.enlace = enlace;
		this.candidatoBean = candidatoBean;
		this.estamentoBean = estamentoBean;
		this.votanteBean = votanteBean;
	}
}
package br.unibh.escola.entidades;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.DefaultValue;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="TB_SALA",
uniqueConstraints = @UniqueConstraint(columnNames="codigo"))

@NamedQueries({
@NamedQuery(name="Sala.findByName", query = "select a from Sala a where "
		+ "a.codigo like :codigo")
})

public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@NotBlank
	@Column(nullable = false, columnDefinition = "CHAR(5)")
	private String codigo;
	

	@NotNull
	@DecimalMin("4")
	@DecimalMax("60")
	private int capacidade;
	
	
	@Column(name = "possui_quadro_branco", nullable=false)
	private Boolean possuiQuadroBranco;
	
	
	@Column(name = "possui_data_show", nullable=false)
	private Boolean possuiDataShow;

	
	@Column(name = "possui_computador",nullable=false)
	private Boolean possuiComputador;
	
	
	
	@Size(max=255)
	@Column(nullable = true, columnDefinition = "VARCHAR(255)")
	private String observacao;
	
	
	@NotNull
	@Column(nullable = false)
	private int status;
	
	
	@Column(name = "data_termino_manutencao",nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dataTerminoManutencao;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public int getCapacidade() {
		return capacidade;
	}


	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}


	public Boolean getPossuiQuadroBranco() {
		return possuiQuadroBranco;
	}


	public void setPossuiQuadroBranco(Boolean possuiQuadroBranco) {
		this.possuiQuadroBranco = possuiQuadroBranco;
	}


	public Boolean getPossuiDataShow() {
		return possuiDataShow;
	}


	public void setPossuiDataShow(Boolean possuiDataShow) {
		this.possuiDataShow = possuiDataShow;
	}


	public Boolean getPossuiComputador() {
		return possuiComputador;
	}


	public void setPossuiComputador(Boolean possuiComputador) {
		this.possuiComputador = possuiComputador;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public int getStatus() {
		
			
		return status;
	}


	public void setStatus(int status) {
		
		this.status = status;
	}


	public Date getDataTerminoManutencao() {
		return dataTerminoManutencao;
	}
	
	private String possui;


	public void setDataTerminoManutencao(Date dataTerminoManutencao) {
		this.dataTerminoManutencao = dataTerminoManutencao;
	}


	@Override
	public String toString() {
		return "Sala [id=" + id + ", codigo=" + codigo + ", capacidade=" + capacidade + ", possuiQuadroBranco="
				+ possuiQuadroBranco + ", possuiDataShow=" + possuiDataShow + ", possuiComputador=" + possuiComputador
				+ ", observacao=" + observacao + ", status=" + status + ", dataTerminoManutencao="
				+ dataTerminoManutencao + "]";
	}


	public String statusToString(int status) {
		if (getStatus() == 1){
			possui = "Ativo";
		} else if (getStatus() == 2){
			possui = "Em Manutencao";
		} else {
			possui = "Desativado";
		}
		return possui;
	}


}

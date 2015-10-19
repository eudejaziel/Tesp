package br.unibh.escola.entidades;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


// 200 alunos
// 

@Entity
@PrimaryKeyJoinColumn
@Table(name="TB_ALUNO",uniqueConstraints = @UniqueConstraint(columnNames="matricula"))

@NamedQueries({
@NamedQuery(name="Aluno.findByName", query = "select a from Aluno a where "
		+ "a.nome like :nome")
})
public class Aluno extends Pessoa  {
	
	@Pattern(regexp = "[\\w]*", message = "Forncecer apenas caracteres e digitos")
	@Size(max=8)
	@Column(length=8,name = "matricula",  columnDefinition = "char(8)",nullable=false)
	@NotBlank
	private String matricula;


	@Column(name = "data_aniversario",nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dataaniversaio;

	// coltr+shif+f Formata o codigo

	public Aluno() {
	}

	public Aluno(Long id, String nome, String cpf, String matricula, Date dataaniversaio) {
		super(id, nome, cpf);
		this.matricula = matricula;
		this.dataaniversaio = dataaniversaio;
	}

	public Aluno(String matricula, Date dataaniversaio) {
		super();
		this.matricula = matricula;
		this.dataaniversaio = dataaniversaio;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", dataaniversaio=" + dataaniversaio + ", toString()="
				+ super.toString() + "]";
	}

	public Date getDataaniversaio() {
		return dataaniversaio;

	}

	public void setDataaniversaio(Date dataaniversaio) {
		this.dataaniversaio = dataaniversaio;

	}

	public String getMatricula() {
		return matricula;

	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}

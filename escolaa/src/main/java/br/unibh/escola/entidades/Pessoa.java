package br.unibh.escola.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

//coltr+shif+f Formata o codigo

@Entity
@Inheritance(strategy=InheritanceType.JOINED) 
@Table(name="TB_PESSOA",
uniqueConstraints = @UniqueConstraint(columnNames="cpf"))

public class Pessoa  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length=100,nullable=false,columnDefinition = "varchar(100)")
	@NotBlank
	@Size(min=5,max=100)
	@Pattern(regexp="[A-Za-zÀ-ú ]*",message="Fornce apenas caracteres A-Z a-z Á-ú")
	private String nome;

	@NotBlank
	@Pattern(regexp="\\d{11}",message="Fornce 11 digitos do CPF")
	@Size(min=11,max=11)
	@Column(length=100,nullable=false,columnDefinition = "char(11)")
	private String cpf;
	
	

	public Pessoa() {
	}

	public Pessoa(Long id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Pessoa(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", getId()=" + getId() + ", getNome()="
				+ getNome() + ", getCpf()=" + getCpf() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}

package br.unibh.escola.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Classe Concreta de Professor
 * @author eude
 * @version 1.0
 *
 */

@Entity
@PrimaryKeyJoinColumn
@Table(name="TB_PROFESSOR")
public class Professor extends Pessoa  {
	
		// Variaveis de Instancia
	
	@DecimalMax("500.00")
	@DecimalMin("10000.00")
	@Column(nullable=true, columnDefinition = "decimal(14,2)")
	private BigDecimal salario ; // trabalha melhor com numeros fracionarios
	
	private static Double BONUS=0.1D;
	
	// Construtores
	/**
	 * Construtor padr�o
	 */
	public Professor(){}
	
	/**
	 * 
	 * @param Super salario
	 */
	public Professor(BigDecimal salario) {
		super();
		this.salario = salario;
	}
	/**
	 * 
	 * @param id identifica��o
	 * @param nome do professor
	 * @param cpf do professor
	 * @param salario do professor
	 */
	public Professor(Long id, String nome, String cpf, BigDecimal salario) {
		super(id, nome, cpf);
		this.salario = salario;
	}

	//ToString 
	/**
	 * @To.String chama o super da classe
	 */
	@Override
	public String toString() {
		return "Professor [salario=" + salario + ", getSalario()=" + getSalario() + ", toString()=" + super.toString()
				+ ", getId()=" + getId() + ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	// Gets e Sets
	
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	

	public BigDecimal getSalario() {
		return salario;
	}
}

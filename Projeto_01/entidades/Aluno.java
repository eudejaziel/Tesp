package br.unibh.entidades;

import java.util.Date;

public class Aluno extends Pessoa {
	
	private String matricula;
	private Date dataaniversaio;
	
	
	public Aluno(){}
	
	
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
		return "Aluno [matricula=" + matricula + ", dataaniversaio=" + dataaniversaio + ", getMatricula()="
				+ getMatricula() + ", getDataaniversaio()=" + getDataaniversaio() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
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

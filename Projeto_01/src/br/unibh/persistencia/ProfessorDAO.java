package br.unibh.persistencia;

import java.util.List;

import br.unibh.entidades.Professor;

public class ProfessorDAO implements DAO<Professor,Long> {

	// Professor  , Long e subustituido por T e K na classe DAO
	// T e K e curinga pra chamar a Classe e o parametro geralmente ID da classe
	
	@Override
	public Professor find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Professor t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Professor t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Professor t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Professor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

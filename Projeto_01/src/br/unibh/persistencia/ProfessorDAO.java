package br.unibh.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.unibh.entidades.Aluno;
import br.unibh.entidades.Professor;

public class ProfessorDAO implements DAO<Professor,Long> {
	
	private static Connection con =null;


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
		
	
		ArrayList <Professor> listaa = new ArrayList<Professor>();
		try {
			con=JDBCUtil.getConnection();
			ResultSet res=con.prepareStatement(
					 "Select * from tb_professor").executeQuery();
			
			while(res.next()){
				listaa.add(new Professor(
						       res.getLong("id"),
								res.getString("nome"),
								res.getString("cpf"),
								res.getBigDecimal("salario")));
			
	}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.closeConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return listaa;
	}
}

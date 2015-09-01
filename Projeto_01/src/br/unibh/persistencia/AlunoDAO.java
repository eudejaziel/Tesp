package br.unibh.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import br.unibh.entidades.Aluno;

public class AlunoDAO implements DAO<Aluno,Long>{
	
	
	// Aluno , Long e subustituido por T e K na classe DAO
	// T e K e curinga pra chamar a Classe e o parametro geralmente ID da classe

	@Override
	public Aluno find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Aluno t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Aluno t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Aluno t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Aluno> findAll() {
		
		ArrayList <Aluno> lista = new ArrayList<Aluno>();
		
		try {
			
			ResultSet res=JDBCUtil.getConnection().prepareStatement(
					 "Select * from tb_aluno").executeQuery();
			
			while(res.next()){
				lista.add(new Aluno(
						res.getLong("id"),
						res.getString("nome"),
						res.getString("cpf"),
						res.getString("matricula"),
						res.getDate("dataaniversaio")));
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
			
		}
		// TODO Auto-generated method stub
		return lista;
	}

}

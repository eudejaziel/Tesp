package br.unibh.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;
import java.sql.PreparedStatement;

import br.unibh.entidades.Aluno;

public class AlunoDAO implements DAO<Aluno,Long>{
	
	
	public static SimpleDateFormat df=
			new SimpleDateFormat("yyyy-MM-dd");
	
	// Aluno , Long e subustituido por T e K na classe DAO
	// T e K e curinga pra chamar a Classe e o parametro geralmente ID da classe

	@Override
	public Aluno find(Long id) {
		
try {
			
		PreparedStatement p = JDBCUtil.getConnection().prepareStatement(
					 "Select * from tb_aluno where id=?");
					p.setLong(1, id);
			ResultSet res= p.executeQuery();
			if(res.next()){
				return new Aluno (
						res.getLong("id"),
						res.getString("nome"),
						res.getString("cpf"),
						res.getString("matricula"),
						res.getDate("dataaniversaio"));							
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
			
		}	return null;
	}
	
	public Aluno find(String nome) {
		
		try {
					
				PreparedStatement p = JDBCUtil.getConnection().prepareStatement(
							 "Select * from tb_aluno where nome like?");
							p.setString(1, nome);
					ResultSet res= p.executeQuery();
					if(res.next()){
						return new Aluno (
								res.getLong("id"),
								res.getString("nome"),
								res.getString("cpf"),
								res.getString("matricula"),
								res.getDate("dataaniversaio"));
							}
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					JDBCUtil.closeConnection();
					
				}
						
				return null;
			}

	@Override
	public void insert(Aluno t) {

		try {
			
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement(
						 "insert into  tb_aluno"
						 + " (nome,cpf,matricula,dataaniversaio)"
								 +"values (?,?,?,?"); 
						 
						p.setString(1,t.getNome());
						p.setString(2,t.getCpf());
						p.setString(3,t.getMatricula());
						p.setString(4,df.format(t.getDataaniversaio()));
						p.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				JDBCUtil.closeConnection();
			}	
					
		
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

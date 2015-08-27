package br.unibh.teste;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import br.unibh.entidades.Aluno;
import br.unibh.entidades.Professor;
import br.unibh.persistencia.AlunoDAO;
import br.unibh.persistencia.JDBCUtil;



public class Main {

	public static void main(String[] args) {
		
		AlunoDAO dao =new  AlunoDAO();
		List <Aluno> lista = dao.findAll();
		for (Aluno a:lista){
		System.out.println(a);
		
		try {
			Connection c = JDBCUtil.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			
			
		}
		}
		
	}

}

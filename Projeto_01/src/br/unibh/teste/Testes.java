package br.unibh.teste;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.Assert;
import br.unibh.entidades.Aluno;
import br.unibh.persistencia.AlunoDAO;

// para testar automatizado tem que colocar o @Test


public class Testes {

	@Test
	public void testeAlunoFindAll() {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 103); // 

	}
	
	@Test
	public void testeAlunoFind(){
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(2L); // id 2 L = tipo Long
		Assert.assertEquals(a.getNome(),"Jordan S. Pena");
		// Vai verificar se na linha 2 exisi Jordam
		
	}
	
	@Test
	public void testeAlunoInsertEDelete(){
		AlunoDAO dao = new AlunoDAO();
		Aluno a = new Aluno(null,"beltrano", "78312382312", "24234234",new Date());
		
		dao.insert(a);
		
		Aluno b = dao.find("beltrano");
		b.setNome("eudeJ");
		dao.update(b);
			
		dao.delete(b);
		Aluno c = dao.find("eudeJ");
		
		
		// Vai verificar se na linha 2 exisi Jordam
		
	}
}

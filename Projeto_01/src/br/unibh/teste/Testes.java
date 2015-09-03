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
		Assert.assertEquals(lista.size(), 105); // 

	}
	
	@Test
	public void testeAlunoFind(){
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(2L); // id 2 L = tipo Long
		Assert.assertEquals(a.getNome(),"Jordan S. Pena");
		// Vai verificar se na linha 2 exisi Jordam
		
	}
	
	@Test
	public void testeAlunoInsert(){
		AlunoDAO dao = new AlunoDAO();
		Aluno a = new Aluno(null,"Meude", "77312382312", "24234234",new Date());
		dao.insert(a);
		Aluno b = dao.find("Erich R. Dale");
		Assert.assertNotNull(b);
		// Vai verificar se na linha 2 exisi Jordam
		
	}
}

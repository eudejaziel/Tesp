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
		Assert.assertEquals(lista.size(), 104); // 

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
		Aluno a = new Aluno(null,"beltrano", "79312382312", "24234234",new Date());
		
		dao.insert(a); //vai inserir o objeto a que sãos os dados acima de aluno
		
		Aluno b = dao.find("beltrano"); // vai selecionar atraves do ID e trazer o nome
		
		b.setNome("eudeJ"); // vai fazer select buscando com like pelo SetNome
		dao.update(b); // Vai fazer update no banco trocando beltrano por EudeJ
			
		dao.delete(b); // vai deleter no banco por id
		Assert.assertNotNull(b); // vai verifcar se existe no banco não tendo volta null
		
		
		
		// PROGRAMA FINALIZADO
		
	}
}

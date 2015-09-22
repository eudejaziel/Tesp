package br.unibh.teste;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.Assert;
import br.unibh.entidades.Aluno;
import br.unibh.entidades.Professor;
import br.unibh.persistencia.AlunoDAO;
import br.unibh.persistencia.ProfessorDAO;

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
	public void testeAlunoInsertUpdateDelete(){
		AlunoDAO dao = new AlunoDAO();
		Aluno a = new Aluno(null,"beltrano", "79312382312", "24234234",new Date());
		dao.insert(a); //vai inserir o objeto a que sãos os dados acima de aluno
		Aluno b = dao.find("beltrano"); // vai selecionar atraves do ID e trazer o nome
		Assert.assertNotNull(b);
		b.setNome("eudeJ"); // vai fazer select buscando com like pelo SetNome
		dao.update(b); // Vai fazer update no banco trocando beltrano por EudeJ
		Aluno c = dao.find("eudeJ"); // vai selecionar atraves do ID e trazer o nome
		Assert.assertNotNull(c);
		dao.delete(c); // vai deleter no banco por id
		Aluno d = dao.find("eudeJ"); // vai selecionar atraves do ID e trazer o nome
		Assert.assertNull(d); // vai verifcar se existe no banco não tendo volta null
				
	// falta testar aprofessor All
	}
	@Test
	public void testeProfessorFindAll() {
		ProfessorDAO dao = new ProfessorDAO();
		List<Professor> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 101); // 

	}
	
	@Test
	public void testeProfessorFind(){
		ProfessorDAO dao = new ProfessorDAO();
		Professor a = dao.find(100L); // id 2 L = tipo Long
		Assert.assertEquals(a.getNome(),"Kay A. Frye");
		// Vai verificar se na linha 2 exisi Jordam
		
	}
	
	@Test
	public void testeProfessorInsertEDelete(){
		ProfessorDAO dao = new ProfessorDAO();
		Professor pro = new Professor(null,"Eudee","98409563456",new BigDecimal(1500.00));
		dao.insert(pro); //vai inserir o objeto a que sãos os dados acima de aluno
		Professor e = dao.find("Eudee");
		Assert.assertNotNull(e);
		e.setNome("Fulaninho da Silva");
		dao.update(e);
		Professor f = dao.find("Fulaninho da Silva"); // vai selecionar atraves do ID e trazer o nome
		Assert.assertNotNull(f);
		dao.delete(f);
		Professor g = dao.find("Fulaninho da Silva"); // vai fazer select buscando com like pelo SetNome
		Assert.assertNull(g);	
		
		// Projeto OK 09.09.2015
	}
	
}

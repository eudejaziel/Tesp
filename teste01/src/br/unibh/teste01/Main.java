package br.unibh.teste01;

import java.math.BigDecimal;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		Aluno aluno1 = new Aluno(14L,"Eude JAzie","232144356","342523423",new Date());
		System.out.println(aluno1);
		
		Professor  professor01 = new Professor(15L,"Jose Humberto","23423423a", new BigDecimal(1000));
		
		
	}

}

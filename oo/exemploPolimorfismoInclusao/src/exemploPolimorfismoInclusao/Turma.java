package exemploPolimorfismoInclusao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Turma {
	private int codigo;
	private String descricao;
	
	//Conjunto de referencias de alunos
	//Aluno[] als = new Aluno[0];
	List<Aluno> als;
	
	public Turma() {
		als = new LinkedList<Aluno>();
	}
	
	public Turma(int cod, String desc) {
		this();
		codigo = cod;
		descricao = desc;
	}

	public boolean matricular (Aluno a) {
		boolean resposta = als.add(a);
		return resposta;
	}
	
	public boolean desmatricular (Aluno a) {
		boolean resposta = als.remove(a);
		return resposta;
	}
	
	public Aluno pesquisarAluno(String nome) {
		Iterator<Aluno> it = als.iterator();
		Aluno resposta = null;
		while (it.hasNext()) {
			Aluno a = it.next();
			if (a.getNome().equalsIgnoreCase(nome)) {
				resposta = a;
				return resposta;
			}
		}
		return resposta;
	}

	public void imprimirTurma() {
		for (Aluno a : als) {
			System.out.println(a);
		}
	}
	
	

}

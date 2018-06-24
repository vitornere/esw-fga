package exemploPolimorfismoInclusao;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		Turma t = new Turma( 1, "Orientacao por Objetos");
		
		do {
			String nome = JOptionPane.showInputDialog("Nome do aluno:");
			int matricula = Integer.parseInt(JOptionPane.showInputDialog("Matricula:"));
			String email = JOptionPane.showInputDialog("email do aluno:");
			
			Aluno a = new Aluno(nome, matricula, email);
			
			t.matricular(a);
		} while (JOptionPane.showConfirmDialog(null, "Deseja matricular outro aluno?") == JOptionPane.YES_OPTION);
		
		do {
			String nome = JOptionPane.showInputDialog("Nome do aluno a ser pesquisado:");
			
			Aluno a = t.pesquisarAluno(nome);
			JOptionPane.showMessageDialog(null, a);
			
		} while (JOptionPane.showConfirmDialog(null, "Deseja pesquisar outro aluno?") == JOptionPane.YES_OPTION);		
		
	}
}

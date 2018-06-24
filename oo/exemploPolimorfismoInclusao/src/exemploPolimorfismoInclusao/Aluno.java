package exemploPolimorfismoInclusao;

public class Aluno {
	
	private String nome;
	private int matricula;
	private String email;
	
	public Aluno(String nome, int matricula, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
	}
	
	public String toString() {
		String resposta = "";
		resposta += "Aluno: " + this.nome + '\n';
		resposta += "Matricula: " + this.matricula + '\n';
		resposta += "Email: " + this.email + '\n';
		resposta += "*************";
		return resposta;
	}
	
	public String getNome() {
		return this.nome;
	}
}

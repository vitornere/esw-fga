package dadosDoCidadao;

public class Cidadao {

	/************************************************************************* 
	 * Declaracao dos atributos
	 *************************************************************************/
	String nome;
	String sexo;
	String cpf;

	private Cidadao() {
		
	}
	
	public Cidadao(String n, String s, String c) {
		nome = n; 
		sexo = s;
		cpf = c;
	}
	
	public String getNome() {
		return nome;
	}
	
	
	
	
	
	
	
}

package dadosDoCidadao;

public class Dependente {
	/****************************************************************
	 * Atributos de Dependente
	 ***************************************************************/
	String nome, 
	       sexo, 
	       cpf;
	
	float valorDeducao = 189.59f;
	
	
	
	/****************************************************************
	 * Metodos de Dependente
	 ***************************************************************/
	Dependente () {
		
	}
	
	
	Dependente (String n, String s, String c) {
		nome = n;
		sexo = s;
		cpf = c;
	}
}

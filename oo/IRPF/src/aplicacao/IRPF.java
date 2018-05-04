package aplicacao;
import javax.swing.JOptionPane;

import dadosDoCidadao.*;

import movimentacao.Deducao;
import movimentacao.Rendimento;

public class IRPF {
	
	private Cidadao cid;
	
	
	//Quantidade e valor de deducao por dependentes
	int numDependentes;
	public float baseDeCalculo;
	public Deducao[] ded;
	public Rendimento[] rend;





	/************************************************************************* 
	 * Declaracao e implementacao dos metodos
	 *************************************************************************/
	
	// Construtor alternativo
	public IRPF(String nomeContribuinte, String sexo, String cpf) {
		cid = new Cidadao(nomeContribuinte, 
				          sexo, 
				          cpf);
	}
	
	
	public boolean cadastrarRendimento() {
		boolean resposta = false;
		
		String descricao = JOptionPane.showInputDialog(
				"Informe o nome do Rendimento:");
		float valor = Float.parseFloat(
				JOptionPane.showInputDialog(
						"Informe o valor do Rendimento:")
				);
		
		Rendimento temp = new Rendimento();
		temp.setDescricao(descricao);
		temp.setValor(valor);
		
		
		int tamanho = rend.length;
		
		Rendimento[] tempRendimentos = new Rendimento[tamanho+1];
		
		for (int i=0; i<tamanho; i++) {
			tempRendimentos[i] = rend[i];
		} //fim da copia de vetores
		
		//adicionar novo rendimento
		int novaPosicao = tamanho;
		tempRendimentos[novaPosicao] = temp;
		
		rend = tempRendimentos;
		
		resposta = true;
		return resposta;
	}
	
	
	float totalRendimentos() {
		float soma = 0;
		for (Rendimento r : rend) {
			soma += r.getValor();
		}
		return soma;
	}
	
	
	public Cidadao getCidadao() {
		return cid;
	}
	
	
	
}

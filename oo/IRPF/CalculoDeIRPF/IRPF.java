import javax.swing.JOptionPane;

public class IRPF {

	//Declaracao dos atributos
	Rendimento[] rend = new Rendimento[0];
	Deducao[] ded = new Deducao[0];
	
	int numDependentes;
	float deducaoDependente = 189.59f;
	
	float baseDeCalculo; 
	Imposto[] faixas = new Imposto[0];

	
	
	//Declaracao e implementacao dos metodos
	boolean cadastrarRendimento() {
		boolean resposta = false;
		
		String descricao = JOptionPane.showInputDialog(
				"Informe o nome do Rendimento:");
		float valor = Float.parseFloat(
				JOptionPane.showInputDialog(
						"Informe o valor do Rendimento:")
				);
		
		Rendimento temp = new Rendimento();
		temp.descricao = descricao;
		temp.valor = valor;
		
		
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
			soma += r.valor;
		}
		return soma;
	}
	
}

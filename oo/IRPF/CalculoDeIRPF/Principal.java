import javax.swing.JOptionPane;

public class Principal {

	//Vetor de referencias para objetos do tipo IRPF
	//Cada posicao esta associada a declaracao de IR de um contribuinte pessoa fisica
	//Obs.: por enquanto nao se preocupe com o modificador static
	static IRPF[] contribuintes = new IRPF[0];
	
	
	
	public static void main (String[] args) {
		IRPF contribuinte1, 
		     contribuinte2; 
		
		contribuinte1 = new IRPF();
		contribuinte2 = new IRPF();
		
		int novoRendimento;
		do { 
			contribuinte1.cadastrarRendimento();
			novoRendimento = JOptionPane.showConfirmDialog(null, 
					"Deseja cadastrar novo rendimento?" , 
					"Novo rendimento?", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
		} while(novoRendimento == JOptionPane.YES_OPTION);
		
		do { 
			contribuinte2.cadastrarRendimento();
			novoRendimento = JOptionPane.showConfirmDialog(null, 
					"Deseja cadastrar novo rendimento?" , 
					"Novo rendimento?", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
		} while(novoRendimento == JOptionPane.YES_OPTION);
		
		System.out.println(contribuinte1 + ": " + contribuinte1.totalRendimentos());
		System.out.println(contribuinte2 + ": " + contribuinte2.totalRendimentos());
	}

}

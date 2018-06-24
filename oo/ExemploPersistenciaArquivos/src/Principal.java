import javax.swing.JOptionPane;


public class Principal {
	static Cadastro c;
	
	static final String opcoes[] = {
			"-- Selecione sua opcao --",
			"Cadastrar Veiculo", 
			"Pesquisar Veiculo", 
			"Deletar Veiculo", 
			"Gravar Veiculos em arquivo", 
			"Ler veiculos de arquivo", 
			"Sair"
	};
	
	public static void main(String[] args) {
		c = new Cadastro();
		
		Object opcao = JOptionPane.showInputDialog(
							null, 
							"Selecione uma opcao", 
							"Exemplo Persistencia", 
							JOptionPane.QUESTION_MESSAGE, 
							null, 
							opcoes, 
							opcoes[0]);
		
		do {
			switch (opcao.toString()) {
			case "Cadastrar Veiculo":
				cadastrarVeiculo();
				break;
			case "Pesquisar Veiculo":
				pesquisarVeiculo();
				break;
				
			case "Deletar Veiculo":
				deletarVeiculo();
				break;
				
			case "Gravar Veiculos em arquivo": 
				gravarEmArquivo();
				break;
			
			case "Ler veiculos de arquivo":
				lerVeiculosDeArquivo();
				break;

			default:
				break;
			}
			
			opcao = JOptionPane.showInputDialog(
					null, 
					"Selecione uma opcao", 
					"Exemplo Persistencia", 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					opcoes, 
					opcoes[0]);
		} while (!opcao.toString().equalsIgnoreCase(opcoes[6]));
	}

	private static void lerVeiculosDeArquivo() {
		boolean resposta; 
		resposta = c.lerArquivo();
		if (resposta)
			JOptionPane.showMessageDialog(null, "Veiculos lidos com sucesso");
	}

	private static void gravarEmArquivo() {
		boolean resposta = c.gravarVeiculoEmArquivo();
		if (resposta) 
			JOptionPane.showMessageDialog(null, "Veiculos gravados com sucesso");
	}

	private static void deletarVeiculo() {
		Veiculo v = pesquisarVeiculo();
		int escolha = JOptionPane.showConfirmDialog(null, 
						"Deseja mesmo deletar o veiculo?", 
						"Deletar?", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE);
		if (escolha == JOptionPane.YES_OPTION) {
			boolean deletado = c.deletarVeiculo(v);
			if (deletado) 
				JOptionPane.showMessageDialog(null, "Veiculo deletado");
			else 
				JOptionPane.showMessageDialog(null, "Veiculo não deletado");
		}
	}

	private static Veiculo pesquisarVeiculo() {
		String marca = JOptionPane.showInputDialog("Qual a marca?");
		String modelo = JOptionPane.showInputDialog("Qual a modelo?");
		
		Veiculo v = c.pesquisarVeiculo(marca, modelo);
		JOptionPane.showMessageDialog(null, v);
		return v;
	}

	private static boolean cadastrarVeiculo() {
		String marca = JOptionPane.showInputDialog("Marca");
		String modelo = JOptionPane.showInputDialog("Modelo");
		String strAnoFab = JOptionPane.showInputDialog("Ano de fabricacao");
		String strAnoMod = JOptionPane.showInputDialog("Ano de Modelo");
		
		int anoFab = Integer.parseInt(strAnoFab);
		int anoMod = Integer.parseInt(strAnoMod);
		
		Veiculo v = new Veiculo(marca, modelo, anoFab, anoMod);
		boolean resposta = c.cadastrarVeiculo(v);
		if (resposta)
			JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!");
		return resposta;
	}
}

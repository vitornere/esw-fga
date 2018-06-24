import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Media {
	List<Integer> numeros;
	
	public Media() {
		numeros = new LinkedList<Integer>();
	}

	public boolean informarNumero(String num) 
			throws NumberFormatException, 
	               ValorInvalidoException{
		
		boolean resposta = false; 
		int n = Integer.parseInt(num);
		if (n <= 0) {
			throw new ValorInvalidoException(n);
		}
		
		resposta = numeros.add(n);
		
		return resposta;
	}

	public float calcularMedia() {
		Iterator<Integer> it = numeros.iterator();
		
		int soma = 0;
		int qtde = 0;
		
		while (it.hasNext()) {
			soma += it.next().intValue();
			qtde++;
		}
		
		int media; 
		
		try {
			media = soma / qtde;
		} catch (ArithmeticException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
			media = Integer.MAX_VALUE;
		}
		
		
		return media;
	}
	
	
}









import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Cadastro {
	
	List<Veiculo> veics;
	
	public Cadastro() {
		veics = new LinkedList<Veiculo> ();
	}
	
	public boolean cadastrarVeiculo(Veiculo v) {
		boolean resposta = false;
		if (veics == null) 
			veics = new LinkedList<Veiculo>();
		resposta = veics.add(v);
		return resposta;
	}
	
	public Veiculo pesquisarVeiculo(String marca, String modelo) {
		Veiculo resposta = null;
		Iterator<Veiculo> it = veics.iterator();
		
		while (it.hasNext()) {
			Veiculo v = it.next();
			if (v.getMarca().equalsIgnoreCase(marca) &&
				v.getModelo().equalsIgnoreCase(modelo)) 
				resposta = v;
		}
		
		return resposta;
	}
	
	public boolean deletarVeiculo(Veiculo v) {
		boolean resposta = false;
		if (veics.contains(v))
			resposta = veics.remove(v);
		return resposta;
	}

	public boolean gravarVeiculoEmArquivo() {
		boolean resposta = false;
		FileWriter arquivo = null;
		try {
			arquivo = new FileWriter("veiculos.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter buffer = new BufferedWriter(arquivo);
		
		Iterator<Veiculo> it = veics.iterator();
		while (it.hasNext()) {
			Veiculo v = it.next();
			String str = "";
			str += v.getMarca() + ";";
			str += v.getModelo() + ";";
			str += v.getAnoFab() + ";";
			str += v.getAnoMod() + ";";
			
			try {
				buffer.write(str);
				buffer.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		try {
			buffer.close();
			resposta = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resposta;
	}

	public boolean lerArquivo() {
		FileReader arquivo = null;
		BufferedReader buffer;
		boolean resposta; 
		
		try {
			arquivo = new FileReader("veiculos.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		buffer = new BufferedReader(arquivo);
		
		
		String line = "";
		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		do {
			String[] campos = line.split(";");
			
			int anoFab = Integer.parseInt(campos[2]);
			int anoMod = Integer.parseInt(campos[3]);
			
			Veiculo v = new Veiculo(campos[0], campos[1], anoFab, anoMod);
			
			if (veics == null) 
				veics = new LinkedList<Veiculo>();
			
			resposta = veics.add(v);
			
			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} while (line != null);
		
		return resposta;
	}
	
	
	
}

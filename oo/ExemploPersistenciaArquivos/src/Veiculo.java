
public class Veiculo {
	String marca, 
	       modelo;
	int anoFab, 
	    anoMod;
	
	Veiculo (String marca, String modelo, int anoFab, int anoMod) {
		this.marca = marca;
		this.modelo = modelo;
		this.anoFab = anoFab;
		this.anoMod = anoMod;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String toString() {
		String resposta = "";
		resposta += "Marca: " + marca + '\n';
		resposta += "Modelo: " + modelo + '\n';
		resposta += "Ano de Fabricacao: " + anoFab + '\n';
		resposta += "Ano de Modelo: " + anoMod + '\n';
		return resposta;
		
	}

	public int getAnoFab() {
		return anoFab;
	}

	public int getAnoMod() {
		return anoMod;
	}
}

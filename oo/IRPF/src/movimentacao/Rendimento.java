package movimentacao;

public class Rendimento {
	private String descricao;
	private float valor;
	
	public Rendimento() {
	}
	
	Rendimento(String d, float v) {
		descricao = d;
		valor = v;
	}
	
	public void setDescricao(String d) {
		descricao = d;
	}
	
	public void setValor (float v) {
		valor = v;
	}
	
	public float getValor() {
		return valor;
	}
	
}

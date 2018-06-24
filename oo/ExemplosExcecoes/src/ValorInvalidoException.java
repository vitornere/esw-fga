
public class ValorInvalidoException extends Exception {

	public ValorInvalidoException(int n) {
		super(n + " é um valor invalido (<=0)."); 
	}
	
}

package calculoDeIRPF.exceptions;

public class DeducoesVazias extends DeducaoException {
	public final static String msg = "Deducoes vazias: o numero de deducoes eh"
			+ " igual a zero. Nao ha deducoes cadastradas";
	
	public DeducoesVazias() {
		super(msg);
	}
}

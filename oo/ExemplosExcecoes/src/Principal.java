import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar um numero?"); 
		
		Media m = new Media();
		
		while (opcao == JOptionPane.YES_OPTION) {
			String num = JOptionPane.showInputDialog("Informe num");
			
			try {
				m.informarNumero(num);
			} catch(NumberFormatException | ValorInvalidoException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
			
			opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar um numero?");
		}
		
		//calcular a media
		float media = m.calcularMedia();
		
		JOptionPane.showMessageDialog(null, "A media dos numeros é igual a: " + media);
	}

}


import javax.swing.JFrame;
//PROYECTO CREADO POR:
//PABLO VILLARROEL ANTILLANCA 20.487.087-K
//ELVIS RODRIGUEZ DURAN 20.255.414-8
//
//INGENIERIA DE EJECUCIÓN EN COMPUTACIÓN E INFORMÁTICA
public class main {

	public static void main(String[] args) {
		
		JFrame ventana1 = new JFrame();
		ventana1.setSize(800,550);
		ventana1.setTitle("Verificador de Sudoku");
		ventana1.setResizable(false);
		ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		interfaz window = new interfaz();
		ventana1.add(window.getPanel1());
		
		ventana1.setVisible(true);
	
		
	}
}
	




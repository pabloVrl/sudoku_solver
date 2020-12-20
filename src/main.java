
import javax.swing.JFrame;
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
	




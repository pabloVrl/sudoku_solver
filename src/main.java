
import javax.swing.JFrame;
import java.util.Arrays;
public class main {

	public static void main(String[] args) {

<<<<<<< HEAD
		
		JFrame ventana1 = new JFrame();
		ventana1.setSize(800,550);
		ventana1.setTitle("Verificador de Sudoku");
		ventana1.setResizable(false);
		ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        Sudoku s = new Sudoku();
		
		s.resolver();
		s.mostrar();
		
		
		interfaz window = new interfaz();
		ventana1.add(window.getPanel1());
		
		ventana1.setVisible(true);
	
		
	}
	
	public boolean resolver(){
		return true;
	}
	
	
=======
	}
>>>>>>> 49c191577bad3d5655b58547737b2378af5a4d60
		
}
	




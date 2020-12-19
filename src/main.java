<<<<<<< HEAD
import javax.swing.JFrame;
=======
import java.util.Arrays;
>>>>>>> 268bea94d84901a3780729d8977d35de1d8212d9

public class main {

	public static void main(String[] args) {
<<<<<<< HEAD
		
		JFrame ventana1 = new JFrame();
		ventana1.setSize(400,550);
		ventana1.setTitle("Verificador de Sudoku");
		ventana1.setResizable(false);
		ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        funcion(ventana1);
	
		
	}
	
	public boolean resolver(){
		return true;
	}
	
	public static void funcion(JFrame ventana1) {
		
		interfaz window = new interfaz();
		ventana1.add(window.getPanel());
		
		ventana1.setVisible(true);
		
		while(!window.getPermiso()) {
			
			System.out.println(".");
			
		}
		
		interfaz2 window2 = new interfaz2();
		ventana1.add(window2.getPanel());
		
		ventana1.setVisible(true);
		
        while(!window2.getPermiso()) {
			
			System.out.println(".");
			
		}
		
        funcion(ventana1);
		
	}
	
	
	
	

=======
		// TODO Auto-generated method stub
		Sudoku s = new Sudoku();
		
		s.resolver();
		
		s.mostrar();
	}
	
>>>>>>> 268bea94d84901a3780729d8977d35de1d8212d9
}

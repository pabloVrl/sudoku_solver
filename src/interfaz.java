
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class interfaz{

 private JPanel panel;
 private JLabel	titulo;
 private JLabel titulo2;
 private JTextArea linea;
 private JTextArea ingresar_matriz;
 private JTextArea respuesta;
 private JTextArea contorno;
 private JButton resolver;
 private JButton reset;
 private final Color fondo = new Color(200, 218, 211);
 URL sonido1,sonido2;
 


 
	public interfaz() {
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(147, 181, 179));
		
		//VENTANA1
		titulo = new JLabel("INGRESE LA BASE DEL SUDOKU");
		titulo.setBounds(20,35,400,20);
		titulo.setFont(new Font("", Font.BOLD, 22));
		
		ingresar_matriz = new JTextArea();
		ingresar_matriz.setBounds(90, 80, 220, 350);
		ingresar_matriz.setEditable(true);
		ingresar_matriz.setLineWrap(true);
		ingresar_matriz.setFont(new Font("", Font.BOLD,29));
		ingresar_matriz.setBackground(fondo);
		
		resolver = new JButton("RESOLVER");
		resolver.setBounds(135, 450, 120, 40);
		resolver.setBorderPainted(true);
		resolver.setFocusPainted(false);
		resolver.setContentAreaFilled(true);
		resolver.setBackground(Color.white);
		
		//CONTORNO
		contorno = new JTextArea();
		contorno.setEditable(false);
		contorno.setBounds(10,10,765,490);
		contorno.setBackground(fondo);
		
		
		//LINEA
		linea = new JTextArea();
		linea.setEditable(false);
		linea.setBounds(390,0,10,800);
		linea.setBackground(new Color(147, 181, 179));
		
		
		//VENTANA2
		
		titulo2 = new JLabel("SOLUCIÓN");
		titulo2.setBounds(535, 35,300 , 22);
		titulo2.setFont(new Font("", Font.BOLD, 20));
		
        respuesta = new JTextArea();
        respuesta.setBounds(480, 80, 220, 350);
        respuesta.setEditable(false);
		respuesta.setFont(new Font("", Font.BOLD, 29));
		respuesta.setBackground(fondo);
		respuesta.setLineWrap(true);
		
		
		reset = new JButton("LIMPIAR");
		reset.setBounds(530, 450, 120, 40);
		reset.setBorderPainted(true);
		reset.setFocusPainted(false);
		reset.setContentAreaFilled(true);
		reset.setBackground(Color.white);
        
		
	
		panel.add(titulo);
		panel.add(ingresar_matriz);
		panel.add(resolver);
		panel.add(linea);
		panel.add(titulo2);
		panel.add(respuesta);
		panel.add(reset);
		panel.add(contorno);
		
		//ACCIÓN BOTON1
	    resolver.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				
				 sonidoboton1();

				 Sudoku s = getTablero();
				 if(s == null) {
					 respuesta.setText("  \n\n\n  EL SUDOKU \n          ES\n    INVALIDO");
				 }
				 else {
					 int cont = 0;

					 for(int i = 0; i < 9; i++) {
						 for(int j = 0; j < 9; j++) {
							 if(s.tablero[i][j] != 0) {
								 cont++;
							 }
						 }
					 }

					 if (s.resolver()) {
						 String sudoku = "";
	
						 for(int i = 0; i < 9; i++) {
							 for(int j = 0; j < 9; j++) {
								 sudoku += s.tablero[i][j];
								 sudoku += " ";
							 }
						 }
						 respuesta.setText(sudoku);
					 }
					 else {
						 respuesta.setText("NO TIENE SOLUCION");
					 }
				 }

			 }
			 
			 
			 
			 
	
			
		});
	    
	  
	     //ACCIÓN HOVER BOTON1
	    resolver.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            resolver.setBackground(new Color(147, 181, 179));
	        }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            resolver.setBackground(Color.WHITE);
	        }
	    });
	    
	    
	    //ACCIÓN CLICK BOTON2
	    reset.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				sonidoboton2();
				ingresar_matriz.setText("");
				respuesta.setText("");
				

		
			}
			
		});
	    //ACCIÓN HOVER BOTON2
	    reset.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            reset.setBackground(new Color(147, 181, 179));
	        }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            reset.setBackground(Color.WHITE);
	        }
	    });
		
			
	}
	//MOSTRAR PANEL MAIN
	public JPanel getPanel1() {
		return panel;
	}
	
	//SONIDO BOTON1
	public void sonidoboton1()
    {
		
	   sonido1 = getClass().getResource("audio.wav");
        try 
        {
    	 AudioInputStream sound1 = AudioSystem.getAudioInputStream(sonido1);
 		 Clip clip1 = AudioSystem.getClip();
 	     clip1.open(sound1);
 	     clip1.start();
        }
        catch(Exception e)
        {  
    	 System.out.println("" + e);
        }
      
      
    }

	 //SONIDO BOTON2
     public void sonidoboton2()
	    {
    	 
    	 sonido2 = getClass().getResource("audio.wav");
    	 try {
            
    		 AudioInputStream sound2 = AudioSystem.getAudioInputStream(sonido2);
    		 Clip clip2 = AudioSystem.getClip();
    	     clip2.open(sound2);
    	     clip2.start();
             
           
         } catch (Exception e) {
             System.out.println("" + e);
         }
	      
	    }
     
	//PASAR TABLERO A MATRIZ
	private Sudoku getTablero() {
		String tablero = ingresar_matriz.getText();
		tablero = tablero.replace(" ", "");
		tablero = tablero.replace("\n", "");
		
		if(tablero.length() < 81) {
			respuesta.setText("  \n\n\n  EL SUDOKU \n        ESTÁ\n INCOMPLETO");
			return null;
		}
		else {
			int sudoku[][] = new int[9][9];
			int cont = 0;
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sudoku[i][j] = Character.getNumericValue(tablero.charAt(cont));
					cont++;
				}
			}
			
			Sudoku s = new Sudoku(sudoku);
			
			if(!verificarSudoku(s)) {
				return null;
			}
			
			return s;
			
		}
		
		

	}
	
	private boolean verificarSudoku(Sudoku s) {
		// ciclo para verificar que no hayan errores en la base del sudoku
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				int actual = s.tablero[i][j];
				if( actual != 0) {
					// verificar si esta en la misma fila
					for(int n = 0; n < 9; n++) {
						if(s.tablero[i][n] == actual && n!=j) {
							System.out.println("MISMA FILA");
							return false;
						}
					}
					// verificar si esta en la misma columna
					for(int n = 0; n < 9; n++) {
						if(actual == s.tablero[n][j] && n!=i) {
							System.out.println("misma columna");
							return false;
						}
					}
					// verificar si esta en el mismo cuadrante
					int inicioFila = (i / 3) * 3;
					int inicioColu = (j / 3) * 3;
					int count = 0;
					for(int f = inicioFila; f < inicioFila + 3; f++) {
						for(int c = inicioColu; c < inicioColu + 3; c++) {
							if(actual == s.tablero[f][c])
								count += 1;
								if(count == 2) {
									System.out.println("MISMO CUADRANTE");
									return false;
								}
						}
					}
				}
			}
		}
		
		return true;
	}
	
    
	
}


import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




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
 private JButton resolver;
 private JButton reset;
 private final Color fondo = new Color(200, 218, 211);
 private AudioInputStream sonido1;
 private AudioInputStream sonido2;
 private Clip clip1;
 private Clip clip2;
 
 
	public interfaz() {
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(fondo);
		
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
		
		//LINEA
		linea = new JTextArea();
		linea.setEditable(false);
		linea.setBounds(390,0,10,800);
		linea.setBackground(new Color(147, 181, 179));
		
		
		//VENTANA2
		
		titulo2 = new JLabel("SOLUCIÓN");
		titulo2.setBounds(530, 35,300 , 22);
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
		
		//ACCIÓN BOTON1
	    resolver.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				
				sonidoboton1();
				Sudoku s = getTablero();
								int cont = 0;
				for(int i = 0; i < 9; i++) {
					for(int j = 0; j < 9; j++) {
						if(s.tablero[i][j] != 0) {
							cont++;
						}
					}
				}
				
				if(cont == 81) {
					respuesta.setText("  \n\n\n  EL SUDOKU \n    NO TIENE \n   SOLUCIÓN");
				}
				else {
					System.out.println(s.resolver());
					String sudoku = "";

					for(int i = 0; i < 9; i++) {
						for(int j = 0; j < 9; j++) {
							sudoku += s.tablero[i][j];
							sudoku += " ";
						}
					}
					
					
                    System.out.println(sudoku);

					respuesta.setText(sudoku);
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
      try 
      {
       sonido1 = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("audio1.wav"));
       clip1 = AudioSystem.getClip();
       clip1.open(sonido1);
      }
      catch(Exception ex)
      {
        
      }
      clip1.setFramePosition(0);
      clip1.start();
    }

	 //SONIDO BOTON2
     public void sonidoboton2()
	    {
	      try 
	      {
	       sonido2 = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("audio2.wav"));
	       clip2 = AudioSystem.getClip();
	       clip2.open(sonido2);
	      }
	      catch(Exception ex)
	      {
	        
	      }
	      clip2.setFramePosition(0);
	      clip2.start();
	    }
	//PASAR TABLERO A MATRIZ
	private Sudoku getTablero() {
		String tablero = ingresar_matriz.getText();
		tablero = tablero.replace(" ", "");
		tablero = tablero.replace("\n", "");
		
		int sudoku[][] = new int[9][9];
		int cont = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = Character.getNumericValue(tablero.charAt(cont));
				cont++;
			}
		}
		
//		for(int i = 0; i < 9; i++) {
//			for(int j = 0; j < 9; j++) {
//				System.out.print(sudoku[i][j]);
//			}
//			System.out.println();
//		}
//		
		Sudoku s = new Sudoku(sudoku);
		
		return s;
	}
	
}

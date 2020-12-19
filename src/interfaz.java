
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


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
 
 
	public interfaz() {
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(fondo);
		
		//VENTANA1
		titulo = new JLabel("INGRESE LA BASE DEL SUDOKU");
		titulo.setBounds(20,35,400,20);
		titulo.setFont(new Font("", Font.BOLD, 22));
		
		ingresar_matriz = new JTextArea();
		ingresar_matriz.setBounds(80, 80, 220, 350);
		ingresar_matriz.setEditable(true);
		ingresar_matriz.setLineWrap(true);
		ingresar_matriz.setFont(new Font("", Font.BOLD,29));
		ingresar_matriz.setBackground(fondo);
		
		resolver = new JButton("RESOLVER");
		resolver.setBounds(120, 450, 120, 40);
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
		
	    resolver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				
		
			}
			
		});
		
			
	}
	
	public JPanel getPanel1() {
		return panel;
	}
	
}

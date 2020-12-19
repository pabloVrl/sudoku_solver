
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class interfaz{

 private JPanel panel;
 private JLabel	titulo;
 private JTextArea ingresar_matriz;
 private JButton resolver;
 private boolean permiso = false;
 
	
	public interfaz() {
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(233, 240, 246));

		titulo = new JLabel("INGRESE LA BASE DEL SUDOKU");
		titulo.setBounds(40,30,300,20);
		//titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("", Font.BOLD, 18));
		
		ingresar_matriz = new JTextArea();
		ingresar_matriz.setBounds(80, 80, 220, 350);
		ingresar_matriz.setEditable(true);
		ingresar_matriz.setLineWrap(true);
		ingresar_matriz.setFont(new Font("", Font.BOLD,29));
		//ingresar_matriz.setWrapStyleWord(true);
		ingresar_matriz.setBackground(new Color(233, 240, 248));
		
		resolver = new JButton("Resolver");
		resolver.setBounds(120, 450, 120, 40);
		
	
		panel.add(titulo);
		panel.add(ingresar_matriz);
		panel.add(resolver);
		
	    resolver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				permiso = true;
				panel.setVisible(false);	
		
			}
			
		});
		
			
	}
	
	public JPanel getPanel() {
		return panel;
	}
	public boolean getPermiso() {
		return permiso;
	}
	
}

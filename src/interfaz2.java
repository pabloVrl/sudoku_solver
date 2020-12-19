import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class interfaz2 {

	private JPanel panel;
	private JLabel titulo;
	private JLabel respuesta;
	private JButton boton;
	private boolean permiso;
	
	
	public interfaz2(){
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(233, 240, 246));
		
		titulo = new JLabel("SOLUCIÓN");
		titulo.setFont(new Font("", Font.BOLD, 18));
		titulo.setBounds(150,30,300,20);
		
		respuesta = new JLabel();
		respuesta.setBounds(80, 80, 220, 350);
		
		boton = new JButton("Resolver otro sudoku");
		boton.setBounds(100, 450, 180, 40);
		
		panel.add(titulo);
		panel.add(respuesta);
		panel.add(boton);
		
		boton.addActionListener(new ActionListener() {
				
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

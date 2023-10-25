package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewEjercicio01 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ViewEjercicio01() {
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Saludador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escribe tu nombre para saludar");
		lblNewLabel.setBounds(126, 62, 200, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(126, 87, 155, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Saludar");
		btnNewButton.addActionListener(a1);
		btnNewButton.setBounds(161, 137, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	ActionListener a1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String name = textField.getText();
			String message="";
			if(name.isEmpty()) {
				message = "El campo de texto no puede estar vacio";
			} else {
				message = "!Hola " + name + "¡";
			}
			textField.setText("");
			JOptionPane.showMessageDialog(rootPane, message);
		}
	};

}

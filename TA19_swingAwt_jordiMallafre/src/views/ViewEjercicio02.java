package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class ViewEjercicio02 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	public ViewEjercicio02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escribe el titulo de la pelicula");
		lblNewLabel.setBounds(21, 69, 218, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(31, 104, 123, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Peliculas");
		lblNewLabel_1.setBounds(281, 69, 129, 14);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(192, 103, 218, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(a1);
		btnNewButton.setBounds(41, 135, 89, 23);
		contentPane.add(btnNewButton);
	};
	
	ActionListener a1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String name = textField.getText();
			if(!name.isEmpty()) {
				comboBox.addItem(name);
			}
			textField.setText("");
		}
	};
}

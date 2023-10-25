package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ViewEjercicio03 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String textRadioButton;
	private ArrayList<String> textCheckBox = new ArrayList<String>();
	private int numberSlider;

	/**
	 * Create the frame.
	 */
	public ViewEjercicio03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Elije un sistema operativo");
		lblNewLabel.setBounds(66, 11, 154, 14);
		contentPane.add(lblNewLabel);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Windows");
		rdbtnNewRadioButton.addItemListener(recuperarTextRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(20, 32, 109, 23);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Linux");
		rdbtnNewRadioButton_1.addItemListener(recuperarTextRadioButton);
		rdbtnNewRadioButton_1.setBounds(20, 58, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Mac");
		rdbtnNewRadioButton_2.addItemListener(recuperarTextRadioButton);
		rdbtnNewRadioButton_2.setBounds(20, 84, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);

		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rdbtnNewRadioButton);
		bgroup.add(rdbtnNewRadioButton_1);
		bgroup.add(rdbtnNewRadioButton_2);

		JLabel lblNewLabel_1 = new JLabel("Especialidad");
		lblNewLabel_1.setBounds(85, 138, 109, 14);
		contentPane.add(lblNewLabel_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Programaci\u00F3n");
		chckbxNewCheckBox.setBounds(20, 159, 159, 23);
		chckbxNewCheckBox.addItemListener(recuperarTextCheckBox);
		contentPane.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Dise\u00F1o gr\u00E1fico");
		chckbxNewCheckBox_1.setBounds(20, 185, 228, 23);
		chckbxNewCheckBox_1.addItemListener(recuperarTextCheckBox);
		contentPane.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Administraci\u00F3n");
		chckbxNewCheckBox_2.setBounds(20, 211, 200, 23);
		chckbxNewCheckBox_2.addItemListener(recuperarTextCheckBox);
		contentPane.add(chckbxNewCheckBox_2);

		JSlider slider = new JSlider();
		slider.addChangeListener(recuperarValorSlider);
		slider.setMaximum(10);
		slider.setValue(0);
		slider.setBounds(20, 314, 200, 50);
		contentPane.add(slider);

		JLabel lblNewLabel_2 = new JLabel("Horas dedicadas en el ordenador");
		lblNewLabel_2.setBounds(36, 289, 212, 14);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(a1);
		btnNewButton.setBounds(66, 395, 89, 23);
		contentPane.add(btnNewButton);
	};

	ItemListener recuperarTextRadioButton = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				JRadioButton selectedRadio = (JRadioButton) e.getSource();
				textRadioButton = selectedRadio.getText();
			}
		}
	};

	ItemListener recuperarTextCheckBox = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			String text = "";
			JCheckBox selectedCheckBox = (JCheckBox) e.getItem();
			text = selectedCheckBox.getText();
			
			if (e.getStateChange() == ItemEvent.SELECTED) {
				textCheckBox.add(text);
			} else {
				textCheckBox.remove(textCheckBox.indexOf(text));
			}
		}
	};

	ChangeListener recuperarValorSlider = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			JSlider valor = (JSlider) e.getSource();
			numberSlider = valor.getValue();
		}
	};

	ActionListener a1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(rootPane, crearMensaje());
		}
	};
	
	private String crearMensaje() {
		String message = "";

		message += "Sistema operativo escojido:\n";
		message += textRadioButton;
		message += "\n\n";

		message += "Especialidades escojidas:\n";
		for (String checkBoxText : textCheckBox) {
			message += checkBoxText;
			message += "\n";
		}

		message += "\n";

		message += "Horas dedicadas en el ordenador:\n";
		message += numberSlider + "h";

		return message;
	}
}

package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ViewEjercicio04 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldValor1;
	private JTextField textFieldValor2;
	private JTextField resultField;
	private JLabel lblOperacion;
	private JLabel lblIgual;
	private JLabel lblInfo1;
	private JLabel lblHistorico;
	private JButton btnIgual;
	private JButton btnSumar;
	private JButton btnPositivoNegativo;
	private JButton btnComa;
	private JButton btnResta;
	private JButton btnDivision;
	private JButton btnReset;
	private JButton btnBorrarUno;
	private JButton btnMultiplicacion;
	private JButton btnPorcentaje;

	/**
	 * Create the frame.
	 */
	public ViewEjercicio04() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* LABEL */

		lblOperacion = new JLabel("");
		lblOperacion.setBounds(85, 70, 46, 14);
		lblOperacion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblOperacion);

		lblInfo1 = new JLabel("");
		lblInfo1.setBounds(105, 36, 161, 20);
		lblInfo1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInfo1);

		lblHistorico = new JLabel("");
		lblHistorico.setBounds(249, 123, 161, 210);
		lblHistorico.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblHistorico);

		lblIgual = new JLabel("=");
		lblIgual.setBounds(206, 70, 46, 14);
		lblIgual.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblIgual);

		/* BUTTON */

		JButton[] buttons = new JButton[10];
		int buttonWidth = 50;
		int buttonHeight = 50;
		int initialX = 10;
		int initialY = 250;
		int modificador = 50;

		for (int i = 0; i < 10; i++) {
			buttons[i] = new JButton(Integer.toString(i));

			if (i == 0) {
				buttons[i].setBounds(initialX + modificador, initialY + modificador, buttonWidth, buttonHeight);
				buttons[i].addActionListener(a�adirValores);
			} else if (i <= 3) {
				buttons[i].setBounds(initialX + (modificador * (i - 1)), initialY, buttonWidth, buttonHeight);
				buttons[i].addActionListener(a�adirValores);
			} else if (i <= 6 && i > 3) {
				buttons[i].setBounds(initialX + (modificador * (i - 4)), initialY - modificador, buttonWidth,
						buttonHeight);
				buttons[i].addActionListener(a�adirValores);
			} else {
				buttons[i].setBounds(initialX + (modificador * (i - 7)), initialY - (modificador * 2), buttonWidth,
						buttonHeight);
				buttons[i].addActionListener(a�adirValores);
			}
			contentPane.add(buttons[i]);
		}

		btnIgual = new JButton("=");
		btnIgual.setBounds(160, 300, 50, 50);
		btnIgual.addActionListener(calcular);
		contentPane.add(btnIgual);

		btnSumar = new JButton("+");
		btnSumar.setBounds(160, 250, 50, 50);
		btnSumar.addActionListener(a�adirOperacion);
		contentPane.add(btnSumar);

		btnResta = new JButton("-");
		btnResta.setBounds(160, 200, 50, 50);
		btnResta.addActionListener(a�adirOperacion);
		contentPane.add(btnResta);

		btnDivision = new JButton("/");
		btnDivision.setBounds(160, 100, 50, 50);
		btnDivision.addActionListener(a�adirOperacion);
		contentPane.add(btnDivision);

		btnMultiplicacion = new JButton("*");
		btnMultiplicacion.setBounds(160, 150, 50, 50);
		btnMultiplicacion.addActionListener(a�adirOperacion);
		contentPane.add(btnMultiplicacion);

		btnPorcentaje = new JButton("%");
		btnPorcentaje.setBounds(110, 100, 50, 50);
		btnPorcentaje.addActionListener(a�adirOperacion);
		contentPane.add(btnPorcentaje);

		btnPositivoNegativo = new JButton("+/-");
		btnPositivoNegativo.setBounds(10, 300, 50, 50);
		btnPositivoNegativo.addActionListener(positivoNegativo);
		contentPane.add(btnPositivoNegativo);

		btnComa = new JButton(",");
		btnComa.setBounds(110, 300, 50, 50);
		btnComa.addActionListener(a�adirComa);
		contentPane.add(btnComa);

		btnReset = new JButton("C");
		btnReset.setBounds(60, 100, 50, 50);
		btnReset.addActionListener(borrarTodo);
		contentPane.add(btnReset);

		btnBorrarUno = new JButton("CE");
		btnBorrarUno.setBounds(10, 100, 50, 50);
		btnBorrarUno.addActionListener(borrar);
		contentPane.add(btnBorrarUno);

		/* TEXT FIELD */
		textFieldValor1 = new JTextField();
		textFieldValor1.setEnabled(false);
		textFieldValor1.setBounds(10, 67, 86, 20);
		contentPane.add(textFieldValor1);
		textFieldValor1.setColumns(10);

		textFieldValor2 = new JTextField();
		textFieldValor2.setEnabled(false);
		textFieldValor2.setBounds(124, 67, 86, 20);
		contentPane.add(textFieldValor2);
		textFieldValor2.setColumns(10);

		resultField = new JTextField();
		resultField.setEnabled(false);
		resultField.setBounds(249, 67, 86, 20);
		contentPane.add(resultField);
		resultField.setColumns(10);

	}

	ActionListener a�adirOperacion = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (!"".equals(textFieldValor1.getText())) {
				JButton opcionEscojida = (JButton) e.getSource();
				lblOperacion.setText(opcionEscojida.getText());
				modificarLabelOperacion(" " + opcionEscojida.getText() + " ");
			}

		}
	};

	ActionListener a�adirValores = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton botonEscojido = (JButton) e.getSource();
			String simbolo = recuperarSimboloOperaci�n();
			
			if (simbolo.equals("")) {
				borrarResultado();
				textFieldValor1.setText(textFieldValor1.getText() + botonEscojido.getText());
			} else {
				textFieldValor2.setText(textFieldValor2.getText() + botonEscojido.getText());
			}
			
			if(textFieldValor1.getText().equals("")) {
				modificarLabelOperacion("");
			}

			modificarLabelOperacion(botonEscojido.getText());
		}
	};

	ActionListener positivoNegativo = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			String simbolo = recuperarSimboloOperaci�n();
			if (simbolo.equals("")) {
				textFieldValor1.setText(invertirPositivoNegativo(textFieldValor1.getText()));
			} else {
				textFieldValor2.setText(invertirPositivoNegativo(textFieldValor2.getText()));
			}

		}
	};
	
	ActionListener borrarTodo = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			reseteoParcial();
			borrarResultado();
			lblHistorico.setText("");

		}
	};

	ActionListener a�adirComa = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			String simbolo = recuperarSimboloOperaci�n();
			if (simbolo.equals("")) {
				textFieldValor1.setText(comprobarComa(textFieldValor1.getText()));
			} else {
				textFieldValor2.setText(comprobarComa(textFieldValor2.getText()));
			}

		}
	};

	ActionListener borrar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			String simbolo = recuperarSimboloOperaci�n();
			if (simbolo.equals("")) {
				textFieldValor1.setText(borrarUnCaracter(textFieldValor1.getText()));
			} else {
				textFieldValor2.setText(borrarUnCaracter(textFieldValor2.getText()));
			}

		}
	};
	ActionListener calcular = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (!"".equals(textFieldValor1.getText()) && !"".equals(textFieldValor2.getText())) {
				String simbolo = recuperarSimboloOperaci�n();
				switch (simbolo) {
				case "+":
					sumar();
					reseteoParcial();
					break;
				case "-":
					restar();
					reseteoParcial();
					break;
				case "*":
					multiplicar();
					reseteoParcial();
					break;
				case "/":
					dividir();
					reseteoParcial();
					break;
				case "%":
					porcentaje();
					reseteoParcial();
					break;
				default:
					JOptionPane.showMessageDialog(rootPane, "A ocurrido un error inesperado");
					break;
				}
			}
		}
	};
	
	private String borrarUnCaracter(String text) {
		if(!"".equals(text)) {
			text = text.substring(text.length());
			lblInfo1.setText(lblInfo1.getText().substring(lblInfo1.getText().length()));
		}
		
		return text;
	}
	
	private void reseteoParcial() {
		textFieldValor1.setText("");
		textFieldValor2.setText("");
		lblOperacion.setText("");
		lblInfo1.setText("");
	}
	
	private void borrarResultado() {
		resultField.setText("");
	}

	private void modificarLabelOperacion(String text) {
		lblInfo1.setText(lblInfo1.getText() + text);
	}

	private String recuperarSimboloOperaci�n() {
		String simboloOperacion = "";
		String operacionAComprobar = lblInfo1.getText();
		String simbolos = "+-*/%";

		for (int i = 0; i < simbolos.length(); i++) {
			char caracter = simbolos.charAt(i);
			if (operacionAComprobar.contains(String.valueOf(caracter))) {
				simboloOperacion = String.valueOf(caracter);
				break;
			}
		}

		return simboloOperacion;
	}

	private String invertirPositivoNegativo(String valor) {
		double num = Double.parseDouble(valor) * -1;
		valor = Double.toString(num);
		return valor;
	}

	private String comprobarComa(String text) {
		if (!text.contains(",")) {
			text = text + ".";
			modificarLabelOperacion(",");
		}
		return text;
	}

	private void sumar() {
		double num1 = Double.parseDouble(textFieldValor1.getText());
		double num2 = Double.parseDouble(textFieldValor2.getText());
		double resultado = num1 + num2;
		escribirReultado(resultado);
	}

	private void restar() {
		double num1 = Double.parseDouble(textFieldValor1.getText());
		double num2 = Double.parseDouble(textFieldValor2.getText());
		double resultado = num1 - num2;
		escribirReultado(resultado);

	}

	private void multiplicar() {
		double num1 = Double.parseDouble(textFieldValor1.getText());
		double num2 = Double.parseDouble(textFieldValor2.getText());
		double resultado = num1 * num2;
		escribirReultado(resultado);
	}

	private void dividir() {
		double num1 = Double.parseDouble(textFieldValor1.getText());
		double num2 = Double.parseDouble(textFieldValor2.getText());
		if (num2 != 0) {
			double resultado = num1 / num2;
			escribirReultado(resultado);
		} else {
			JOptionPane.showMessageDialog(null, "Error: Divisi�n por cero");
		}
	}
	
	private void porcentaje() {
		double num1 = Double.parseDouble(textFieldValor1.getText());
		double num2 = Double.parseDouble(textFieldValor2.getText());
		
		double resultado = num1 * (num2/100);
		escribirReultado(resultado);
	}
	
	private void escribirReultado (double resultado) {
		resultField.setText(String.valueOf(resultado));
		modificarLabelOperacion(" = " + Double.toString(resultado));
		lblHistorico.setText("<html>"+lblHistorico.getText() + lblInfo1.getText() + "<br><html>");
	}

}
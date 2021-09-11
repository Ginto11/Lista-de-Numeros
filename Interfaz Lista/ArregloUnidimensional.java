import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.BevelBorder;

@SuppressWarnings({ "serial", "unused" })
public class ArregloUnidimensional extends JFrame {

	private JPanel contentPane;
	private JTextField textNumero;
	private JTextField textPosicion;
	private JTextField textSalida;

	/**
	 * @author Nelson Muñoz
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArregloUnidimensional frame = new ArregloUnidimensional();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	int numeros [] =  new int[10];
	int promedio = 0;
	String listaNumeros = "Lista de numeros";
	int conteo;
	private JTextField textAccion;

	/**
	 * @author Nelson Muñoz
	 * Create the frame.
	 */
	public ArregloUnidimensional() {
		setUndecorated(true);
		setFont(new Font("Times New Roman", Font.BOLD, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		setTitle("Lista de Numeros Enteros");
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textNumero = new JTextField();
		textNumero.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textNumero.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		textNumero.setHorizontalAlignment(SwingConstants.CENTER);
		textNumero.setBounds(334, 73, 86, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);

		textPosicion = new JTextField();
		textPosicion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textPosicion.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		textPosicion.setHorizontalAlignment(SwingConstants.CENTER);
		textPosicion.setBounds(334, 104, 86, 20);
		contentPane.add(textPosicion);
		textPosicion.setColumns(10);

		JLabel lblNewLabel = new JLabel("Numero");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(171, 76, 68, 14);
		contentPane.add(lblNewLabel);

		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setForeground(Color.LIGHT_GRAY);
		lblPosicion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPosicion.setBounds(171, 107, 68, 14);
		contentPane.add(lblPosicion);

		JTextArea textBase = new JTextArea();
		textBase.setAutoscrolls(false);
		textBase.setForeground(new Color(0, 0, 0));
		textBase.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textBase.setDisabledTextColor(new Color(192, 192, 192));
		textBase.setBackground(new Color(224, 255, 255));
		textBase.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		textBase.setEditable(false);
		textBase.setBounds(10, 43, 130, 203);
		contentPane.add(textBase);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textHighlight, null, null, SystemColor.textHighlight));
		btnAgregar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnAgregar.setBackground(new Color(30, 70, 70));
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textAccion.setText("Agrega un numero a la lista");
				btnAgregar.setBackground(new Color(30, 40, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textAccion.setText("");
				btnAgregar.setBackground(new Color(30, 70, 70));
			}
		});
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conteo++;
				try {
					int posicion = Integer.parseInt(textPosicion.getText());
					int numero = Integer.parseInt(textNumero.getText());
					int salida = numeros[posicion] = numero;
					textSalida.setText("[" + posicion + "] = " + salida);
					textBase.setText("Agregado\n[" + posicion +"] = "+ salida +"\n");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Posibles razones por las que no se agregue el numero:\n\n"
							+ "1: El numero no es entero.\n"
							+ "2: Esta intentando agregar numero sin posicion, viserversa o ninguno de los dos valores.\n"
							+ "3: Esta ingresando texto.\n"
							+ "4: Pudo haber ingresado un simbolo.", "ERROR DE AGREGACION", JOptionPane.ERROR_MESSAGE, null);
				}

			}
		});
		btnAgregar.setBounds(171, 198, 89, 23);
		contentPane.add(btnAgregar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textHighlight, null, null, SystemColor.textHighlight));
		btnEliminar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setBackground(new Color(30, 70, 70));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicion = Integer.parseInt(textPosicion.getText());
				numeros[posicion] = 0;

				textSalida.setText("[" + posicion + "]");
				textBase.setText("Elimino elemento\nposicion [" + posicion + "]");
			}
		});
		btnEliminar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				textAccion.setText("Poner valor de la posicion");
				btnEliminar.setBackground(new Color(30, 40, 40));
			}
			public void mouseExited(MouseEvent e){
				textAccion.setText("");
				btnEliminar.setBackground(new Color(30, 70, 70));
			}
		});
		btnEliminar.setBounds(331, 198, 89, 23);
		contentPane.add(btnEliminar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textHighlight, null, null, SystemColor.textHighlight));
		btnConsultar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.setBackground(new Color(30, 70, 70));
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textAccion.setText("Consulta toda la lista");
				btnConsultar.setBackground(new Color(30, 40, 40));
			}
			public void mouseExited(MouseEvent e){
				textAccion.setText("");
				btnConsultar.setBackground(new Color(30, 70, 70));
			}
		});
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i= 0; i<numeros.length; i++){
					/*JOptionPane.showMessageDialog(null, "[" + i + "] = " + numeros[i]);*/
					listaNumeros = listaNumeros + "\n["+ i + "] = " + numeros[i];
				}
				textBase.setText(listaNumeros);
				listaNumeros= "Lista de numeros";
			}
		});
		btnConsultar.setBounds(331, 232, 89, 23);
		contentPane.add(btnConsultar);

		JButton btnPromedio = new JButton("Promedio");
		btnPromedio.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textHighlight, null, null, SystemColor.textHighlight));
		btnPromedio.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnPromedio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPromedio.setBackground(new Color(30, 70, 70));
		btnPromedio.setForeground(new Color(255, 255, 255));
		btnPromedio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textAccion.setText("Se promedia la lista");
				btnPromedio.setBackground(new Color(30, 40, 40));
			}
			public void mouseExited(MouseEvent e){
				textAccion.setText("");
				btnPromedio.setBackground(new Color(30, 70, 70));
			}
		});
		btnPromedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i<numeros.length; i++){
					promedio += numeros[i];
				}
				promedio /= conteo;
				textBase.setText("El promedio es\n" + promedio + "\n");
				promedio = 0;
			}
		});
		btnPromedio.setBounds(171, 232, 89, 23);
		contentPane.add(btnPromedio);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textHighlight, null, null, SystemColor.textHighlight));
		btnLimpiar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setBackground(new Color(30, 70, 70));
		btnLimpiar.setForeground(new Color(255, 255, 255));
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textAccion.setText("Limpia la lista");
				btnLimpiar.setBackground(new Color(30, 40, 40));
			}
			public void mouseExited(MouseEvent e){
				textAccion.setText("");
				btnLimpiar.setBackground(new Color(30, 70, 70));
			}
		});
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i < numeros.length; i++){
					numeros[i] = 0;
					listaNumeros = listaNumeros + "\n["+ i + "] = " + numeros[i];
				}
				textBase.setText(listaNumeros);
				listaNumeros = "Lista de numeros";
			}
		});
		btnLimpiar.setBounds(331, 266, 89, 23);
		contentPane.add(btnLimpiar);

		textSalida = new JTextField();
		textSalida.setForeground(new Color(0, 0, 0));
		textSalida.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textSalida.setBackground(new Color(224, 255, 255));
		textSalida.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		textSalida.setHorizontalAlignment(SwingConstants.CENTER);
		textSalida.setEditable(false);
		textSalida.setBounds(334, 135, 86, 20);
		contentPane.add(textSalida);
		textSalida.setColumns(10);

		JLabel lblSalida = new JLabel("Salida");
		lblSalida.setForeground(Color.LIGHT_GRAY);
		lblSalida.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSalida.setBounds(171, 138, 46, 14);
		contentPane.add(lblSalida);

		JButton btnReiniciar = new JButton("Reiniar");
		btnReiniciar.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textHighlight, null, null, SystemColor.textHighlight));
		btnReiniciar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnReiniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReiniciar.setBackground(new Color(30, 70, 70));
		btnReiniciar.setForeground(new Color(255, 255, 255));
		btnReiniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textAccion.setText("Reinicia todos los valores");
				btnReiniciar.setBackground(new Color(30, 40, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textAccion.setText("");
				btnReiniciar.setBackground(new Color(30, 70, 70));
			}
		});
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNumero.setText("");
				textPosicion.setText("");
				textSalida.setText("");
				textBase.setText("");
			}
		});
		btnReiniciar.setBounds(171, 266, 89, 23);
		contentPane.add(btnReiniciar);

		JLabel lblAccion = new JLabel("Accion");
		lblAccion.setForeground(Color.LIGHT_GRAY);
		lblAccion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAccion.setBounds(171, 47, 46, 14);
		contentPane.add(lblAccion);

		textAccion = new JTextField();
		textAccion.setForeground(new Color(0, 0, 0));
		textAccion.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textAccion.setBackground(new Color(224, 255, 255));
		textAccion.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		textAccion.setHorizontalAlignment(SwingConstants.CENTER);
		textAccion.setBounds(243, 45, 177, 20);
		textAccion.setEditable(false);
		contentPane.add(textAccion);
		textAccion.setColumns(10);

		JLabel label = new JLabel("\u2022");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ArregloUnidimensional.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				textAccion.setText("Cerrrar programa");
			}
			public void mouseExited(MouseEvent e){
				textAccion.setText("");
			}
		});
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 27));
		label.setBounds(396, 11, 24, 23);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u2022");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArregloUnidimensional.this.setState(ICONIFIED);
			}
			public void mouseEntered(MouseEvent e){
				textAccion.setText("Minimizar programa");
			}
			public void mouseExited(MouseEvent e){
				textAccion.setText("");
			}
		});
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		label_1.setBounds(375, 11, 24, 23);
		contentPane.add(label_1);

		JLabel lblListaDeNumeros = new JLabel("LISTA DE NUMEROS ENTEROS");
		lblListaDeNumeros.setForeground(new Color(0, 255, 255));
		lblListaDeNumeros.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblListaDeNumeros.setBounds(10, 11, 410, 23);
		contentPane.add(lblListaDeNumeros);

	}
}

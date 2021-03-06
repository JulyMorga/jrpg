package ventana;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import herramientas.Constantes;
import mensajes.MensajeEleccionPersonaje;
import mensajes.MensajeEleccionTerreno;
import pantalla.Juego;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEleccion extends JFrame {

	private JPanel contentPane;
	private String eleccionRaza=null;
	private String eleccionCasta=null;
	private String eleccionMapa=null;
	private JButton btnHumano;
	private JButton btnRobot;
	private JButton btnSuperheroe;
	private JButton btnAlien;
	private JButton btnLuchador;
	private JButton btnLadron;
	private JButton btnHechicero;
	private JButton btnDesierto;
	private JButton btnPlaya;
	private JButton btnCampo;
	private JButton btnJugar;
	private Cliente cliente;
	private String usuario;
	/**
	 * Create the frame.
	 */
	public VentanaEleccion(String usuario,Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("The Alliance - Selecciona Personaje");
		setIconImage(new ImageIcon(Constantes.PATH_ICONO).getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.cliente=cliente;
		this.usuario=usuario;
		
		JLabel lblRaza = new JLabel("RAZA");
		lblRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaza.setFont(new Font("Arial", Font.PLAIN, 19));
		lblRaza.setBounds(37, 37, 70, 30);
		contentPane.add(lblRaza);
		
		btnHumano = new JButton("Humano");
		btnHumano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eleccionRaza = btnHumano.getText();
				btnAlien.setEnabled(true);
				btnHumano.setEnabled(false);
				btnRobot.setEnabled(true);
				btnSuperheroe.setEnabled(true);
			}
		});
		btnHumano.setFont(new Font("Arial", Font.PLAIN, 16));
		btnHumano.setBounds(100, 78, 120, 23);
		contentPane.add(btnHumano);
		
		btnRobot = new JButton("Robot");
		btnRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccionRaza = btnRobot.getText();
				btnAlien.setEnabled(true);
				btnHumano.setEnabled(true);
				btnRobot.setEnabled(false);
				btnSuperheroe.setEnabled(true);
			}
		});
		btnRobot.setFont(new Font("Arial", Font.PLAIN, 16));
		btnRobot.setBounds(250, 78, 120, 23);
		contentPane.add(btnRobot);
		
		btnSuperheroe = new JButton("Superheroe");
		btnSuperheroe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccionRaza = btnSuperheroe.getText();
				btnAlien.setEnabled(true);
				btnHumano.setEnabled(true);
				btnRobot.setEnabled(true);
				btnSuperheroe.setEnabled(false);
			}
		});
		btnSuperheroe.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSuperheroe.setBounds(400, 78, 120, 23);
		contentPane.add(btnSuperheroe);
		
		btnAlien = new JButton("Alien");
		btnAlien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccionRaza = btnAlien.getText();
				btnAlien.setEnabled(false);
				btnHumano.setEnabled(true);
				btnRobot.setEnabled(true);
				btnSuperheroe.setEnabled(true);
			}
		});
		btnAlien.setFont(new Font("Arial", Font.PLAIN, 16));
		btnAlien.setBounds(550, 78, 120, 23);
		contentPane.add(btnAlien);
		
		JLabel lblCasta = new JLabel("CASTA");
		lblCasta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCasta.setFont(new Font("Arial", Font.PLAIN, 19));
		lblCasta.setBounds(37, 170, 70, 30);
		contentPane.add(lblCasta);
		
		btnLuchador = new JButton("Luchador");
		btnLuchador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccionCasta = btnLuchador.getText();
				btnLuchador.setEnabled(false);
				btnHechicero.setEnabled(true);
				btnLadron.setEnabled(true);
			}
		});
		btnLuchador.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLuchador.setBounds(100, 211, 120, 23);
		contentPane.add(btnLuchador);
		
		btnLadron = new JButton("Ladron");
		btnLadron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccionCasta = btnLadron.getText();
				btnLuchador.setEnabled(true);
				btnHechicero.setEnabled(true);
				btnLadron.setEnabled(false);
			}
		});
		btnLadron.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLadron.setBounds(250, 211, 120, 23);
		contentPane.add(btnLadron);
		
		btnHechicero = new JButton("Hechicero");
		btnHechicero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccionCasta = btnHechicero.getText();
				btnLuchador.setEnabled(true);
				btnHechicero.setEnabled(false);
				btnLadron.setEnabled(true);
			}
		});
		btnHechicero.setFont(new Font("Arial", Font.PLAIN, 16));
		btnHechicero.setBounds(400, 211, 120, 23);
		contentPane.add(btnHechicero);
		
		JLabel lblMapa = new JLabel("MAPA");
		lblMapa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMapa.setFont(new Font("Arial", Font.PLAIN, 19));
		lblMapa.setBounds(37, 307, 70, 30);
		contentPane.add(lblMapa);
		
		btnCampo = new JButton("Campo");
		btnCampo.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCampo.setBounds(100, 348, 120, 23);
		btnCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccionMapa = btnCampo.getText();
				btnCampo.setEnabled(false);
				btnDesierto.setEnabled(true);
				btnPlaya.setEnabled(true);
			}
		});
		contentPane.add(btnCampo);
		
		
		btnPlaya = new JButton("Playa");
		btnPlaya.setFont(new Font("Arial", Font.PLAIN, 16));
		btnPlaya.setBounds(250, 348, 120, 23);
		btnPlaya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccionMapa = btnPlaya.getText();
				btnPlaya.setEnabled(false);
				btnDesierto.setEnabled(true);
				btnCampo.setEnabled(true);
			}
		});
		contentPane.add(btnPlaya);
		
		btnDesierto = new JButton("Desierto");
		btnDesierto.setFont(new Font("Arial", Font.PLAIN, 16));
		btnDesierto.setBounds(400, 348, 120, 23);
		btnDesierto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccionMapa = btnDesierto.getText();
				//TILDO EL DE DESIERTO Y DESTILDO LOS OTROS. 
				btnDesierto.setEnabled(false);
				btnCampo.setEnabled(true);
				btnPlaya.setEnabled(true);
			}
		});
		contentPane.add(btnDesierto);
		
		btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(eleccionCasta!=null && eleccionRaza!=null && eleccionMapa!=null ){
					enviaElecionPersonaje(eleccionRaza,eleccionCasta,eleccionMapa);
					//ABRO LA PROXIMA VENTANA DEL JUEGO.
					Juego juego = new Juego(VentanaEleccion.this.cliente);
					juego.iniciar();
					dispose();
				}else JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una raza y una casta.");

			}
		});
		btnJugar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnJugar.setBounds(340, 500, 120, 30);
		contentPane.add(btnJugar);
		
	
	}
	
	private void enviaElecionPersonaje(String eleccionRaza, String eleccionCasta,String eleccionMapa) {
		this.cliente.enviarMensaje("MensajeEleccionPersonaje", new MensajeEleccionPersonaje(usuario, eleccionRaza, eleccionCasta));
		this.cliente.enviarMensaje("MensajeEleccionTerreno", new MensajeEleccionTerreno(usuario, eleccionMapa));
		
	}
}

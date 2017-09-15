package ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.ManejadorTabla;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeExample extends JFrame {

	private JPanel contentPane;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTextField txtFechaHora;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateTimeExample frame = new DateTimeExample();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DateTimeExample() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblFecha = new JLabel("Fecha");
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		
		JLabel lblHola = new JLabel("Hora");
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		
		JButton btnConvertirSeparado = new JButton("Convertir Separado");
		btnConvertirSeparado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnConvertirSeparado();
			}
		});
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora");
		
		txtFechaHora = new JTextField();
		txtFechaHora.setColumns(10);
		
		JButton btnConvertirJunto = new JButton("Convertir junto");
		btnConvertirJunto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnConvertirJuntoClicked();
			}
		});
		
		JLabel lblFechaEnFormato = new JLabel("Fecha en formato yyyy-MM-dd");
		
		JLabel lblHoraEnFormato = new JLabel("Hora en formato HH:mm");
		
		JLabel lblFormatoDeFechahora = new JLabel("Formato de fechaHora dd/MM/yyyy HH:mm");
		
		JLabel lblPeroPuedeCambiarse = new JLabel("pero puede cambiarse en el código con SimpleDateFormat");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFormatoDeFechahora)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHola)
								.addComponent(lblFecha))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(42)
									.addComponent(btnConvertirSeparado))
								.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblFechaYHora)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFechaHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnConvertirJunto))
						.addComponent(lblFechaEnFormato)
						.addComponent(lblHoraEnFormato, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPeroPuedeCambiarse))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHola)
						.addComponent(txtHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConvertirSeparado))
					.addGap(18)
					.addComponent(lblFechaEnFormato)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHoraEnFormato)
					.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFechaYHora)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtFechaHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnConvertirJunto)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFormatoDeFechahora)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPeroPuedeCambiarse)
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void btnConvertirJuntoClicked() {
		ManejadorTabla mt=new ManejadorTabla();
		
		SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			java.util.Date fechaHora=f.parse(this.txtFechaHora.getText());
			mt.guardarJunto(fechaHora);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	protected void btnConvertirSeparado() {
		ManejadorTabla mt=new ManejadorTabla();
		
		java.sql.Date fecha = Date.valueOf(this.txtFecha.getText());
		java.sql.Time hora = Time.valueOf(this.txtHora.getText());
		
		mt.guardarSeparado(fecha, hora);
	}
}

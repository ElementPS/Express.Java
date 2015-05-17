import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextArea;


public class ExpressMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpressMain frame = new ExpressMain();
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
	public ExpressMain() {
		setTitle("Express.Java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 466);
		getContentPane().setLayout(null);		
		
		JButton btnSaleRequestXml = new JButton("Sale Request XML");
		btnSaleRequestXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSaleRequestXml.setBounds(10, 11, 137, 23);
		getContentPane().add(btnSaleRequestXml);
		
		JButton btnSaleRequestSoap = new JButton("Sale Request SOAP");
		btnSaleRequestSoap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSaleRequestSoap.setBounds(157, 11, 160, 23);
		getContentPane().add(btnSaleRequestSoap);
		
		JButton btnSendTransaction = new JButton("Send Transaction");
		btnSendTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSendTransaction.setBounds(327, 11, 137, 23);
		getContentPane().add(btnSendTransaction);
		
		JButton btnHealthCheckXml = new JButton("Health Check XML");
		btnHealthCheckXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHealthCheckXml.setBounds(10, 45, 137, 23);
		getContentPane().add(btnHealthCheckXml);
		
		JButton btnHealthCheckSoap = new JButton("Health Check SOAP");
		btnHealthCheckSoap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHealthCheckSoap.setBounds(157, 45, 160, 23);
		getContentPane().add(btnHealthCheckSoap);
		
		JButton btnClearData = new JButton("Clear Data");
		btnClearData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClearData.setBounds(327, 45, 137, 23);
		getContentPane().add(btnClearData);
		
		JLabel lblRequest = new JLabel("Request:");
		lblRequest.setBounds(10, 79, 86, 14);
		getContentPane().add(lblRequest);
			
		JTextArea txtRequest = new JTextArea();
		JScrollPane sp = new JScrollPane(txtRequest);
		sp.setBounds(10, 104, 455, 131);
		getContentPane().add(sp);
		
		JLabel lblResponse = new JLabel("Response:");
		lblResponse.setBounds(10, 246, 86, 14);
		getContentPane().add(lblResponse);
				
		JTextArea txtResponse = new JTextArea();
		JScrollPane sp2 = new JScrollPane(txtResponse);
		sp2.setBounds(10, 266, 455, 151);
		getContentPane().add(sp2);

	}
}

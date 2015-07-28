package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import componentes.panelflotante.ComponentWrangler;
import componentes.panelflotante.MobileContainerPanel;

import java.awt.ComponentOrientation;

public class test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 622, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MobileContainerPanel panel = new MobileContainerPanel();
		frame.setContentPane(panel);;
		
		JLabel lbl_componente = new JLabel("test");
		lbl_componente.setIcon(new ImageIcon("C:\\Users\\rsampedr\\Desktop\\compoennte\u00E7.png"));
		lbl_componente.setBounds(194, 84, 251, 181);
		//frame.getContentPane().add(lbl_componente);
		panel.addNext(lbl_componente);
		
		
	}
}

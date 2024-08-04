/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import com.travel.clientstrips.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author 62040
 */


public class ServiceList extends javax.swing.JFrame {

	Image img = Toolkit.getDefaultToolkit().getImage(this.getClass().getClassLoader().getResource("images/welcom.jpg"));
	public ServiceList() throws IOException {
		this.setContentPane(new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, 0, 0, null);
				setLocationRelativeTo(null);
				setResizable(false);
				getContentPane().setBackground(Color.WHITE);
				setLayout(null);


				// Button specification
				Font buttons_font = new Font("Chilanka", Font.PLAIN, 18);

				JButton login_button = new JButton("Exit", new ImageIcon("src\\images\\exit.png"));
				login_button.setBounds(400, 600, 120, 40);
				login_button.setFont(buttons_font);
				login_button.addActionListener(e -> handleExit());
				this.add(login_button);
				changeLookAndFeel();

				Font Service_font = new Font("Chilanka", Font.PLAIN, 22);




				JButton User = new JButton("User", new ImageIcon("src\\images\\User.jpg"));
				User.setBounds(30, 120, 185, 180);
				User.setFont(Service_font);
				User.addActionListener(e -> handleUser());
				this.add(User);
				changeLookAndFeel();


				JButton Gide = new JButton("Gide Tour", new ImageIcon("src\\images\\OIP.jpg"));
				Gide.setBounds(345, 120, 200, 180);
				Gide.setFont(Service_font);
				Gide.addActionListener(e -> handleGide());
				this.add(Gide);
				changeLookAndFeel();



				JButton Trip = new JButton("Trip", new ImageIcon("src\\images\\trips.jpg"));
				Trip.setBounds(650, 120, 200, 180);
				Trip.setFont(Service_font);
				Trip.addActionListener(e -> handleTrip());
				this.add(Trip);
				changeLookAndFeel();




			}

			private void handleUser() {
				throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
			}
		});
		pack();

		setSize(900,700);
		setVisible(true);
	}
	public static void main(String[] args) throws Exception {
		new ServiceList();
	}


	private void handleExit() {
		setVisible(false);
	}

	private void handleClient( String username) {
		setVisible(false);
		new MainMenu(username);
	}

	private void handleGide() {
		setVisible(false);
		new Login();
	}

	private void handleTrip() {
		setVisible(false);
		new Login();
	}
	private void changeLookAndFeel() {
		UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
		try {
			UIManager.setLookAndFeel(looks[1].getClassName());
			SwingUtilities.updateComponentTreeUI(this);

		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
				 IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
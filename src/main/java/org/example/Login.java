package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login extends JFrame {
	private final JTextField username_field = new JTextField();
	private final JPasswordField password_field = new JPasswordField();
	private int count = 0;
	private Image backgroundImage;

	public Login() {
		super("Airlines System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 700);
		setLocationRelativeTo(null);
		setResizable(false);

		// Load the background image
		ImageIcon imageIcon = new ImageIcon("src\\images\\img_1.png");
		backgroundImage = imageIcon.getImage().getScaledInstance(900, 700, Image.SCALE_SMOOTH);

		// Set the custom panel as the content pane
		setContentPane(new CustomPanel());

		changeLookAndFeel();

		setVisible(true);
	}

	private class CustomPanel extends JPanel {
		public CustomPanel() {
			setLayout(null);

			// Define fonts
			Font font = new Font("Chilanka", Font.BOLD, 20);
			Font buttons_font = new Font("Chilanka", Font.PLAIN, 18);

			JLabel heading = new JLabel("LOGIN");
			heading.setFont(new Font("Chilanka", Font.BOLD, 30));
			heading.setBounds(0, 70, getWidth(), 50);
			heading.setHorizontalAlignment(JLabel.CENTER);
			add(heading);

			JLabel username_icon = new JLabel(new ImageIcon("src\\images\\users.png"));
			username_icon.setBounds(150, 200, 50, 40);
			add(username_icon);

			JLabel username_label = new JLabel("Username:");
			username_label.setFont(font);
			username_label.setBounds(200, 200, 200, 40);
			add(username_label);

			username_field.setBounds(350, 200, 250, 40);
			username_field.setToolTipText("Enter Username");
			username_field.setFont(new Font("Chilanka", Font.PLAIN, 18));
			add(username_field);

			JLabel password_icon = new JLabel(new ImageIcon("src\\images\\pass.png"));
			password_icon.setBounds(150, 260, 50, 30);
			add(password_icon);

			JLabel password_label = new JLabel("Password:");
			password_label.setFont(font);
			password_label.setBounds(200, 260, 200, 30);
			add(password_label);

			password_field.setBounds(350, 260, 250, 40);
			password_field.setToolTipText("Enter Password");
			password_field.setFont(new Font("Chilanka", Font.PLAIN, 18));
			add(password_field);

			// Create the buttons panel
			JPanel buttons_panel = new JPanel();
			buttons_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0)); // Center align with spacing between buttons

			buttons_panel.setBounds(0, 370, 900, 50); // Full width, no need to calculate center manually
			buttons_panel.setOpaque(false); // Make the panel transparent so the background is visible

			// Add buttons to the panel
			JButton login_button = new JButton("Login", new ImageIcon("images//Login.png"));
			login_button.setFont(buttons_font);
			login_button.addActionListener(e -> handleLogin());
			buttons_panel.add(login_button);

			JButton clear_button = new JButton("Clear", new ImageIcon("images//clear.png"));
			clear_button.setFont(buttons_font);
			clear_button.addActionListener(e -> handleClear());
			buttons_panel.add(clear_button);

			JButton exit_button = new JButton("Exit", new ImageIcon("images//exit.png"));
			exit_button.setFont(buttons_font);
			exit_button.addActionListener(e -> System.exit(0));
			buttons_panel.add(exit_button);

			JButton Acc_button = new JButton("New Account", new ImageIcon("images//exit.png"));
			Acc_button.setFont(buttons_font);
			Acc_button.addActionListener(e -> handleAcc());
			buttons_panel.add(Acc_button);

			// Add the buttons panel to the main panel
			add(buttons_panel);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// Draw the background image
			g.drawImage(backgroundImage, 0, 0, this);
		}
	}

	private void handleLogin() {
		String username = username_field.getText();
		String password = String.valueOf(password_field.getPassword());

		if (validateUser(username, password)) {
			setVisible(false);
			new MainMenu(username);
		} else {
			checkCounter();
		}
	}

	private boolean validateUser(String username, String password) {
		String filePath = "src/main/java/com/travel/clientstrips/Users.txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("-");
				if (parts.length >= 7) { // Ensure there are enough parts in the line
					String storedName = parts[0];
					String storedPassword = parts[1];
					if (storedName.equals(username) && storedPassword.equals(password)) {
						return true; // Valid user found
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			showMessage("Error reading user data: " + e.getMessage());
		}
		return false; // No valid user found
	}

	private void handleAcc() {
//		JFrame AddWindow = new JFrame("New Account");
//		AddWindow.setSize(400, 300);
//		AddWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		new AddNewAcc();
			AddNewAcc registerWindow = new AddNewAcc();
			registerWindow.setVisible(true);
	}

	private void checkCounter() {
		count++;
		JOptionPane.showMessageDialog(this, "Invalid user credentials!!!", null, JOptionPane.ERROR_MESSAGE);
		handleClear();
		if (count == 3) {
			JOptionPane.showMessageDialog(this, "Maximum attempts reached!", null, JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	private void handleClear() {
		username_field.setText("");
		password_field.setText("");
	}

	private void changeLookAndFeel() {
		UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
		try {
			UIManager.setLookAndFeel(looks[1].getClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message, null, JOptionPane.WARNING_MESSAGE);
	}

	public static void main(String[] args) {
		new Login();
	}
}

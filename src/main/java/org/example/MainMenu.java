package org.example;

import com.travel.clientstrips.AddNewTrip;
import com.travel.clientstrips.TripList;
import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	int width = screen.width - 50;
	int height = screen.height - 50;

	private Image backgroundImage;

	public MainMenu(String username) {
		super("Main Menu");
		System.out.println("username in main menu is: " + username);
		setSize(900, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Load the background image
		ImageIcon imageIcon = new ImageIcon("src\\images\\img_3.png");
		backgroundImage = imageIcon.getImage().getScaledInstance(900, 700, Image.SCALE_SMOOTH);

		// Set the custom panel as the content pane
		setContentPane(new CustomPanel(username));

		setVisible(true);
	}

	private class CustomPanel extends JPanel {
		public CustomPanel(String username) {
			setLayout(new GridBagLayout()); // Use GridBagLayout for centering components

			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);

			JMenu about_menu = new JMenu("About");
			menuBar.add(about_menu);
			JMenuItem m4_1 = new JMenuItem("About System", new ImageIcon("images//help.png"));
			about_menu.add(m4_1);

			JMenu exit_menu = new JMenu("Exit");
			menuBar.add(exit_menu);
			JMenuItem m5_1 = new JMenuItem("Exit", new ImageIcon("images//exit.png"));
			exit_menu.add(m5_1);

			// Create the buttons panel
			JPanel buttons_panel = new JPanel();
			buttons_panel.setLayout(new BoxLayout(buttons_panel, BoxLayout.Y_AXIS)); // Vertical layout
			buttons_panel.setOpaque(false); // Make the panel transparent so the background is visible

			// Define fonts
			Font buttons_font = new Font("Chilanka", Font.BOLD, 24); // Larger font

			// Create buttons
			JButton btnAddNewClientTrip = new JButton("Add New Trip", new ImageIcon("src//images//add.png"));
			JButton btnViewBookedTrips = new JButton("View Booked Trips", new ImageIcon("src//images//view.png"));

			// Set font and preferred size for larger buttons
			btnAddNewClientTrip.setFont(buttons_font);
			btnViewBookedTrips.setFont(buttons_font);

			// Set button size (width, height)
			Dimension buttonSize = new Dimension(300, 80);
			btnAddNewClientTrip.setPreferredSize(buttonSize);
			btnViewBookedTrips.setPreferredSize(buttonSize);

			// Center buttons horizontally
			btnAddNewClientTrip.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnViewBookedTrips.setAlignmentX(Component.CENTER_ALIGNMENT);

			// Add space between buttons
			buttons_panel.add(Box.createVerticalStrut(20)); // Add some vertical spacing before buttons
			buttons_panel.add(btnAddNewClientTrip);
			buttons_panel.add(Box.createVerticalStrut(20)); // Space between buttons
			buttons_panel.add(btnViewBookedTrips);
			buttons_panel.add(Box.createVerticalStrut(20)); // Add some vertical spacing after buttons

			// Add action listeners
			btnAddNewClientTrip.addActionListener(e -> new AddNewTrip(username));
			btnViewBookedTrips.addActionListener(e -> new TripList(username));

			m4_1.addActionListener(e -> new About());
			m5_1.addActionListener(e -> System.exit(0));

			// Add the buttons panel to the center of the main panel
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.anchor = GridBagConstraints.CENTER;
			add(buttons_panel, gbc);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// Draw the background image
			g.drawImage(backgroundImage, 0, 0, this);
		}
	}

	public static void main(String[] args, String username) {
		new MainMenu(username);
	}
}

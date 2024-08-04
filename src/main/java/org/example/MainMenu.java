package org.example;



import com.travel.clientstrips.AddNewTrip;

import java.awt.event.ActionListener;

import com.travel.clientstrips.SearchTrip;
import com.travel.clientstrips.UpdateTrip;
import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	int width = screen.width - 50;
	int height = screen.height - 50;

	public MainMenu(String username) {
		super("Main Menu");
		System.out.println("usernamein main menu is:"+username);
		setSize(900, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		JLabel label = new JLabel("Airlines");
//		label.setFont(new Font("Chilanka",Font.BOLD,35));
//		add(label);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// Assuming you have a JPanel named contentPane to hold the buttons
		JPanel contentPane = new JPanel(new FlowLayout()); // Or any desired layout

		// Create buttons
		JButton btnAddNewClientTrip = new JButton("Add New Trip", new ImageIcon("src//images//add.png"));
		JButton btnSearchClientTrip = new JButton("Search Trip", new ImageIcon("src//images//search.png"));
		//   JButton btnListOfClientTrips = new JButton("List of all Trips", new ImageIcon("src//images//all.png"));
		JMenu supplier_menu = new JMenu("Clients Trips");
//		menuBar.add(supplier_menu);
//		JMenuItem m1_1 = new JMenuItem("Add New Client Trip", new ImageIcon("src//images//add.png"));
//		supplier_menu.add(m1_1);
//		JMenuItem m1_2 = new JMenuItem("search Client Trip", new ImageIcon("src//images//search.png"));
//		supplier_menu.add(m1_2);
//		JMenuItem m1_3 = new JMenuItem("Postpone Client Trip", new ImageIcon("src//images//update.png"));
//		supplier_menu.add(m1_3);
//		JMenuItem m1_4 = new JMenuItem("Delete Client Trip", new ImageIcon("src//images//delete.png"));
//		supplier_menu.add(m1_4);
//		JMenuItem m1_5 = new JMenuItem("List of Client Trips", new ImageIcon("src//images//all.png"));
//		supplier_menu.add(m1_5);

//		JMenu medicine_menu = new JMenu("Tour Guide ");
//		menuBar.add(medicine_menu);
//		JMenuItem m2_1 = new JMenuItem("Add New Tour Guide", new ImageIcon("src//images//add.png"));
//		medicine_menu.add(m2_1);
//                JMenuItem m2_2 = new JMenuItem("Search Tour Guide", new ImageIcon("src//images//search.png"));
//		medicine_menu.add(m2_2);
//		JMenuItem m2_3 = new JMenuItem("Assign Tour Guide", new ImageIcon("src//images//update.png"));
//		medicine_menu.add(m2_3);
	/*	JMenuItem m2_4 = new JMenuItem("Delete Tour", new ImageIcon("src//images//delete.png"));
		medicine_menu.add(m2_4);
		JMenuItem m2_5 = new JMenuItem("Stock of Tour", new ImageIcon("src//images//all.png"));
		medicine_menu.add(m2_5);*/

//		JMenu report_menu = new JMenu("Trips");
//                menuBar.add(report_menu);
//	/*	JMenuItem m3_1 = new JMenuItem("Trips Calander", new ImageIcon("src//images//report.png"));
//		report_menu.add(m3_1); */
//		JMenuItem m3_2 = new JMenuItem("Trips Profit", new ImageIcon("src//images//report.png"));
//		report_menu.add(m3_2);

		JMenu about_menu = new JMenu("About");
		menuBar.add(about_menu);
		JMenuItem m4_1 = new JMenuItem("About System", new ImageIcon("images//help.png"));
		about_menu.add(m4_1);

		JMenu exit_menu = new JMenu("Exit");
		menuBar.add(exit_menu);
		JMenuItem m5_1 = new JMenuItem("Exit", new ImageIcon("images//exit.png"));
		exit_menu.add(m5_1);
		btnAddNewClientTrip.addActionListener(e -> new AddNewTrip(username));
		btnSearchClientTrip.addActionListener(e -> new SearchTrip());
		// btnPostponeClientTrip.addActionListener(e -> new UpdateTrip());
		// btnDeleteClientTrip.addActionListener(e -> new DeleteTrip());
		//     btnListOfClientTrips.addActionListener(e -> new TripList());
		//  m1_1.addActionListener(e -> new AddNewTrip());
//		m1_2.addActionListener(e -> new SearchTrip());
//		m1_3.addActionListener(e -> new UpdateTrip());
//		m1_4.addActionListener(e -> new DeleteTrip());
//                m1_5.addActionListener(e -> new TripList());
//		m2_1.addActionListener(e -> new com.travel.guides.AddNewTourGuide());
//		m2_2.addActionListener(e -> new com.travel.guides.SearchTourGuide());
//		m2_3.addActionListener(e -> new com.travel.guides.AssignTourGuide());
		//m2_4.addActionListener(e -> new DeleteMedicine());
		//m2_5.addActionListener(e -> new MedicineList());
		//m3_1.addActionListener(e -> new DailyPurchaseReport());
		//m3_2.addActionListener(e -> new com.travel.clientstrips.TripProfit());
		m4_1.addActionListener(e -> new About());
		m5_1.addActionListener(e -> System.exit(0));
		contentPane.add(btnAddNewClientTrip);
		contentPane.add(btnSearchClientTrip);

		//     contentPane.add(btnListOfClientTrips);
		setVisible(true);
		getContentPane().add(contentPane);

	}

	public static void main(String[] args, String username) {
		new MainMenu(username);
	}
}

package com.travel.clientstrips;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SearchTrip extends JFrame {
	private final JTextField id_field = new JTextField();
	private final JTextField name_field = new JTextField();
	private final JTextField age_field = new JTextField();
	

	private final DefaultTableModel model = new DefaultTableModel();

	private final TripService tripService;

	public SearchTrip() {
		super("Search Client Trips");
		setSize(950,720);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

		Font font = new Font("Chilanka", Font.BOLD, 20);
		Font fields_font = new Font("Chilanka", Font.PLAIN, 18);
		Color background_color = Color.CYAN;

		JLabel heading = new JLabel("Search Client Trips");
		heading.setFont(new Font("Chilanka",Font.BOLD,30));
		heading.setBounds(0,40,getWidth(),40);
		heading.setHorizontalAlignment(JLabel.CENTER);
		heading.setForeground(Color.blue);
		add(heading);

		JLabel l1 = new JLabel("Client id:");
		l1.setBounds(200,110,200,30);
		l1.setFont(font);
		add(l1);

		id_field.setBounds(420,110,300,30);
		id_field.setToolTipText("Enter Client Id");
		id_field.setFont(fields_font);
		add(id_field);

//		JLabel l2 = new JLabel("Client Name:");
//		l2.setBounds(200,160,200,30);
//		l2.setFont(font);
//		add(l2);
//
//		name_field.setBounds(420,160,300,30);
//		name_field.setFont(fields_font);
//		name_field.setEditable(false);
//		add(name_field);
//
//		JLabel l3 = new JLabel("Client Age:");
//		l3.setBounds(200,210,200,30);
//		l3.setFont(font);
//		add(l3);
//
//		age_field.setBounds(420,210,300,30);
//		age_field.setFont(fields_font);
//		age_field.setEditable(false);
//		add(age_field);

	/*	JLabel l4 = new JLabel("Trip Duration:");
		l4.setBounds(200,260,200,30);
		l4.setFont(font);
		add(l4);

		Duration_field.setBounds(420,260,300,30);
		Duration_field.setFont(fields_font);
		Duration_field.setEditable(false);
		add(Duration_field);

		JLabel l5 = new JLabel("Price:");
		l5.setBounds(200,310,200,30);
		l5.setFont(font);
		add(l5);

		Price_field.setBounds(420,310,300,30);
		Price_field.setFont(fields_font);
		Price_field.setEditable(false);
		add(Price_field);*/

		JPanel buttons_panel = new JPanel();
		buttons_panel.setBounds(0, 360, getWidth(), 40);
		buttons_panel.setBackground(background_color); 

		JButton search_button = new JButton("Search", new ImageIcon("images//search.png"));
		search_button.setBounds(150,330,110,35);
		search_button.setFont(fields_font);
		search_button.setToolTipText("click to open Trip details");
		search_button.addActionListener(e -> handleSearch());
		buttons_panel.add(search_button);

		JButton clear_button = new JButton("Clear", new ImageIcon("images//clear.png"));
		clear_button.setToolTipText("click to clear all text fields");
		clear_button.setFont(fields_font);
		clear_button.addActionListener(e -> handleClear());
		buttons_panel.add(clear_button);

                
              
                                
		JButton all_button = new JButton("All", new ImageIcon("images//all.png"));
		all_button.setToolTipText("click to view all Trip details");
		all_button.setFont(fields_font);
		all_button.addActionListener(e -> handleAll());
		buttons_panel.add(all_button);

		add(buttons_panel);

		JTable tabGrid = new JTable(model);                
		JScrollPane scrollPane = new JScrollPane(tabGrid);
		scrollPane.setBounds(0, 405, getWidth(), getHeight() - 440);
		add(scrollPane);
		tabGrid.setFont(new Font ("Chilanka", Font.PLAIN,16));
                model.addColumn("Trip ID");
		model.addColumn("Trip Type");
		model.addColumn("Date");
		model.addColumn("Price");
                model.addColumn("Duration");
//		model.addColumn("Profit");
//		model.addColumn("Details");

                JButton update_button = new JButton("Postpone", new ImageIcon("src//images//update.png"));
		update_button.setFont(fields_font);
		update_button.setToolTipText("click to update supplier details");
		update_button.addActionListener(e -> handleUpdate(tabGrid));
		buttons_panel.add(update_button);

                
                JButton delete_button = new JButton("Delete", new ImageIcon("images//delete.png"));
                delete_button.setToolTipText("click to delete supplier details");
                delete_button.setFont(fields_font);
                delete_button.addActionListener(e -> handleDelete(tabGrid));
                buttons_panel.add(delete_button);
                
                
		getContentPane().setBackground(background_color);
		tripService = new TripService();
		setVisible(true);
	}

	private void handleSearch() {
		String id = id_field.getText();
		if (id.isBlank()) {
			showMessage("Please enter Client id!");
		} else {
                    int row = 0;
                    model.setRowCount(0);
			List<ClientsTrips> trips = tripService.getTrips(Integer.parseInt(id));
                         
                  for (ClientsTrips trip: trips) {                       
			model.insertRow(row++, new Object[] {trip.getTripid(),trip.getTriptype(), trip.getTripdate(), trip.getPrice(), trip.getDuration()});
                        //, trip.getProfit(), trip.getDetails()
                        id_field.setText(String.valueOf(trip.getId()));
//			name_field.setText(trip.getClientname());
//			age_field.setText(trip.getAge());	                                                
		}			                                                                       
		}
	}

	private void handleClear() {
		id_field.setText("");
		name_field.setText("");
		age_field.setText("");
		model.removeRow(1);
                model.setRowCount(0);
	}

	private void handleAll() {
		int row = 0;
                model.setRowCount(0);
		List<Trip> trips = tripService.getTrips();
		for (Trip trip: trips) {
			model.insertRow(row++, new Object[] {trip.getTripType(), trip.getTripDate(), trip.getPrice(), trip.getDuration(), trip.getProfit()});
		}
	}

        private void handleUpdate(JTable tabGrid) {
		int  selectedRows = tabGrid.getSelectedRow();
                
                String tripid = (String) model.getValueAt(selectedRows, 0) ;
                String triptype = (String) model.getValueAt(selectedRows, 1) ;
                 new UpdateTrip(id_field.getText() ,name_field.getText() ,  tripid,triptype);
         //       if (selectedRows.length > 0) {
         //           for (int i = selectedRows.length - 1; i >= 0; i--) {
         //                   model.removeRow(selectedRows[i]);
         //           }
         //       }                
	}
        
         private void handleDelete(JTable tabGrid) {
             
             int [] selectedRows = tabGrid.getSelectedRows();
                if (selectedRows.length > 0) {
                    for (int i = selectedRows.length - 1; i >= 0; i--) {
                            model.removeRow(selectedRows[i]);
                    }
                }                
                 }

        
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message, null, JOptionPane.WARNING_MESSAGE);
	}

	public static void main(String[] args) {
	    new SearchTrip();
	}
}

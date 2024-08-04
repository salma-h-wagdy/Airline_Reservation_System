package com.travel.clientstrips;

//import com.medical.store.supplier.connection.SupplierService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import org.example.Login;

public class AddNewTrip extends JFrame {
    private final JTextField id_field = new JTextField();
    private final JTextField name_field = new JTextField();
    private final JTextField tripId_field = new JTextField();
    private final JTextField triptype_field = new JTextField();
    private final JTextField tripdate_field = new JTextField();
    private final JTextField tripduration_field = new JTextField();
    private final JTextField tripprofit_field = new JTextField();
    private final JTextField No_pass_field = new JTextField();
    
    //private final JTextField tripdetail_field = new JTextField();

    private final DefaultTableModel model = new DefaultTableModel();

   // public AddNewTrip(String username){};
    private final TripService tripService;

  
    public AddNewTrip() {
        super("Add New Trip");
        setSize(950,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        Font font = new Font("Chilanka", Font.BOLD, 20);
        Font fields_font = new Font("Chilanka", Font.PLAIN, 18);
        Color background_color = Color.CYAN;

        JLabel heading = new JLabel("New Trip Details");
        heading.setFont(new Font("Chilanka",Font.BOLD,30));
        heading.setBounds(0,5,getWidth(),40);
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setVerticalAlignment(JLabel.CENTER);
        heading.setForeground(Color.blue);
        add(heading);
//        
//         JLabel l0 = new JLabel("Name:");
//        l0.setFont(font);
//        l0.setBounds(200, 55, 200, 35);
//        add(l0);
//
//        id_field.setBounds(420, 55, 300, 35);
//        id_field.setToolTipText("Enter your name");
//        id_field.setFont(fields_font);
//        add(name_field);
        
        JLabel l1 = new JLabel("Passport number:");
        l1.setFont(font);
        l1.setBounds(200, 55, 200, 35);
        add(l1);

        id_field.setBounds(420, 55, 300, 35);
        id_field.setToolTipText("Enter passport number");
        id_field.setFont(fields_font);
        add(id_field);
        
        

        JLabel l2 = new JLabel("Flight Id:");
        l2.setFont(font);
        l2.setBounds(200, 110, 200, 35);
        add(l2);

        tripId_field.setBounds(420, 110, 300, 35);
        tripId_field.setToolTipText("Enter Flight ID");
        tripId_field.setFont(fields_font);
        add(tripId_field);

        JLabel l3 = new JLabel("Flight Type:");
        l3.setFont(font);
        l3.setBounds(200,165,200,35);
        add(l3);

        triptype_field.setBounds(420, 165, 300, 35);
        triptype_field.setToolTipText("Enter Flight Type");
        triptype_field.setFont(fields_font);
        add(triptype_field);

        JLabel l4 = new JLabel("Flight Date:");
        l4.setFont(font);
        l4.setBounds(200,220,200,35);
        add(l4);

        tripdate_field.setBounds(420,220,300,35);
        tripdate_field.setToolTipText("Enter Flight Date");
        tripdate_field.setFont(fields_font);
        add(tripdate_field);

        JLabel l5 = new JLabel("Passengers' Number");
        l5.setFont(font);
        l5.setBounds(200,275,200,35);
        add(l5);

        No_pass_field.setBounds(420,275,300,35);
        No_pass_field.setToolTipText("Enter number of passengers");
        No_pass_field.setFont(fields_font);
        add(No_pass_field);

        JPanel buttons_panel = new JPanel();
        buttons_panel.setBounds(0, 330, getWidth(), 50);
        buttons_panel.setBackground(background_color);

        JButton save_button = new JButton("Save", new ImageIcon("src//images//save.png"));
        save_button.setFont(fields_font);
        save_button.setToolTipText("click to save supplier details");
        save_button.addActionListener(e -> handleSave());
        buttons_panel.add(save_button);

//        JButton clear_button = new JButton("Clear", new ImageIcon("src//images//clear.png"));
//        clear_button.setFont(fields_font);
//        clear_button.setToolTipText("click to clear all text fields");
//        clear_button.addActionListener(e -> clearFields());
//        buttons_panel.add(clear_button);

        JButton all_button = new JButton("All", new ImageIcon("src//images//all.png"));
        all_button.setFont(fields_font);
        all_button.setToolTipText("click to view all trips details");
        all_button.addActionListener(e -> handleAll());
        buttons_panel.add(all_button);
        
        JButton search_button = new JButton("Search", new ImageIcon("src//images//search.png"));
        search_button.setFont(fields_font);
        search_button.setToolTipText("click to view all trips details");
        search_button.addActionListener(e -> handlesearch());
        buttons_panel.add(search_button);

        add(buttons_panel);

        JTable tabGrid = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabGrid);
        scrollPane.setBounds(0,380, getWidth(), getHeight() - 420);
        add(scrollPane);
        tabGrid.setFont(new Font ("Chilanka", Font.PLAIN,16));

                model.addColumn("Passport Number");
                model.addColumn("Name");
		model.addColumn("Flight ID");
                model.addColumn("Flight Type");
                model.addColumn("Flight Date");
                model.addColumn("Price per Ticket");
                model.addColumn("Trip Duration");
                model.addColumn("Total cost");
		model.addColumn("Number Of Passengers");
		//model.addColumn("Details");

        getContentPane().setBackground(background_color);
        tripService = new TripService();
        setVisible(true);
    }

    private void handleSave() {
        String id_str = id_field.getText();
        String name = name_field.getText();
        String tripid = tripId_field.getText();
        String triptype = triptype_field.getText();
        String tripdate = tripdate_field.getText();
        String trippriceStr = tripprofit_field.getText();
        String tripduration = tripduration_field.getText();
        String tripprofitStr = tripprofit_field.getText();
        String No_passStr = No_pass_field.getText();
        
            int tripprice = Integer.parseInt(trippriceStr);
            int profit = Integer.parseInt(tripprofitStr);
            int No_pass = Integer.parseInt(No_passStr);
        //String tripdetail = tripdetail_field.getText();
        tripService.addNewTrip(id_str,name,tripid ,triptype, tripdate,tripprice,tripduration,profit,No_pass);
        
        clearFields();
    }
    
    private void handlesearch(){
        JFrame searchWindow = new JFrame("Search Trip");
    searchWindow.setSize(400, 300); // Adjust size as needed
    searchWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the search window

    // Add search components to the searchWindow (e.g., text fields, labels, buttons)

     new SearchTrip();
    }

    private void clearFields() {
        No_pass_field.setText("");
        tripId_field.setText("");
        triptype_field.setText("");
        tripdate_field.setText("");
       // passnumber_field.setText("");
    }

    private void handleAll() {
        int row = 0;
        List<Trip> trips = tripService.getTrips();
        for (Trip trip: trips) {
            model.insertRow(row++, new Object[] {trip.getId(),trip.getClientName(),trip.getTripid(),  trip.getTripType(), trip.getTripDate(),trip.getPrice(), trip.getDuration(),trip.getProfit(),trip.getNo_pass()});
        }//trip.getAge(),,trip.getDetails()
    }

    public static void main(String[] args) {
        new AddNewTrip();
    }

}
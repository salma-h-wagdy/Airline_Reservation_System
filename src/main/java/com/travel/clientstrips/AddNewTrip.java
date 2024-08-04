package com.travel.clientstrips;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AddNewTrip extends JFrame {
    private final JTextField id_field = new JTextField();
    private final JTextField name_field = new JTextField();
    private final JTextField tripId_field = new JTextField();
    private final JComboBox<String> triptype_combobox; // Changed to JComboBox
    private final JTextField tripdate_field = new JTextField();
    private final JTextField tripduration_field = new JTextField();
    private final JTextField No_pass_field = new JTextField();

    // Add a JCheckBox for return flight
    private final JCheckBox oneWayTripCheckbox = new JCheckBox("One Way Flight");

    private final DefaultTableModel model = new DefaultTableModel();
    private final TripService tripService;

    public AddNewTrip(String username) {
        super("Add New Trip");
        User user = new User();
        user=user.validateUser(username);
        System.out.println("Username in add new trip: " + user.getName());
        setSize(950, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        Font font = new Font("Chilanka", Font.BOLD, 15);
        Font fields_font = new Font("Chilanka", Font.PLAIN, 13);
        Color background_color = Color.CYAN;

        JLabel heading = new JLabel("New Trip Details");
        heading.setFont(new Font("Chilanka", Font.BOLD, 30));
        heading.setBounds(0, 5, getWidth(), 40);
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setVerticalAlignment(JLabel.CENTER);
        heading.setForeground(Color.blue);
        add(heading);

        JLabel l1 = new JLabel("Passport Number:");
        l1.setFont(font);
        l1.setBounds(200, 55, 200, 25);
        add(l1);

        id_field.setBounds(420, 55, 300, 25);
        id_field.setToolTipText("Passport number (display only)");
        id_field.setFont(fields_font);
        id_field.setText(String.valueOf(user.getId()));
        id_field.setEditable(false); // Make field non-editable
        add(id_field);

        JLabel l7 = new JLabel("Name:");
        l7.setFont(font);
        l7.setBounds(200, 80, 200, 25);
        add(l7);

        name_field.setBounds(420, 80, 300, 25);
        name_field.setToolTipText("Name (display only)");
        name_field.setFont(fields_font);
        name_field.setText(user.getName());
        name_field.setEditable(false); // Make field non-editable
        add(name_field);

        JLabel l2 = new JLabel("Flight Id:");
        l2.setFont(font);
        l2.setBounds(200, 105, 200, 25);
        add(l2);

        tripId_field.setBounds(420, 105, 300, 25);
        tripId_field.setToolTipText("Enter Flight ID");
        tripId_field.setFont(fields_font);
        add(tripId_field);

        JLabel l3 = new JLabel("Flight Type:");
        l3.setFont(font);
        l3.setBounds(200, 135, 200, 25);
        add(l3);

        // Initialize JComboBox with flight type options
        String[] flightTypes = {"Economy", "Business", "First Class"};
        triptype_combobox = new JComboBox<>(flightTypes);
        triptype_combobox.setBounds(420, 135, 300, 25);
        triptype_combobox.setFont(fields_font);
        add(triptype_combobox);

        JLabel l4 = new JLabel("Flight Date:");
        l4.setFont(font);
        l4.setBounds(200, 165, 200, 25);
        add(l4);

        tripdate_field.setBounds(420, 165, 300, 25);
        tripdate_field.setToolTipText("Enter Flight Date");
        tripdate_field.setFont(fields_font);
        add(tripdate_field);

        oneWayTripCheckbox.setFont(font);
        oneWayTripCheckbox.setBounds(420, 195, 300, 25);
        oneWayTripCheckbox.setBackground(background_color);
        add(oneWayTripCheckbox);

        // Add ItemListener to JCheckBox to enable/disable duration field
        oneWayTripCheckbox.addItemListener(e -> {
            if (oneWayTripCheckbox.isSelected()) {
                tripduration_field.setEnabled(false); // Disable duration field for return flights
                tripduration_field.setText(""); // Clear the duration field
            } else {
                tripduration_field.setEnabled(true); // Enable duration field for other flight types
            }
        });

        JLabel l6 = new JLabel("Duration in days:");
        l6.setFont(font);
        l6.setBounds(200, 225, 200, 25);
        add(l6);

        tripduration_field.setBounds(420, 225, 300, 25);
        tripduration_field.setToolTipText("Enter number of days");
        tripduration_field.setFont(fields_font);
        add(tripduration_field);

        JLabel l5 = new JLabel("Passengers' Number:");
        l5.setFont(font);
        l5.setBounds(200, 255, 200, 25);
        add(l5);

        No_pass_field.setBounds(420, 255, 300, 25);
        No_pass_field.setToolTipText("Enter number of passengers");
        No_pass_field.setFont(fields_font);
        add(No_pass_field);

        JPanel buttons_panel = new JPanel();
        buttons_panel.setBounds(0, 330, getWidth(), 50);
        buttons_panel.setBackground(background_color);

        JButton save_button = new JButton("Save", new ImageIcon("src//images//save.png"));
        save_button.setFont(fields_font);
        save_button.setToolTipText("Click to save trip details");
        save_button.addActionListener(e -> handleSave());
        buttons_panel.add(save_button);

        JButton search_button = new JButton("Search", new ImageIcon("src//images//search.png"));
        search_button.setFont(fields_font);
        search_button.setToolTipText("Click to search trips");
        search_button.addActionListener(e -> handleSearch());
        buttons_panel.add(search_button);

        add(buttons_panel);

        JTable tabGrid = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabGrid);
        scrollPane.setBounds(0, 380, getWidth(), getHeight() - 420);
        add(scrollPane);
        tabGrid.setFont(new Font("Chilanka", Font.PLAIN, 16));

        model.addColumn("Passport Number");
        model.addColumn("Name");
        model.addColumn("Flight ID");
        model.addColumn("Flight Type");
        model.addColumn("Flight Date");
        model.addColumn("Trip Duration in days");
        model.addColumn("Total Cost $");
        model.addColumn("Number Of Passengers");

        getContentPane().setBackground(background_color);
        tripService = new TripService();
        setVisible(true);
    }

    private void handleSave() {
        // Get data from input fields
        String id_str = id_field.getText();
        String name = name_field.getText();
        String tripid = tripId_field.getText();
        String triptype = (String) triptype_combobox.getSelectedItem();
        String tripdate = tripdate_field.getText();
        String tripduration = tripduration_field.getText();
        String No_passStr = No_pass_field.getText();

        // Parse necessary data
        int id = Integer.parseInt(id_str);
        int numPassengers = Integer.parseInt(No_passStr);
        int totalProfit = calculateFare(numPassengers, triptype);

        // Create a User object
        User user = new User(id, name, 0, "", "", "", ""); // Adjust User constructor as needed

        // Determine if it's a one-way flight
        if (oneWayTripCheckbox.isSelected()) {
            tripduration = "0"; // For one way flight, set duration to 0
        }

        // Create a ClientsTrips object using the User
        ClientsTrips trip = new ClientsTrips(user, tripid, triptype, tripdate, totalProfit, tripduration, totalProfit, numPassengers);

        // Save the trip and update the table
        tripService.addNewTrip(id_str, name, tripid, triptype, tripdate, tripduration, totalProfit, numPassengers);
        model.addRow(new Object[]{id_str, name, tripid, triptype, tripdate, tripduration, totalProfit, numPassengers});
        clearFields();
    }

    private void handleSearch() {
        JFrame searchWindow = new JFrame("Search Trip");
        searchWindow.setSize(400, 300); // Adjust size as needed
        searchWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the search window

       // new SearchTrip();
    }

    private void clearFields() {
        No_pass_field.setText("");
        tripId_field.setText("");
        tripdate_field.setText("");
        tripduration_field.setText("");
        No_pass_field.setText("");
        triptype_combobox.setSelectedIndex(0); // Reset to default option
        oneWayTripCheckbox.setSelected(false); // Reset the checkbox
    }

    private int calculateFare(int numPassengers, String flightType) {
        final int ECONOMY_PRICE = 500;
        final int BUSINESS_PRICE = 1000;
        final int FIRST_CLASS_PRICE = 2000;

        int pricePerTicket = 0;

        switch (flightType.toLowerCase()) {
            case "economy":
                pricePerTicket = ECONOMY_PRICE;
                break;
            case "business":
                pricePerTicket = BUSINESS_PRICE;
                break;
            case "first class":
                pricePerTicket = FIRST_CLASS_PRICE;
                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid flight type");
                return 0;
        }

        return pricePerTicket * numPassengers;
    }

    public static void main(String[] args) {

    }
}

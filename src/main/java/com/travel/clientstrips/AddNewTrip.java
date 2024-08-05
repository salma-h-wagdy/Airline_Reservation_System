package com.travel.clientstrips;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddNewTrip extends JFrame {
    private final JTextField id_field = new JTextField();
    private final JTextField name_field = new JTextField();
    private final JTextField tripId_field = new JTextField();
    private final JComboBox<String> triptype_combobox; // Changed to JComboBox
    private final JTextField tripdate_field = new JTextField();
    private final JTextField tripduration_field = new JTextField();
    private final JTextField No_pass_field = new JTextField();
    private final JComboBox<String> source_combobox = new JComboBox<>();
    private final JComboBox<String> destination_combobox = new JComboBox<>();

    private final JCheckBox oneWayTripCheckbox = new JCheckBox("One Way Flight");

    private final DefaultTableModel model = new DefaultTableModel();
    private final TripService tripService;
    private String FlightId;
    private String ArrivalTime;
    private String DepartureTime;

    public AddNewTrip(String username) {
        super("Add New Trip");
        User user = new User();
        user = user.validateUser(username);


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

//        JLabel l2 = new JLabel("Flight ID:");
//        l2.setFont(font);
//        l2.setBounds(200, 105, 200, 25);
//        add(l2);
//
//        tripId_field.setBounds(420, 105, 300, 25);
//        tripId_field.setToolTipText("Enter Flight ID");
//        tripId_field.setFont(fields_font);
//        name_field.setText(user.getName());
//        name_field.setEditable(false);
//        add(tripId_field);

        JLabel l3 = new JLabel("Flight Type:");
        l3.setFont(font);
        l3.setBounds(200, 105, 200, 25);
        add(l3);

        String[] flightTypes = {"Economy", "Business", "First Class"};
        triptype_combobox = new JComboBox<>(flightTypes);
        triptype_combobox.setBounds(420, 105, 300, 25);
        triptype_combobox.setFont(fields_font);
        add(triptype_combobox);

        JLabel l4 = new JLabel("Flight Date:");
        l4.setFont(font);
        l4.setBounds(200, 135, 200, 25);
        add(l4);

        tripdate_field.setBounds(420, 135, 300, 25);
        tripdate_field.setToolTipText("Enter Flight Date");
        tripdate_field.setFont(fields_font);
        add(tripdate_field);

        oneWayTripCheckbox.setFont(font);
        oneWayTripCheckbox.setBounds(420, 165, 300, 25);
        oneWayTripCheckbox.setBackground(background_color);
        add(oneWayTripCheckbox);

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
        l6.setBounds(200, 195, 200, 25);
        add(l6);

        tripduration_field.setBounds(420, 195, 300, 25);
        tripduration_field.setToolTipText("Enter number of days");
        tripduration_field.setFont(fields_font);
        add(tripduration_field);

        JLabel l5 = new JLabel("Passengers' Number:");
        l5.setFont(font);
        l5.setBounds(200, 225, 200, 25);
        add(l5);

        No_pass_field.setBounds(420, 225, 300, 25);
        No_pass_field.setToolTipText("Enter number of passengers");
        No_pass_field.setFont(fields_font);
        add(No_pass_field);

        JLabel l8 = new JLabel("Source:");
        l8.setFont(font);
        l8.setBounds(200, 255, 200, 25);
        add(l8);

        source_combobox.setBounds(420, 255, 300, 25);
        source_combobox.setFont(fields_font);
        source_combobox.addActionListener(e -> updateDestinations());
        add(source_combobox);

        JLabel l9 = new JLabel("Destination:");
        l9.setFont(font);
        l9.setBounds(200, 285, 200, 25);
        add(l9);

        destination_combobox.setBounds(420, 285, 300, 25);
        destination_combobox.setFont(fields_font);
        destination_combobox.addActionListener(e -> updateFlights());
        add(destination_combobox);

        JPanel buttons_panel = new JPanel();
        buttons_panel.setBounds(0, 350, getWidth(), 50);
        buttons_panel.setBackground(background_color);

        JButton save_button = new JButton("Save", new ImageIcon("src//images//save.png"));
        save_button.setFont(fields_font);
        save_button.setToolTipText("Click to save trip details");
        save_button.addActionListener(e -> handleSave(username , FlightId,ArrivalTime,DepartureTime));
        buttons_panel.add(save_button);

        JButton search_button = new JButton("Search", new ImageIcon("src//images//search.png"));
        search_button.setFont(fields_font);
        search_button.setToolTipText("Click to search trips");
        search_button.addActionListener(e -> handleSearch());
        buttons_panel.add(search_button);

        add(buttons_panel);

        model.addColumn("Flight ID");
        model.addColumn("Source");
        model.addColumn("Destination");
        model.addColumn("Departure Time");
        model.addColumn("Arrival Time");

        JTable tabGrid = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabGrid);
        scrollPane.setBounds(0, 400, getWidth(), getHeight() - 450);
        add(scrollPane);
        tabGrid.setFont(new Font("Chilanka", Font.PLAIN, 16));

        getContentPane().setBackground(background_color);
        tripService = new TripService();
        loadSources();
        setVisible(true);
    }

    private void loadSources() {
        Flights flight= new Flights();
        List<String> sources = flight.Flight_Source();
        for (String source : sources) {
            source_combobox.addItem(source);
        }
    }



    private void updateDestinations() {
        Flights flight= new Flights();
        destination_combobox.removeAllItems();
        String selectedSource = (String) source_combobox.getSelectedItem();
        if (selectedSource != null) {
            List<String> destinations = flight.readDestinationsFromFile(selectedSource);
            for (String destination : destinations) {
                destination_combobox.addItem(destination);
            }
        }
    }



    private void updateFlights() {
        model.setRowCount(0); // Clear existing rows
        String selectedSource = (String) source_combobox.getSelectedItem();
        String selectedDestination = (String) destination_combobox.getSelectedItem();
        if (selectedSource != null && selectedDestination != null) {
            List<String[]> flights = readFlightsFromFile(selectedSource, selectedDestination);
            for (String[] flight : flights) {
                model.addRow(flight);
            }
        }
    }

    private List<String[]> readFlightsFromFile(String source, String destination) {
        String filePath = "src/main/java/com/travel/clientstrips/Flights.txt";
        List<String[]> flights = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length >= 6) {
                    String fileSource = parts[0];
                    String fileDestination = parts[1];
                    if (fileSource.equals(source) && fileDestination.equals(destination)) {
                        flights.add(parts);
                        setStuff(parts[4], parts[3], parts[2], Integer.parseInt(parts[5]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flights;
    }

    private void setStuff(String id, String departure, String arrival, int availability) {
        FlightId = id;
        ArrivalTime = arrival;
        DepartureTime = departure;

    }




    private void handleSave(String username, String tripId, String departure, String arrival) {
        // Get data from input fields
        String tripid = tripId;
        String triptype = (String) triptype_combobox.getSelectedItem();
        String tripdate = tripdate_field.getText();
        String tripduration = tripduration_field.getText();
        String No_passStr = No_pass_field.getText();

        // Parse necessary data
        int numPassengers = Integer.parseInt(No_passStr);
        CalculateFare calculateFare = new CalculateFare();
        int totalProfit = calculateFare.calculateFare(numPassengers, triptype);


        Flights flight= new Flights();
        // Check availability
        if (flight.checkAvailability(tripid, numPassengers)) {
            // Determine if it's a one-way flight
            if (oneWayTripCheckbox.isSelected()) {
                tripduration = "0"; // For one-way flight, set duration to 0
            }

            if (flight.checkAvailability(tripid, numPassengers)) {

                saveFlightToFile(tripid, (String) source_combobox.getSelectedItem(), (String) destination_combobox.getSelectedItem(), triptype,departure , arrival, tripduration, totalProfit, username);
                flight.updateAvailability(tripid, numPassengers);

            }
            // Add to table
            model.addRow(new Object[]{tripid, source_combobox.getSelectedItem(), destination_combobox.getSelectedItem(), arrival, departure, tripdate, tripduration});
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Not enough available seats for this flight.");
        }
    }


    private void saveFlightToFile(String tripid, String source, String destination, String flightType, String departureTime, String arrivalTime, String duration, int totalProfit, String username) {
        String filePath = "src/main/java/com/travel/clientstrips/Trips.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(String.format("%s,%s,%s,%s,%s,%s ,%s,%d,%s",
                    tripid,
                    source,
                    destination,
                    flightType,
                    departureTime,
                    arrivalTime,
                    duration,
                    totalProfit,
                    username
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void handleSearch() {
        JFrame searchWindow = new JFrame("Search Trip");
        searchWindow.setSize(400, 300); // Adjust size as needed
        searchWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the search window

         new SearchTrip();
    }

    private void clearFields() {
        No_pass_field.setText("");
        tripId_field.setText("");
        tripdate_field.setText("");
        tripduration_field.setText("");
        No_pass_field.setText("");
        triptype_combobox.setSelectedIndex(0); // Reset to default option
        oneWayTripCheckbox.setSelected(false); // Reset the checkbox
        source_combobox.setSelectedIndex(-1);
        destination_combobox.setSelectedIndex(-1);
        model.setRowCount(0); // Clear table rows
    }



    public static void main(String[] args) {
        // Launch the application
        SwingUtilities.invokeLater(() -> new AddNewTrip("testUser"));
    }
}

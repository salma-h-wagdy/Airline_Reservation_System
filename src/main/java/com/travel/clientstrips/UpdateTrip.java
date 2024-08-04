package com.travel.clientstrips;





import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UpdateTrip extends JFrame {
	private final JTextField id_field = new JTextField();
	private final JTextField clientname_field = new JTextField();
	private final JTextField tripid_field = new JTextField();
	private final JTextField type_field = new JTextField();
	private final JTextField Tripdate_field = new JTextField();
	private final JTextField Duration_field = new JTextField();
	private final JTextField Price_field = new JTextField();
	private final JTextField Profit_field = new JTextField();
	private final JTextField Detail_field = new JTextField();

	private final DefaultTableModel model = new DefaultTableModel();

	private final TripService tripService;

	public UpdateTrip( String clientId ,String clientname , String tripid, String triptype) {
		super("Postpone Client Trip");
		setSize(950,720);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

		Font font = new Font("Chilanka", Font.BOLD, 20);
		Font fields_font = new Font("Chilanka", Font.PLAIN, 18);
		Color background_color = Color.CYAN;

		JLabel heading = new JLabel("Update Client Trip");
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
		id_field.setToolTipText("Enter Client id");
		id_field.setFont(fields_font);
		add(id_field);







		JLabel l2 = new JLabel("Client name:");
		l2.setBounds(200,160,200,30);
		l2.setFont(font);
		add(l2);

		clientname_field.setBounds(420,160,300,30);
		clientname_field.setToolTipText("Enter Client name");
		clientname_field.setFont(fields_font);
		add(clientname_field);








		JLabel l20 = new JLabel("Trip Id:");
		l20.setBounds(200,210,200,30);
		l20.setFont(font);
		add(l20);

		tripid_field.setBounds(420,210,300,30);
		tripid_field.setToolTipText("Enter Trip Id");
		tripid_field.setFont(fields_font);
		add(tripid_field);








		JLabel l21 = new JLabel("Trip Type:");
		l21.setBounds(200,260,200,30);
		l21.setFont(font);
		add(l21);

		type_field.setBounds(420,260,300,30);
		type_field.setToolTipText("Enter Trip Type");
		type_field.setFont(fields_font);
		add(type_field);







		JLabel l3 = new JLabel("Trip New date:");
		l3.setBounds(200,310,200,30);
		l3.setFont(font);
		add(l3);

		Tripdate_field.setBounds(420,310,300,30);
		Tripdate_field.setFont(fields_font);
		add(Tripdate_field);







		JLabel l4 = new JLabel("Trip Price :");
		l4.setBounds(200,360,200,30);
		l4.setFont(font);
		add(l4);

		Price_field.setBounds(420,360,300,30);
		Price_field.setFont(fields_font);
		add(Price_field);






		JLabel l5 = new JLabel("Trip Duration :");
		l5.setBounds(200,410,200,30);
		l5.setFont(font);
		add(l5);

		Duration_field.setBounds(420,410,300,30);
		Duration_field.setFont(fields_font);
		add(Duration_field);






		JLabel l6 = new JLabel("Trip Detail :");
		l6.setBounds(200,460,200,30);
		l6.setFont(font);
		add(l6);

		Detail_field.setBounds(420,460,300,30);
		Detail_field.setFont(fields_font);
		add(Detail_field);



		id_field.setText(clientId);
		clientname_field.setText(clientname);
		tripid_field.setText(tripid);
		type_field.setText(triptype);
		Tripdate_field.setText("");
		Duration_field.setText("");
		Price_field.setText("");
		Profit_field.setText("");
		Detail_field.setText("");
                
                
	/*	JLabel l4 = new JLabel("Client phone no:");
		l4.setBounds(200,260,200,30);
		l4.setFont(font);
		add(l4);

		Duration_field.setBounds(420,260,300,30);
		Duration_field.setFont(fields_font);
		add(Duration_field);

		JLabel l5 = new JLabel("Client email:");
		l5.setBounds(200,310,200,30);
		l5.setFont(font);
		add(l5);

		Profit_field.setBounds(420,310,300,30);
		Profit_field.setFont(fields_font);
		add(Profit_field);
*/
		JPanel buttons_panel = new JPanel();
		buttons_panel.setBounds(0, 500, getWidth(), 40);
		buttons_panel.setBackground(background_color);

	/*	JButton open_button = new JButton("Open", new ImageIcon("src//images//open.png"));
		open_button.setToolTipText("click to open supplier details");
		open_button.setFont(fields_font);
		open_button.addActionListener(e -> handleOpen());
		buttons_panel.add(open_button); */

		JButton update_button = new JButton("Update", new ImageIcon("src//images//update.png"));
		update_button.setFont(fields_font);
		update_button.setToolTipText("click to update Client trip  details");
		update_button.addActionListener(e -> handleUpdate());
		buttons_panel.add(update_button);

	/*	JButton clear_button = new JButton("Clear", new ImageIcon("src//images//clear.png"));
		clear_button.setToolTipText("click to clear all text fields");
		clear_button.setFont(fields_font);
		clear_button.addActionListener(e -> handleClear());
		buttons_panel.add(clear_button);

		JButton all_button = new JButton("All", new ImageIcon("src//images//all.png"));
		all_button.setToolTipText("click to view all trip details");
		all_button.setFont(fields_font);
		all_button.addActionListener(e -> handleAll());
		buttons_panel.add(all_button);*/

		add(buttons_panel);

	/*	JTable tabGrid = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(tabGrid);
		scrollPane.setBounds(0, 405, getWidth(), getHeight() - 440);
		this.add(scrollPane);
		tabGrid.setFont(new Font ("Chilanka", Font.PLAIN,16));

        
		model.addColumn("Type");
		model.addColumn("Date");
		model.addColumn("Price");
                model.addColumn("Duration");
		model.addColumn("Profit");
		model.addColumn("Details");
*/
		getContentPane().setBackground(background_color);
		tripService = new TripService();
		setVisible(true);

	}

	private UpdateTrip() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	/*	private void handleOpen() {
    //		String id = id_field.getText();
    //		if (id.isBlank()) {
                showMessage("Please enter client id!");
            } else {
                ClientsTrips clienttrip = tripService.getClientTrip(Integer.parseInt(id),clienttrip.getTripid());
                id_field.setText(String.valueOf(clienttrip.getId()));
                type_field.setText(clienttrip.getTriptype());
                Tripdate_field.setText(clienttrip.getTripdate());
                            Duration_field.setText(clienttrip.getDuration());
                            Price_field.setText(clienttrip.getPrice());
                            Profit_field.setText(clienttrip.getProfit());
                            Detail_field.setText(clienttrip.getDetails());

            }
        }
    */
	private void handleUpdate() {
		String id = id_field.getText();
		String type = type_field.getText();
		String tripdate = Tripdate_field.getText();
		String duration = Duration_field.getText();
		String price = Price_field.getText();
		String profit = Price_field.getText();
		String detail = Price_field.getText();

		if(id.isBlank()) {
			showMessage("Please enter Client id!");
		} else if(type.isBlank() || tripdate.isBlank() || duration.isBlank() || price.isBlank()|| profit.isBlank()|| detail.isBlank()) {
			showMessage("* please enter all fields value  !");
		} else {
			//		tripService.updateTrip(id, type, tripdate, duration, price, profit, detail);
			handleClear();
		}
	}

	private void handleClear() {
		id_field.setText("");
		type_field.setText("");
		Tripdate_field.setText("");
		Duration_field.setText("");
		Price_field.setText("");
		Profit_field.setText("");
		Detail_field.setText("");
	}



	private void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message, null, JOptionPane.WARNING_MESSAGE);
	}

	public static void main(String[] args) {
		new UpdateTrip();
	}
}


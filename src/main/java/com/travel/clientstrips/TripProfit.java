/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travel.clientstrips;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SEC
 */



public class TripProfit extends JFrame {
	private final JTextField id_field = new JTextField();
	private final JTextField name_field = new JTextField();
	private final JTextField age_field = new JTextField();
	
        

	private final DefaultTableModel model = new DefaultTableModel();

	private final TripService tripService;

	public TripProfit() {
		super("Search Client Trips");
		setSize(950,720);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

		Font font = new Font("Chilanka", Font.BOLD, 20);
		Font fields_font = new Font("Chilanka", Font.PLAIN, 18);
		Color background_color = Color.CYAN;

		JLabel heading = new JLabel("Trip Profit");
		heading.setFont(new Font("Chilanka",Font.BOLD,30));
		heading.setBounds(0,40,getWidth(),40);
		heading.setHorizontalAlignment(JLabel.CENTER);
		heading.setForeground(Color.blue);
		add(heading);

		
		
            JFrame frame = new JFrame();
            frame.getContentPane().add(new MyComponent());
            frame.setSize(200, 200);
            
            frame.setBounds(600,150,200,200);
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
		model.addColumn("Profit");
		model.addColumn("Details");

              
             
                
		getContentPane().setBackground(background_color);
		tripService = new TripService();
                handleSearch() ;
		setVisible(true);
                frame.setVisible(true);
	}

	private void handleSearch() {
		
		
                    int row = 0;
                    model.setRowCount(0);
			List<ClientsTrips> trips = tripService.getClientTrip();
                         
                  for (ClientsTrips trip: trips) {                       
			model.insertRow(row++, new Object[] {trip.getTripid(),trip.getTriptype(), trip.getTripdate(), trip.getPrice(), trip.getDuration()});
                        //, trip.getProfit(), trip.getDetails()
                                                                        
					                                                                       
		}
	}

	

      
        
         
class Slice {
   double value;
   Color color;
   public Slice(double value, Color color) {  
      this.value = value;
      this.color = color;
   }
}
class MyComponent extends JComponent {
   Slice[] slices = { 
      new Slice(60000, Color.black), new Slice(33000, Color.green), new Slice(60000, Color.yellow), new Slice(91000, Color.red) 
   };
   MyComponent() {}
   public void paint(Graphics g) {
      drawPie((Graphics2D) g, getBounds(), slices);
   }
   void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
      double total = 0.0D;
      
      for (int i = 0; i < slices.length; i++) {
         total += slices[i].value;
      }
      double curValue = 0.0D;
      int startAngle = 0;
      for (int i = 0; i < slices.length; i++) {
         startAngle = (int) (curValue * 360 / total);
         int arcAngle = (int) (slices[i].value * 360 / total);
         g.setColor(slices[i].color);
          g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
         curValue += slices[i].value;
      }
   }
}
        
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message, null, JOptionPane.WARNING_MESSAGE);
	}

	public  void main(String[] args) {
	    
      new TripProfit();
	}
}

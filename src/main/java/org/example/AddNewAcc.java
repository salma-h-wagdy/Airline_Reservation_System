/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import com.travel.clientstrips.ClientsTrips;
import com.travel.clientstrips.Trip;
import com.travel.clientstrips.TripService;
import com.travel.clientstrips.UpdateTrip;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Hp
 */
public class AddNewAcc extends JFrame{
    
    private final JTextField id_field = new JTextField();
    private final JTextField name_field = new JTextField();
   // private final JTextField age_field = new JTextField();
    private final JTextField Birth_date = new JTextField();
    private final JTextField Natinality = new JTextField();
   // private final JTextField No_pass_field = new JTextField();
    
    

  
    public AddNewAcc() {
        
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
		heading.setBounds(0,5,getWidth(),40);
		heading.setHorizontalAlignment(JLabel.CENTER);
		heading.setForeground(Color.blue);
		add(heading);

                    JLabel l0 = new JLabel("Client passport:");
                    l0.setBounds(200,55,200,35);
                    l0.setFont(font);
                    add(l0);

                    id_field.setBounds(420,55,300,35);
                    id_field.setToolTipText("Enter Client passport number");
                    id_field.setFont(fields_font);
                    add(id_field);

                    JLabel l1 = new JLabel("Name:");
                    l1.setFont(font);
                    l1.setBounds(200, 110, 200, 35);
                    add(l1);

                    name_field.setBounds(420, 110, 300, 35);
                    name_field.setToolTipText("Enter your name");
                    name_field.setFont(fields_font);
                    add(name_field);
                    
                    JLabel l2 = new JLabel("Birthdate:");
                    l2.setFont(font);
                    l2.setBounds(200, 165, 200, 35);
                    add(l2);

                    Birth_date.setBounds(420, 165, 300, 35);
                    Birth_date.setToolTipText("Enter your Birthdate");
                    Birth_date.setFont(fields_font);
                    add(Birth_date);
                    
                     JLabel l3 = new JLabel("Nationality:");
                    l3.setFont(font);
                    l3.setBounds(200, 220, 200, 35);
                    add(l3);

                    Natinality.setBounds(420, 220, 300, 35);
                    Natinality.setToolTipText("Enter your Natinality");
                    Natinality.setFont(fields_font);
                    add(Natinality);
                   
                
		getContentPane().setBackground(background_color);
		//tripService = new TripService();
		setVisible(true);
                
                
                JPanel buttons_panel = new JPanel();
        buttons_panel.setBounds(0, 330, getWidth(), 50);
        buttons_panel.setBackground(background_color);
        
        JButton Submit_button = new JButton("Submit", new ImageIcon("src//images//all.png"));
        Submit_button.setFont(fields_font);
        Submit_button.setToolTipText("click to view all trips details");
        Submit_button.addActionListener(e -> register());
        buttons_panel.add(Submit_button);
        
        add(buttons_panel);
	}
    
        private void register(){
            JOptionPane.showMessageDialog(null, "You are registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

	private void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message, null, JOptionPane.WARNING_MESSAGE);
	}

	public static void main(String[] args) {
	    new AddNewAcc();
	}
}

       
       


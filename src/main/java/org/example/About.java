package org.example;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
	public About() {
		super("About Project");
		setSize(900,700);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel l1 = new JLabel("Travel Management System");
		l1.setFont(new Font("Times New Roman",Font.BOLD,35));
		l1.setBounds(200,30,600,40);
		l1.setForeground(Color.blue);
		this.add(l1);

		JLabel l2 = new JLabel("This Project developed by:");
		l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		l2.setBounds(250,150,600,40);
		l2.setForeground(Color.BLACK);
		this.add(l2);

		JLabel l3 = new JLabel("Nancy Amro");
		l3.setFont(new Font("Times New Roman",Font.BOLD,30));
		l3.setBounds(500,150,400,40);
		l3.setForeground(Color.red);
		this.add(l3);

                JLabel l4 = new JLabel("Salma Hisham");
		l4.setFont(new Font("Times New Roman",Font.BOLD,30));
		l4.setBounds(500,200,400,40);
		l4.setForeground(Color.red);
		this.add(l4);
                
                JLabel l5 = new JLabel("Mennatalla Mohamed Samir Abdelatif Ezzelarab");
		l5.setFont(new Font("Times New Roman",Font.BOLD,30));
		l5.setBounds(500,250,400,40);
		l5.setForeground(Color.red);
		this.add(l5);

			JLabel l6 = new JLabel("Menna Ayman Alsaid Geba");
		l6.setFont(new Font("Times New Roman",Font.BOLD,30));
		l6.setBounds(500,250,400,40);
		l6.setForeground(Color.red);
		this.add(l6);
                
                
		JLabel phone = new JLabel("Contact US :");
		phone.setFont(new Font("Times New Roman",Font.BOLD,20));
		phone.setBounds(500,300,600,40);
		phone.setForeground(Color.BLACK);
		this.add(phone);
		
		JLabel call=new JLabel("0020120001011");
		call.setFont(new Font("Times New Roman",Font.BOLD,30));
		call.setBounds(500,350,400,40);
		call.setForeground(Color.red);
		this.add(call);
		
		
	

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new About();
	}
}

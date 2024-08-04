/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Welcom extends JFrame {
          
    //Image img = Toolkit.getDefaultToolkit().getImage(this.getClass().getClassLoader().getResource("images/welcome.jpg"));
    
        public Welcom() throws IOException {
            this.setContentPane(new JPanel() {
            @Override
         public void paintComponent(Graphics g) {
            super.paintComponent(g);           
           // g.drawImage(img, 0, 0, null);
           
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
                
                Font font = new Font("Chilanka", Font.BOLD, 20);
		Font buttons_font = new Font("Chilanka", Font.PLAIN, 18);
		Color background_color = Color.GREEN;    
                
                JButton Login_button = new JButton("Login", new ImageIcon("src\\images\\Login.png"));
                 Login_button.setBounds(400, 600, 120, 40);
                 Login_button.setFont(buttons_font);
                
//                JButton pass_button = new JButton("passenger", new ImageIcon("src\\images\\Login.png"));
//                pass_button.setBounds(400, 600, 120, 40);
//		pass_button.setFont(buttons_font);
                
		Login_button.addActionListener(e -> {
               Login loginWindow = new Login();
               loginWindow.setVisible(true);
            });

          //login_button.setLayout(new GridLayout(1,3,200,0));
                
		this.add(Login_button);
              //  this.add(pass_button);
                        
       
                
                
                
                changeLookAndFeel();
         }
      });
                pack();     
                
                
                 
                  
                  
                setSize(900,700);
                setVisible(true);
   }
   public static void main(String[] args) throws Exception {
      new Welcom().setVisible(true);
   }
   
   
     private void handleLogin() throws IOException {
		
			setVisible(false); // remove the current frame 
                        new MainMenu();
		
	}
     
     private void changeLookAndFeel() {
		UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
		try {
			UIManager.setLookAndFeel(looks[1].getClassName());
			SwingUtilities.updateComponentTreeUI(this);
                        
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
				 IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
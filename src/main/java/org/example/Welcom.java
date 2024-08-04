package org.example;

import com.travel.clientstrips.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.IOException;

public class Welcom extends JFrame {

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

                JButton loginButton = new JButton("Login", new ImageIcon("src\\images\\Login.png"));
                loginButton.setBounds(250, 600, 120, 40);
                loginButton.setFont(buttons_font);
                loginButton.addActionListener(e -> {
                    Login loginWindow = new Login();
                    loginWindow.setVisible(true);
                });

                JButton registerButton = new JButton("Register", new ImageIcon("src\\images\\Register.png"));
                registerButton.setBounds(400, 600, 120, 40);
                registerButton.setFont(buttons_font);
                registerButton.addActionListener(e -> {
                    AddNewAcc registerWindow = new AddNewAcc();
                    registerWindow.setVisible(true);
                });

                this.add(loginButton);
                this.add(registerButton);

                changeLookAndFeel();
            }
        });
        pack();

        setSize(900, 700);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new Welcom().setVisible(true);
    }

    private void handleLogin(String username) throws IOException {
        setVisible(false); // remove the current frame
        new MainMenu(username);
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

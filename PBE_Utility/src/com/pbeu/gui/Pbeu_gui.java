package com.pbeu.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import com.pbeu.encryptor.EncryptedPwdGenerator;


public class Pbeu_gui extends JFrame implements WindowListener,ActionListener {
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		JLabel password_tobe_encrypted_L = new JLabel("Password");
		JLabel confirm_password_L = new JLabel("Confirm Password");
		JLabel encrypted_password_L = new JLabel("Encrypted Password");
		JPasswordField password_tobe_encrypted = new JPasswordField(30);
		JPasswordField confirm_password = new JPasswordField(30);
		JTextField encrypted_password = new JTextField(30);
		
		
        Button b;
        private int numClicks = 0;

        public static void main(String[] args) {			// main method initiating the GUI
                Pbeu_gui myWindow = new Pbeu_gui("My first window");
                myWindow.setSize(500,400);
                myWindow.setVisible(true);
        }

        public Pbeu_gui(String title) {						// constructor to the class

                super(title);
                setLayout(new FlowLayout());
                addWindowListener(this);
                b = new Button("Click me");
                add(password_tobe_encrypted_L);
                add(password_tobe_encrypted);
                add(confirm_password_L);
                add(confirm_password);
                add(encrypted_password_L);
                add(encrypted_password);
                b.addActionListener(this);
                add(b);
        }

        public void actionPerformed(ActionEvent e) {		//Defines what happens when the action is performed 
                numClicks++;
                //password_tobe_encrypted.setText("Button Clicked " + numClicks + " times");
                if(!password_tobe_encrypted.getText().isEmpty()) {
                	if(!confirm_password.getText().isEmpty()) {
                		if((password_tobe_encrypted.getText().compareTo(confirm_password.getText())==0)){
		                	encrypted_password.setText(password_tobe_encrypted.getText());
		                	String Plainpassword = password_tobe_encrypted.getText();
		                	String encryptedPassword_str = new String();
		                	String key = "8C517A2B3CEAA6B3262AF5CF473FD629";
		                	try {
		                		encryptedPassword_str = EncryptedPwdGenerator.EncryptPassword(key, Plainpassword);
							} catch (InvalidKeyException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (NoSuchAlgorithmException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (NoSuchPaddingException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (InvalidAlgorithmParameterException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IllegalBlockSizeException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (BadPaddingException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                	
		                	encrypted_password.setText(encryptedPassword_str);
		                }
                		else {
                			JOptionPane.showMessageDialog(this,"confirm password does not match password field", "", JOptionPane.ERROR_MESSAGE);
                			encrypted_password.setText(null);
                		}
                	}
                	else {
                    	JOptionPane.showMessageDialog(this,"Plase confirm password", "", JOptionPane.ERROR_MESSAGE);
                    	encrypted_password.setText(null);
                    } 
	                
                }
                else {
                	JOptionPane.showMessageDialog(this,"Plase enter a password", "", JOptionPane.ERROR_MESSAGE);
                	encrypted_password.setText(null);
                }
                }

        public void windowClosing(WindowEvent e) {			// Defines what happens when the window is closed
                dispose();
                System.exit(0);
        }
        

		// methods if you like to define what happens for different window actions
        public void windowOpened(WindowEvent e) {
        	//password_tobe_encrypted.setText("password goes here");
        	//encrypted_password.setText("password after encryption");
        }	
        
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}

}
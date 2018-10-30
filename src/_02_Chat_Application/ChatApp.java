package _02_Chat_Application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp {
	public static void main(String[] args) {
		String ip = "192.168.7.133";
		int portnum = 8080;
		try {
			while (true) {
				Socket s = new Socket(ip, portnum);
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				
				dos.writeUTF(JOptionPane.showInputDialog("Enter something: "));
				DataInputStream dis = new DataInputStream(s.getInputStream());
				System.out.println(dis.readUTF());
			}
			
		}
		catch(IOException e) {
			
		}
	}
}

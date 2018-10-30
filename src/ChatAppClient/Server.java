package ChatAppClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.swing.JOptionPane;

public class Server {
	ServerSocket ss;
	public Server() throws IOException{
		ss = new ServerSocket(8080);
	}
	public void run() {
		boolean bool = true;
		while (bool) {
			try {
				System.out.println("Waiting for connection...");
				Socket serverSocket = ss.accept();
				System.out.println("Connected...");
				DataInputStream dis = new DataInputStream(serverSocket.getInputStream());
				System.out.println(dis.readUTF());
				DataOutputStream dos = new DataOutputStream(serverSocket.getOutputStream());
				JOptionPane.showInputDialog("Enter your message: ");
				serverSocket.close();
			}
			catch (SocketTimeoutException e) {
				System.out.println("Time out");
				bool = false;
			}
			catch(IOException e1) {
				System.out.println("IOException");
				bool = false;
			}
			System.out.println("IOException");
			bool = false;
		}
	}
	public static void main(String[] args) {
		Thread t = new Thread(()->{
			Server s;
			try {
				s = new Server();
				s.run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t.start();
	}
}

package com.common.oa.socket;


import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;

public class ChatServer {

	private static Long count = 0L;
	DataInputStream dis = null;

	private List<Client> clients = new ArrayList<Client>();
	
	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.start();
	}

	private void start() {
		boolean flag = false;
		ServerSocket server = null;
		try {
			server = new ServerSocket(7033);
			System.out.println("Chat> Wait for a client to connect.....");
			flag = true;
		}catch(BindException e){
			System.out.println("ERROR:" + "The program has been running, please close the program!");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Socket socket = null;
		try {
			while(flag){
				socket = server.accept();
				System.out.println("Chat> " + socket.getInetAddress() +"The client connection is successful, the current number of clients:"+(++count));
				Client client = new Client(socket);
				new Thread(client).start();
				clients.add(client);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	class Client implements Runnable {

		private Socket socket = null;
		private DataInputStream dis = null;
		boolean flag = false;
		public Client(Socket socket){
			this.socket = socket;
			try {
				this.dis = new DataInputStream(this.socket.getInputStream());
				flag = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void send(){
			try{
				String line = dis.readUTF();
				System.out.println("Chat> " + socket.getInetAddress() + ":" + line);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		public void run() {
			
			try{
				while(flag){
					for(Client client : clients){
						client.send();
					}
				}
			} catch(Exception e) {
				System.out.println("Chat> " + socket.getInetAddress() + "Exit connection, the number of clients:" + (--count));
			}finally{
				try {
					if(dis!=null) dis.close();
					if(socket!=null) socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	
}

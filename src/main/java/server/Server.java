package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import dao.PositionDAO;
import dao.impl.PositionImpl;
import entity.Position;

public class Server {
	
	public static void main(String[] args) {
		
		try (ServerSocket server = new ServerSocket(9431)) {
			
			System.out.println("Server is running on port 9431..");
			
			while (true) {
				Socket socket = server.accept();
				Server temp = new Server();
				System.out.println("Client connected");
				System.out.println("Client IP: " + socket.getInetAddress().getHostName());
				System.out.println("Client Port: " + socket.getPort());
				
				new Thread(temp.new Handler(socket) ).start();
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	private class Handler implements Runnable {

		private Socket socket;
		
		private PositionDAO positionDAO;

		public Handler(Socket socket) {
			super();
			this.socket = socket;
			this.positionDAO = new PositionImpl();
		}

		@Override
		public void run() {
			System.out.println("Client connected");
			System.out.println("Client IP: " + socket.getInetAddress().getHostName());
			System.out.println("Client Port: " + socket.getPort());
			
			try (DataInputStream ins = new DataInputStream(socket.getInputStream());
				 ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())){
				
				int choice = 0;
				while (true) {
					choice = ins.readInt();
					switch (choice) {
					case 1:
						String name = ins.readUTF();
						double minSalary = ins.readDouble();
						double maxSalary = ins.readDouble();
						List<Position> listPos = positionDAO.listPositions(name, minSalary, maxSalary);
						out.writeObject(listPos);
						break;
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}

	}

}

package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.Position;

public class Client {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		try (Socket socket = new Socket("localhost", 9431);
				Scanner sc = new Scanner(System.in);
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ) {
			while (true) {
				System.out.println("========== NHẬP LỰA CHỌN CỦA BẠN ==========\n"
						+ "1. Liệt kê danh sách các vị trí công việc khi biết tên vị trí (tìm tương đối) và mức lương khoảng từ.\n"
						);
				int choice = 0;
				choice = sc.nextInt();
				out.writeInt(choice);
				out.flush();
				switch (choice) {
				case 1:
					System.out.println("Nhập vào tên vị trí: ");
					sc.nextLine();
					String name = sc.nextLine();
					out.writeUTF(name);
					
					System.out.println("Nhập vào mức lương bắt đầu: ");
					double minSalary = sc.nextDouble();
					out.writeDouble(minSalary);
					
					System.out.println("Nhập vào mức lương kết thúc: ");
					double maxSalary = sc.nextDouble();
					out.writeDouble(maxSalary);
					
					List<entity.Position> positions = (List<entity.Position>) in.readObject();
					System.out.println(positions);
					break;
				}
			}
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		catch (IOException e) {	
			e.printStackTrace();
		}
		
	}

}

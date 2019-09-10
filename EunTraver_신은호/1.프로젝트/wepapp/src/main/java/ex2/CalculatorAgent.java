package ex2;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorAgent {
	Socket socket = null;
	PrintStream out = null;
	Scanner in = null;
	double r;
	public CalculatorAgent(String ip,int port) throws Exception {
		socket = new Socket(ip,port);
		out = new PrintStream(socket.getOutputStream());
		in = new Scanner(socket.getInputStream());
	}
	
	public double compute(String operator, double a, double b) throws Exception{
		try {
			out.println(operator);
			out.println(a);
			out.println(b);
			out.flush();
			System.out.println(a);
			System.out.println(b);
			System.out.println(operator);
			String state = in.nextLine();
			if(state.equals("success")) {
				return Double.parseDouble(in.nextLine());
			} else {
				throw new Exception(in.nextLine());
			}
		}catch(Exception e) {
			throw e;
		}
	}
	public void close() {
		try {
			out.println("goodbye");
			System.out.println(in.nextLine());
		} catch(Exception e) {
			
		}
		try {out.close();} catch(Exception e) {}
		try {in.close();} catch(Exception e) {}
		try {socket.close();} catch(Exception e) {}
	}
}
